package com.example.safehome

import android.os.Bundle
import android.os.Handler
import androidx.drawerlayout.widget.DrawerLayout
import com.google.gson.GsonBuilder
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException
import com.example.safehome.databinding.ActivityHomePageBinding


class HomePage : NavigationPane() {
    private lateinit var homePageBinding: ActivityHomePageBinding
    private var mDelayHandler: Handler? = null
    private val splashDelay: Long = 1000

    private val mRunnable= Runnable {


    }

    private fun fetchJson() {

//        println("Attempting")
//        // Get all the messages from the server
//        // https://delliusalexander.com/api/v1/message/get/?user=jane@example.com&messagesPerPage=20&token=<place token here>
//        val url = "https://delliusalexander.com/api/v1/message/get/?user=jane@example.com&messagesPerPage=20"
//
//        val request = Request.Builder().url(url).build()
//
//        val client = OkHttpClient()
//
//        client.newCall(request).enqueue(object : Callback {
//
//            override fun onResponse(call: okhttp3.Call?, response: okhttp3.Response?) {
//                val body = response?.body()?.string()
//
//                val gson = GsonBuilder().create()
//
//                // TODO: Implement parsing messages received from json object
//
//            }
//
//            override fun onFailure(call: okhttp3.Call?, e: IOException?) {
//                println("Failed to execute request")
//            }
//        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homePageBinding = ActivityHomePageBinding.inflate(layoutInflater)
        val view = homePageBinding.root
        setContentView(view)
        val mDrawerLayout:DrawerLayout = homePageBinding.drawerLayout
        onCreateDrawer(mDrawerLayout)
        // Fetch the most recent alert messages
        fetchJson()

        // TODO: handle rendering alert messages

        mDelayHandler = Handler()
        mDelayHandler!!.postDelayed(mRunnable, splashDelay)
    }


}
