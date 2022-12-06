package com.example.safehome

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.safehome.databinding.ActivityLoginPageBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.*
import org.json.JSONObject
import java.io.IOException
import java.security.KeyManagementException
import java.security.NoSuchAlgorithmException
import java.security.Timestamp
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

            /**
             * Implement runnable for child thread usage
             */
            val mRunnable: Runnable = Runnable {
                /**
                 * Disable strict thread policy
                 */
                if (Build.VERSION.SDK_INT > 9) {
                    val policy = ThreadPolicy.Builder().permitAll().build()
                    StrictMode.setThreadPolicy(policy)
                }
                /**
                 * Capture the response
                 */
                val response  = SafeHomeAPI.login(userId, password)
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
                        val homepage: Intent = Intent(this, HomePage::class.java)
                        homepage.putExtra("emailId", jsonObject.get("name").toString())
                        homepage.putExtra("nameId", jsonObject.get("username").toString())
                        startActivity(homepage)

                    } else if (jsonObject?.has("error") == true){
                        Toast.makeText(this, jsonObject.get("error").toString(), Toast.LENGTH_LONG).show()
                        startActivity(Intent(this, LoginPage::class.java))
                    }
                }
            }
            val mDelayHandler = Handler()
            mDelayHandler!!.postDelayed(mRunnable, 1000)

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






