package com.example.safehome

import android.annotation.SuppressLint
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.example.safehome.databinding.HeaderBinding
import com.example.safehome.databinding.NavigationPaneBinding
import com.google.android.material.navigation.NavigationView


open class NavigationPane: AppCompatActivity() {
    private lateinit var navigationPaneBinding: NavigationPaneBinding
    private lateinit var headerBinding: HeaderBinding

    private lateinit var mToggle:ActionBarDrawerToggle

    fun onCreateDrawer(mDrawerLayout: DrawerLayout) {
        navigationPaneBinding = NavigationPaneBinding.inflate(layoutInflater)
        headerBinding = HeaderBinding.inflate(layoutInflater)

        val navigationView:NavigationView = findViewById(R.id.nav_view)
        val headerView = navigationView.getHeaderView(0)
        val emailId: TextView = headerView.findViewById(R.id.email_ID)
        val nameId: TextView = headerView.findViewById(R.id.name_ID)

        // get parsed user info received from server response body
        // update the emailId and nameId values with response objects
        val extras = intent.extras
        if (extras != null) { //The key argument here must match that used in the other activity
            emailId.text = extras.getString("emailId")
            nameId.text = extras.getString("nameId")
            println("Email: ${emailId.text} | Name: ${nameId.text}")

        } else {
            println("Bundle extras not passed to Navigation pane............")
        }

        mToggle = ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close)
        mDrawerLayout.addDrawerListener(mToggle)
        mToggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navigationView.setNavigationItemSelectedListener { menuItem ->
            menuItem.isChecked = true
            mDrawerLayout.closeDrawers()
            // Drawer menu selection
            when (menuItem.itemId) {
                R.id.home -> {
                    val homepage: Intent = Intent(this, HomePage::class.java)
                    homepage.putExtra("emailId", emailId.text.toString())
                    homepage.putExtra("nameId", nameId.text.toString())
                    startActivity(homepage)
                }
                R.id.contact -> {
                    val url = "https://profile.delliusalexander.com"
                    openUrl(url)
                }
                R.id.logout -> {
//                    FirebaseAuth.getInstance().signOut()
                    val loginIntent = Intent(this, LoginPage::class.java)
                    startActivity(loginIntent)
                }
            }
            true
        }
    }

    /**
     * Toggle item selection
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (mToggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    /**
     * Opens a URL in Chrome or default browser.
     * @param url Uniform Resource Locator
     */
    @SuppressLint("QueryPermissionsNeeded")
    private fun openUrl(url: String) {
        val googleChromeNavigatePrefix = "googlechrome://navigate?url="
        val newUrl: String?
        try {
            newUrl = if (!url.startsWith("http://")) {
                "https://$url"
            } else {
                url
            }
            try {
                Toast.makeText(this, "Visit: $url", Toast.LENGTH_LONG).show()
                val uri = Uri.parse(googleChromeNavigatePrefix + newUrl)
                val intent = Intent(Intent.ACTION_VIEW, uri)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                intent.setPackage("com.android.chrome")
                startActivity(intent)
            } catch (e: ActivityNotFoundException){
                println(e.message)
                println("Chrome is not installed. Or chrome not selected as default browser. Or no " +
                        "Browser is selected as default browser.")
                e.stackTrace
                val uri = Uri.parse(newUrl)
                val intent = Intent(Intent.ACTION_VIEW, uri)
                intent.setPackage(null)
                startActivity(intent)
            }
        } catch (e: ActivityNotFoundException){
            println(e.message)
            println("Chrome is not installed. Or chrome not selected as default browser. Or no " +
                    "Browser is selected as default browser.")
            e.stackTrace
        }

    }
}