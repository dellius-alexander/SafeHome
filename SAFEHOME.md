# SafeHome

[![SafeHome Index](docs/img.png)](docs/img.png "SafeHome Index")

```kotlin
package com.example.safehome

import android.util.Base64
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import okio.ByteString.Companion.decodeBase64
import org.apache.http.conn.ssl.SSLSocketFactory
import org.json.JSONObject
import java.io.IOException
import java.security.*
import java.security.cert.CertificateException
import java.security.cert.X509Certificate
import java.security.spec.X509EncodedKeySpec
import javax.crypto.Cipher
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager


object SafeHomeAPI {
    private var client: OkHttpClient.Builder? = null


    /**
     * Bypass server certificate checks by setting up your own trust manager.
     * @return
     * @throws NoSuchAlgorithmException
     * @throws KeyManagementException
     */
    @get:Throws(
        NoSuchAlgorithmException::class,
        KeyManagementException::class
    )
    /**
     * let's configure the OkHttpClient that trusts a certificate regardless of
     * its nature – CA-signed or self-signed.
     *
     * First, we need to create our own TrustManager that nullifies the default
     * certificate validations and overrides those with our custom implementation:
     */
    val trustAllCertsClient: OkHttpClient
        get() = try {
            val trustAllCerts = arrayOf<TrustManager>(
                object : X509TrustManager {
                    @Throws(CertificateException::class)
                    override fun checkClientTrusted(
                        chain: Array<X509Certificate>,
                        authType: String
                    ) {
                    }

                    @Throws(CertificateException::class)
                    override fun checkServerTrusted(
                        chain: Array<X509Certificate>,
                        authType: String
                    ) {
                    }

                    override fun getAcceptedIssuers(): Array<X509Certificate> {
                        return arrayOf()
                    }
                }
            )
            /**
             * Next, we'll use the above TrustManager to initialize an SSLContext, and
             * also set the OkHttpClient builder's SSLSocketFactory:
             */
            val sslContext = SSLContext.getInstance(SSLSocketFactory.SSL)
            sslContext.init(null, trustAllCerts, SecureRandom())
            val sslSocketFactory = sslContext.socketFactory

            client = OkHttpClient.Builder()
            client!!.sslSocketFactory(sslSocketFactory, trustAllCerts[0] as X509TrustManager)
            /**
             * It won't be hard to believe that even after the above tweaks, consuming
             * the HTTPS URL throws an error. This is due to a well-known problem – the
             * hostname verification failure. Most of the HTTP libraries perform hostname
             * verification against the certificate's SubjectAlternativeName's DNS Name
             * field, which is unavailable in the server's self-signed certificate.
             * The last step towards configuring the OkHttpClient correctly is to disable
             * the default HostnameVerifier and replace it with another one that bypasses
             * the hostname verification.
             */
            client!!.hostnameVerifier { hostname, session -> true }
            client!!.build()
        } catch (e: Exception) {
            throw RuntimeException(e)
        }

    /**
     * Initiate a login attempt.
     * @param username the username
     * @param password the password
     * @return [Response]
     */
    fun login(username: String, password: String): JSONObject? {
        var jsonReponseBody: JSONObject?  = null
        try {
            val newClient = trustAllCertsClient
            println("Attempting login..................................................")
            val request = Request.Builder()
                .url("https://10.0.0.191:443/api/v1/user/login/?")
                // using basic authentication to further encrypt our credentials over https
                // adding another layer of encryption
                .addHeader("Authorization", Credentials.basic(username, password, Charsets.UTF_8))
                .build()

            println("Request Object: ${request.toString()}")
            val response =  newClient.newCall(request).execute()
            var jsonStringData: String? = null

            // check server response
            if(response === null){
                throw NullPointerException("Response body is null.  Incorrect login attempt or server error need further analysis.")
            } else {
                jsonStringData = response!!.body?.string()
                jsonReponseBody = jsonStringData?.let { JSONObject(it) }
                println("Json Object: ")
                println(jsonReponseBody)

            }

        } catch (e: IOException) {
            System.err.println(e)
            return null
        } catch (e: NoSuchAlgorithmException) {
            System.err.println(e)
            return null
        } catch (e: KeyManagementException) {
            System.err.println(e)
            return null
        }
        return jsonReponseBody
    }

    private fun loadPublicKey(key: String): PublicKey? {
        var publicKey: PublicKey?  = null
        runBlocking {
            val job = launch(Dispatchers.Default) {
                println("${Thread.currentThread()} has run.")
                publicKey = withContext(Dispatchers.IO) {

                    val readString = key.replace("-----BEGIN PUBLIC KEY-----", "")
                        .replace("-----END PUBLIC KEY-----", "")

                    val encoded = Base64.decode(readString, Base64.DEFAULT)

                    KeyFactory.getInstance("RSA")
                        .generatePublic(X509EncodedKeySpec(encoded))
                }
            }
            job.start()
        }
        return publicKey
    }


    /**
     * Registers a new user account
     * @param name concatenated first and last name
     * @param email user email address
     * @param dob user date of birth
     * @param password user password
     * @return [Response]
     */
    fun register(
        name: String?,
        email: String?,
        dob: String?,
        password: String?): Response? {
        try {
            val newClient = trustAllCertsClient
            val jsonRequest: JSONObject = JSONObject("""{
                "name":"$name",
                "email":"$email",
                "dob":"$dob",
                "password":"$password"
                }""".trimMargin())

            var request = Request.Builder()
                .url("https://10.0.0.191:443/api/v1/certificate")
                .get()
                .build()
            println("Request Object: ${request.toString()}")
            var response = newClient.newCall(request).execute()

            // check server response
            if(response === null){
                throw NullPointerException("Response body is null.  Incorrect login attempt or server error need further analysis.")
            }


            val jsonKey = response!!.body?.string()?.let { JSONObject(it) }
            println("Json Object: ")
            println(jsonKey!!.get("publicKey"))
//            val keySize = jsonKey!!.get("publicKey").toString().encodeToByteArray().size
//            val publicBytes: ByteArray = jsonKey!!.get("publicKey").toString().encodeToByteArray(26,keySize-25)
//            println(publicBytes.toString(Charsets.UTF_8))
//            val keySpec = X509EncodedKeySpec(publicBytes)
//            val keyFactory: KeyFactory = KeyFactory.getInstance("RSA")
            val pubKey: PublicKey? = loadPublicKey(jsonKey!!.get("publicKey").toString())
            println("Public Key: $pubKey")

            val cipher: Cipher = Cipher.getInstance("RSA") //or try with "RSA"
            cipher.init(Cipher.ENCRYPT_MODE, pubKey)
            val encrypted = cipher.doFinal(jsonRequest.toString().toByteArray())
            val encoded = Base64.encodeToString(encrypted.toString().toByteArray(), Base64.DEFAULT)


            println("Encrypted Message....................................................")
            println(encoded.toString())
            println("Attempting Register..................................................")
            val body = RequestBody.create("Content-Type: application/json; utf-8;"
                            .toMediaTypeOrNull(), JSONObject("""{
                                "secureMessage":"$encoded"
                                }""".trimMargin()).toString())
            request = Request.Builder()
                .url("https://10.0.0.191:443/api/v1/user/register/")
                .post(
                    body = body
                )
                .build()
            println("Request Object: $request")
            return newClient.newCall(request).execute()

        } catch (e: IOException) {
            System.err.println(e)
            return null
        } catch (e: NoSuchAlgorithmException) {
            System.err.println(e)
            return null
        } catch (e: KeyManagementException) {
            System.err.println(e)
            return null
        }
    }

    fun test(url: String?): Response? {
        val response: Response
        try {
            val newClient = trustAllCertsClient
            System.out.printf("Attempting Test..........................................")
            val request = Request.Builder()
                .url(url!!)
                .build()
            System.out.printf("Request Object: $request")
            response = newClient.newCall(request).execute()
            println(response.toString())
        } catch (e: IOException) {
            System.err.println(e)
            return null
        } catch (e: NoSuchAlgorithmException) {
            System.err.println(e)
            return null
        } catch (e: KeyManagementException) {
            System.err.println(e)
            return null
        }
        return response
    }


}
```