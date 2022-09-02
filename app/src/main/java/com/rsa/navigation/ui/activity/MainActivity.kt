package com.rsa.navigation.ui.activity

import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import com.rsa.navigation.R

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var toolbar : Toolbar
    private lateinit var drawerLayout : DrawerLayout
    private lateinit var navigation : NavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inIt()
        setToolbar()
        itemClickHandler()
    }

    private fun itemClickHandler() {
        navigation.setNavigationItemSelectedListener { item ->
            when(item.itemId){
                R.id.home ->{
                    drawerLayout.closeDrawer(Gravity.LEFT)
                }
                R.id.contact ->{
                    drawerLayout.closeDrawer(Gravity.LEFT)
                    navController.navigate(R.id.action_navHostFragment_to_contactFragment)
                }
                R.id.gallery ->{
                    drawerLayout.closeDrawer(Gravity.LEFT)
                    navController.navigate(R.id.action_navHostFragment_to_galleryFragment)
                }
            }
            item.onNavDestinationSelected(
                navController
            )
        }
    }

    private fun inIt() {
        navController = findNavController(R.id.nav_host_fragment)
        drawerLayout = findViewById(R.id.drawerLayout)
        navigation = findViewById(R.id.nav_view)
        toolbar = findViewById(R.id.mainToolbar)
    }

    private fun setToolbar() {
        setSupportActionBar(toolbar)
        val config = AppBarConfiguration(navController.graph,drawerLayout)
        toolbar.setupWithNavController(navController, config)
        toolbar.title = "Navigation Practice"
    }
}