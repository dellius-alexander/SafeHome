package com.example.safehome

import okhttp3.*
import org.apache.http.conn.ssl.SSLSocketFactory
import org.json.JSONObject
import java.io.IOException
import java.security.KeyManagementException
import java.security.NoSuchAlgorithmException
import java.security.SecureRandom
import java.security.cert.CertificateException
import java.security.cert.X509Certificate
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
    fun login(username: String?, password: String?): Response? {
        try {
            val newClient = trustAllCertsClient
            println("Attempting login..................................................")
            val request = Request.Builder()
                .url("https://10.0.0.191:443/api/v1/user/login/?email=$username&password=$password")

//                .url("http://10.0.0.191:8080/api/v1/user/login/?email=$username&password=$password")
                .build()
            println("Request Object: ${request.toString()}")
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

            println("Attempting Register..................................................")
            val request = Request.Builder()
                .url("https://10.0.0.191:443/api/v1/user/register/?")
                .post(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), jsonRequest.toString()))
                .build()
            println("Request Object: ${request.toString()}")
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
                .url(url)
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