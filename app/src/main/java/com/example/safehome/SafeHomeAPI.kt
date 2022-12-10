package com.example.safehome


import android.util.Base64
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaType
import org.apache.http.conn.ssl.SSLSocketFactory
import org.json.JSONObject
import java.io.ByteArrayInputStream
import java.io.IOException
import java.io.InputStream
import java.security.*
import java.security.cert.Certificate
import java.security.cert.CertificateException
import java.security.cert.CertificateFactory
import java.security.cert.X509Certificate
import java.security.spec.X509EncodedKeySpec

import javax.crypto.Cipher
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager



class SafeHomeAPI {
    /**
     * Http client used to make server calls.
     */
    private var client: OkHttpClient.Builder? = null

    /**
     * Bypass server certificate checks by setting up your own trust manager.
     * Configure an OkHttpClient that trusts a certificate regardless of
     * its nature – CA-signed or self-signed.
     *
     * First, we need to create our own TrustManager that nullifies the default
     * certificate validations and overrides those with our custom implementation.
     *
     * TODO: Only used during development and testing.  Please disable this operation for production.
     *
     * @return [OkHttpClient]
     * @throws NoSuchAlgorithmException
     * @throws KeyManagementException
     */
    @get:Throws(
        NoSuchAlgorithmException::class,
        KeyManagementException::class
    )
    private val trustAllCertsClient: OkHttpClient
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
        var request: Request? = null
        var jsonStringData: String? = null
        try {
            // get server public key
            val serverPublicKey = getPublicKeyFromServer();
            println("Json Object: ")
            println(serverPublicKey)
            // create json message to register new user
            val jsonRequest = JSONObject("""{
                        "email":"$username",
                        "password":"$password"
                        }""".trimMargin()).toString()
            // encrypt the json message
            val encodedStringMessage = encryptMessage(jsonRequest, serverPublicKey!!)

            println("Encrypted Message....................................................")
            println(encodedStringMessage)
            println("Attempting Login.....................................................")

            // get the custom client
            val newClient = trustAllCertsClient

            // create a form body and encode our message
            val formBody: RequestBody = FormBody.Builder()
                .addEncoded("secureMessage", encodedStringMessage!!)
                .build()

            // build the request object with our url and form body
            request = Request.Builder()
                .url("https://10.0.0.191:443/api/v1/user/login/?")
                .post( body = formBody )
                .build()

            println("Request Object: $request")

            // get the server response
            val response =  newClient.newCall(request).execute()


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
        password: String?): JSONObject? {
        var jsonResponseBody: JSONObject? = null
        var request: Request? = null
        var response: Response? = null
        try {
            val newClient = trustAllCertsClient

            // get server public key
            val serverPublicKey = getPublicKeyFromServer();
            println("Json Object: ")
            println(serverPublicKey)
            // create json message to register new user
            val jsonRequest = JSONObject("""{
                        "name":"$name",
                        "email":"$email",
                        "password":"$password",
                        "dob":"$dob"
                        }""".trimMargin()).toString()
            // encrypt the json message
            val encodedStringMessage = encryptMessage(jsonRequest, serverPublicKey!!)

            println("Encrypted Message....................................................")
            println(encodedStringMessage)
            println("Attempting Register..................................................")
            // create a form body and encode our message
            val formBody: RequestBody = FormBody.Builder()
                .addEncoded("secureMessage", encodedStringMessage!!)
                .build()
            // build the request object with our url and form body
            request = Request.Builder()
                .url("https://10.0.0.191:443/api/v1/user/register/?")
                .post( body = formBody )
                .build()
            println("Request Object: $request")
            // send the request and return the response body as json object
            response = newClient.newCall(request).execute()
            // check server response
            if(response === null){
                throw NullPointerException("Response body is null.  Incorrect login attempt or server error need further analysis.")
            }
            // convert response body to json
            jsonResponseBody = response!!.body?.string()?.let { JSONObject(it) }
            println("Response Body....................................................")
            println(jsonResponseBody)
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
        return jsonResponseBody
    }

    private fun getPublicKeyFromServer(): String? {
        var serverPublicKey: String? = null
        try {
            val newClient = trustAllCertsClient

            /**
             * Get the server certificate
             */
            var request = Request.Builder()
                .url("https://10.0.0.191:443/api/v1/certificate")
                .get()
                .build()

            println("Request Object: ${request.toString()}")
            // get the server response
            var response = newClient.newCall(request).execute()

            // check server response
            if(response === null){
                throw NullPointerException("Response body is null.  Incorrect login attempt or server error need further analysis.")
            }
            // extract the certificate key json form
            val jsonKey = response!!.body?.string()?.let { JSONObject(it) }
            // get the certificate key object from the json object
            serverPublicKey = jsonKey!!.get("publicKey").toString()
            println("Json Object: ")
            println(serverPublicKey)
        } catch (e: Exception){
            println(e)
            e.printStackTrace()
        }
        return serverPublicKey
    }

    /**
     * Below are the defined Media Types used for transport.
     * See Mime Types: https://developer.mozilla.org/en-US/docs/Web/HTTP/Basics_of_HTTP/MIME_types/Common_types
     */
    companion object {
        private val MEDIA_TYPE_PNG = "image/png".toMediaType()
        private val MEDIA_TYPE_APP_JSON = "application/json".toMediaType()
        private val MEDIA_TYPE_XML = "application/xml".toMediaType()
        private val MEDIA_TYPE_X_WWW_FORM_URLENCODED = "application/x-www-form-urlencoded".toMediaType()

        /**
         * Loads a public key from its string value
         * @param key [String] the public key string
         * @return [Key]
         */
        private fun loadPublicKey(key: String): Key? {
            println("Attempting to load public key")
            var publicKey: Key?  = null
            try {
                runBlocking {// create child thread off main thread
                    val job = launch(Dispatchers.Default) {
                        println("${Thread.currentThread()} has run.")
                        publicKey = withContext(Dispatchers.IO) {
                            val encodedData = Base64
                                .decode(
                                    key
                                        .replace("-----BEGIN PUBLIC KEY-----","")
                                        .replace("-----END PUBLIC KEY-----","")
                                        .toByteArray(),
                                    Base64.DEFAULT
                                )
                            return@withContext KeyFactory
                                .getInstance("RSA")
                                .generatePublic(X509EncodedKeySpec(encodedData))
                        }
                    }
                    job.start()
                }
            } catch (e: Exception){
                println(e)
                e.printStackTrace()
            }
            println("PUBLIC KEY: ")
            println(publicKey.toString())
            return publicKey
        }

        /**
         * Encrypt data using public key.
         * @param plainText [String] plain text string to be encrypted
         * @param publicKey [String] public key string
         * @return [String] the encrypted message
         */
        @Throws(Exception::class)
        fun encryptMessage(plainText: String, publicKey: String): String? {
            println("Attempting to encrypt message")
            var encodedString: String? = null
            try {
                /**
                 * Transformation:
                 * AES/CBC/NoPadding (128)
                 * AES/CBC/PKCS5Padding (128)
                 * AES/ECB/NoPadding (128)
                 * AES/ECB/PKCS5Padding (128)
                 * DES/CBC/NoPadding (56)
                 * DES/CBC/PKCS5Padding (56)
                 * DES/ECB/NoPadding (56)
                 * DES/ECB/PKCS5Padding (56)
                 * DESede/CBC/NoPadding (168)
                 * DESede/CBC/PKCS5Padding (168)
                 * DESede/ECB/NoPadding (168)
                 * DESede/ECB/PKCS5Padding (168)
                 * RSA/ECB/PKCS1Padding (1024, 2048)
                 * RSA/ECB/OAEPWithSHA-1AndMGF1Padding (1024, 2048)
                 * RSA/ECB/OAEPWithSHA-256AndMGF1Padding (1024, 2048)
                 */
                val cipher = Cipher.getInstance("RSA/None/OAEPWITHSHA-256ANDMGF1PADDING")
                cipher.init(Cipher.ENCRYPT_MODE, loadPublicKey(publicKey))
                encodedString = Base64
                    .encodeToString(cipher.doFinal(plainText.toByteArray()), Base64.URL_SAFE)
            } catch (e: Exception){
                println(e)
                e.printStackTrace()
            }
            println("Encoded Message....................................................")
            println(encodedString)
            return encodedString
        }

        /**
         * Convert String value of the Certificate to formatted X509 Certificate.
         * @param certificate [String] the string format of the certificate
         * @param algorithm [String] the algorithm to use for encryption, i.e. RSA, X509, AES, and so on.
         * @return [PublicKey] the public key retrieved
         */
        private fun convertStringToX509Cert(certificate: String, algorithm: String): PublicKey? {
            var publicKey: PublicKey? = null
            var certCollection: Collection<*>? = null
            try {
                val certificateByteArray = certificate
                    .toByteArray()
                val targetStream: InputStream = ByteArrayInputStream(certificateByteArray)
                certCollection = listOf(
                    CertificateFactory
                        .getInstance(algorithm)
                        .generateCertificate(targetStream)
                )
                val i = certCollection.iterator()
                while (i.hasNext()) {
                    val cert = i.next() as Certificate
                    println("Certificate Type: ${ cert.type }")
                    println(cert.type)
                    if (cert.type.contains("PUBLIC")){
                        publicKey = cert.publicKey
                    }
                }
            } catch (e: CertificateException){
                println(e)
                e.printStackTrace()
            }
            println(certCollection.toString())
            return publicKey
        }



    }

}