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
      // TODO: Implement parsing messages received from json object

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
