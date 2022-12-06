package com.example.safehome


import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.StrictMode
import android.text.TextUtils
import android.widget.Toast
import com.example.safehome.databinding.ActivitySignUpPageBinding
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
        // TODO: Implement post request to api server path "api/v1/user/register/user={user}"
        try {
        val mRunnable: Runnable = Runnable {
            /**
             * Disable strict thread policy
             */
            if (Build.VERSION.SDK_INT > 9) {
                val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
                StrictMode.setThreadPolicy(policy)
            }
            /**
             * Capture the response
             */
            val response: Response? = SafeHomeAPI.register(firstName + " " + lastName, mailAddr, dob, pwd)

            /**
             * Check response for success or error message and send to client via toast message
             */
            val jsonData: String?
            val jsonObject: JSONObject?
            if(response === null){
                throw NullPointerException("Response body is null.  Incorrect login attempt or server error need further analysis.")
            } else {
                jsonData= response.body()?.string()
                jsonObject = jsonData?.let { JSONObject(it) }
                println("Json Object: ")
                println(jsonObject)
                if (jsonObject?.has("successMsg") == true) {
                    Toast.makeText(this, jsonObject.get("successMsg").toString(), Toast.LENGTH_LONG).show()
                    startActivity(Intent(this, LoginPage::class.java))

                } else if (jsonObject?.has("error") == true){
                    Toast.makeText(this, jsonObject.get("error").toString(), Toast.LENGTH_LONG).show()
                    val signUpPage: Intent = Intent(this, SignUpPage::class.java)
                    startActivity(signUpPage)
                }
            }
        }

        val mDelayHandler = Handler()
        mDelayHandler!!.postDelayed(mRunnable, 1000)

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
