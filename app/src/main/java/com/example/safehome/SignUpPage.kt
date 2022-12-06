package com.example.safehome


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.example.safehome.databinding.ActivitySignUpPageBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import okhttp3.Response
import org.json.JSONObject
import java.io.IOException
import java.security.KeyManagementException
import java.security.NoSuchAlgorithmException

class SignUpPage : AppCompatActivity() {
    private lateinit var signUpPageBinding: ActivitySignUpPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        signUpPageBinding = ActivitySignUpPageBinding.inflate(layoutInflater)
        val view = signUpPageBinding.root
        setContentView(view)
        val submit = signUpPageBinding.submit
        submit.setOnClickListener {
            registerNewUser()
        }
    }

    private fun registerNewUser() {

        val firstName = signUpPageBinding.firstName.text.toString()
        val lastName = signUpPageBinding.lastName.text.toString()
        val mailAddr = signUpPageBinding.email.text.toString()
        val dob = signUpPageBinding.DOB.text.toString()
        val pwd = signUpPageBinding.password.text.toString()
        val confirmPWD = signUpPageBinding.confirmPassword.text.toString()

        if (TextUtils.isEmpty(firstName)) {
            Toast.makeText(this, "Please enter First Name", Toast.LENGTH_LONG).show()
            return
        }

        if (TextUtils.isEmpty(lastName)) {
            Toast.makeText(this, "Please enter Last Name", Toast.LENGTH_LONG).show()
            return
        }

        if (TextUtils.isEmpty(mailAddr)) {
            Toast.makeText(this, "Please enter E-mail", Toast.LENGTH_LONG).show()
            return
        }

        if (TextUtils.isEmpty(dob)) {
            Toast.makeText(this, "Please enter Date of Birth", Toast.LENGTH_LONG).show()
            return
        }

        if (pwd != confirmPWD) {
            Toast.makeText(this, "Password did not match", Toast.LENGTH_LONG).show()
            return
        }

        try {
            var response: Response? = null
            var jsonStringData: String? = null
            var jsonResponseBody: JSONObject? = null

            runBlocking {
                val job = launch(Dispatchers.Default) {
                    println("${Thread.currentThread()} has run.")
                    /**
                     * Capture the response
                     */
                    response = SafeHomeAPI.register(firstName + " " + lastName, mailAddr, dob, pwd)
                    // check the initial response
                    if(response === null){
                        throw NullPointerException("Response body is null.  Incorrect login attempt or server error need further analysis.")
                    } else {
                        jsonStringData = response!!.body()?.string()
                        jsonResponseBody = jsonStringData?.let { JSONObject(it) }
                        println("Json Object: ")
                        println(jsonResponseBody)

                    }
                }
                job.start()
            }

            /**
             * Check response body for success or error message and send to client via toast message
             */
            // check for success or error
            if (jsonResponseBody?.has("successMsg") == true) {
                Toast.makeText(this, jsonResponseBody!!.get("successMsg").toString(), Toast.LENGTH_LONG).show()
                startActivity(Intent(this, LoginPage::class.java))

            } else if (jsonResponseBody?.has("error") == true){
                Toast.makeText(this, jsonResponseBody!!.get("error").toString(), Toast.LENGTH_LONG).show()
                val signUpPage: Intent = Intent(this, SignUpPage::class.java)
                startActivity(signUpPage)
            }


    } catch (e: IOException) {
        println(e.message)
        e.printStackTrace()
        Toast.makeText(this, "...", Toast.LENGTH_LONG).show()
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
