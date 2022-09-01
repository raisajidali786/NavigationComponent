package com.rsa.navigation.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.rsa.navigation.R

class MainActivity : AppCompatActivity() {
    private lateinit var toolbar : Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setToolbar()
    }

    private fun setToolbar() {
        toolbar = findViewById(R.id.mainToolbar)
        setSupportActionBar(toolbar)
        val navController = findNavController(R.id.nav_host_fragment)
        val config = AppBarConfiguration(navController.graph)
        toolbar.setupWithNavController(navController, config)
        toolbar.title = "Navigation Practice"
    }
}