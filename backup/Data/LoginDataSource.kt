package com.example.safehome.Data


import com.example.safehome.Data.model.LoggedInUser
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.http.cio.*
import okhttp3.*
import okhttp3.Request
import okhttp3.Response
import java.io.IOException
import java.util.*
import java.util.concurrent.TimeUnit
import javax.net.ssl.HostnameVerifier
import javax.net.ssl.HttpsURLConnection
import kotlin.system.exitProcess


/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource {

    private val client = OkHttpClient()

//        .Builder()
//        .hostnameVerifier { hostname, session ->
//            val hv = HttpsURLConnection.getDefaultHostnameVerifier()
//            true
//        }
//        .connectTimeout(100, TimeUnit.SECONDS)
//        .readTimeout(100, TimeUnit.SECONDS).build()


    fun login(username: String, password: String): Result<LoggedInUser> {
        try {

            // TODO: handle loggedInUser authentication
            println("Attempting")
            println(client)

            val url = "https://delliusalexander.com/api/v1/user/login/?"
            println(url)

            val formBody = FormBody.Builder()
                .add("username", username)
                .add("password", password)
                .build()

            val request = Request.Builder()
                .url(url)
                .addHeader("Content-Type:", "application/x-www-form-urlencoded")
                .addHeader("Content-Type:", "application/json")
                .addHeader("Content-Type:", "*/*")
                .post(formBody)
                .build()
            var svrResponse: Response
            client.newCall(request).execute().use { response ->
                if (!response.isSuccessful) throw IOException("Unexpected code $response")
                println(response.toString())
                svrResponse = response
            }

//            val request = Request.Builder().url(url).get().build()
//            println(request)

//            client.newCall(request).enqueue(object : Callback {
//
//                override fun onResponse(call: Call, response: Response) {
//                    val body = response.body()
//                    println(response.toString())
//                    println(body.toString())
//                }
//
//                override fun onFailure(call: Call, e: IOException) {
//                    println("Failed to execute request")
//                    println(e)
//                }
//            })

//            exitProcess(0)
            val fakeUser = LoggedInUser(UUID.fromString(username.toString()).toString(), username)
            return Result.Success(fakeUser)
        } catch (e: Throwable) {
            return Result.Error(IOException("Error logging in", e))
        }
    }

    fun logout() {
        // TODO: revoke authentication
    }
}

private  fun OkHttpClient.setHostnameVerifier(hostnameVerifier: HostnameVerifier) {

}

//private  fun OkHttpClient.setHostnameVerifier(hostnameVerifier: HostnameVerifier, session: SSLSession): Boolean {
//    return hostnameVerifier.verify("*.safehome.com", session)
//}