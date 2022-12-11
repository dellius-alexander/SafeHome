package com.example.safehome

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.safehome.databinding.ActivityLoginPageBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import okhttp3.*
import org.json.JSONObject
import java.io.IOException
import java.security.KeyManagementException
import java.security.NoSuchAlgorithmException
import javax.net.ssl.*


class LoginPage : AppCompatActivity() {
    private lateinit var loginPageBinding: ActivityLoginPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginPageBinding = ActivityLoginPageBinding.inflate(layoutInflater)
        val view = loginPageBinding.root
        val signUpButton = loginPageBinding.signUpButton
        val loginButton = loginPageBinding.loginButton
        setContentView(view)
        Toast.makeText(this, "Connected", Toast.LENGTH_LONG).show()

        signUpButton.setOnClickListener {
            val signUpIntent = Intent(this, SignUpPage::class.java)
            startActivity(signUpIntent)
        }

        loginButton.setOnClickListener {

            loginUserAccount()
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        Toast.makeText(this, "Please Login", Toast.LENGTH_LONG).show()
        return
    }

    private fun loginUserAccount(){
        try {

            val userId = loginPageBinding.userID.text.toString()
            val password = loginPageBinding.password.text.toString()

            if (TextUtils.isEmpty(userId)) {
                Toast.makeText(this, "Please enter username", Toast.LENGTH_LONG).show()
                return
            }

            if (TextUtils.isEmpty(password)) {
                Toast.makeText(this, "Please enter password", Toast.LENGTH_LONG).show()
                return
            }


            var jsonBody: JSONObject?  = null
            /**
             * Execute login attempt
             */
            runBlocking {
                val job = launch(Dispatchers.Default) {
                    println("${Thread.currentThread()} has run.")
                    /**
                     * Capture the response
                     */
                    jsonBody = SafeHomeUserAPI.login(userId, password)
                }
                job.start()
            }

            /**
             * Check response body for success or error message and send to client via toast message
             */
            if (jsonBody!!.has("successMsg")) {
                Toast.makeText(this, jsonBody!!.get("successMsg").toString(), Toast.LENGTH_LONG).show()
                val homepage = Intent(this, HomePage::class.java)
                homepage.putExtra("emailId", jsonBody!!.get("name").toString())
                homepage.putExtra("nameId", jsonBody!!.get("username").toString())
                startActivity(homepage)
            } else if (jsonBody!!.has("error") || jsonBody!!.has("errorMessage")){
                Toast.makeText(this, jsonBody!!.get("error").toString(), Toast.LENGTH_LONG).show()
                startActivity(Intent(this, LoginPage::class.java))
            }else if (jsonBody!!.has("errorMessage")){
                Toast.makeText(this, "Login failed, please try again...", Toast.LENGTH_LONG).show()
                startActivity(Intent(this, LoginPage::class.java))
            }

        } catch (e: IOException) {
            println(e.message)
            e.printStackTrace()
            Toast.makeText(this, "Please Try Login Again...", Toast.LENGTH_LONG).show()
            // reset login process if client fails login attempt
            startActivity(Intent(this, LoginPage::class.java))
        } catch (e: NoSuchAlgorithmException) {
            println(e)
            // reset login process if client fails login attempt
            startActivity(Intent(this, LoginPage::class.java))
        } catch (e: KeyManagementException) {
            println(e)
            // reset login process if client fails login attempt
            startActivity(Intent(this, LoginPage::class.java))
        } catch (e: Exception) {
            println(e)
            // reset login process if client fails login attempt
            startActivity(Intent(this, LoginPage::class.java))
        }
    }

}






