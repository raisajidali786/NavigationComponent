package com.rsa.navigation.ui.activity

import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*
import com.google.android.material.navigation.NavigationView
import com.rsa.navigation.NavGraphDirections
import com.rsa.navigation.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var toolbar: Toolbar
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigation: NavigationView
    private lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inIt()
        setSupportActionBar(toolbar)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.navHostFragment, R.id.settingFragment, R.id.notificationsFragment),
            drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        bottomNavView.setupWithNavController(navController)
        navigation.setupWithNavController(navController)
        itemClickHandler()
    }

    private fun itemClickHandler() {
//        navigation.setNavigationItemSelectedListener { item ->
//            when(item.itemId){
//                R.id.home ->{
//                    drawerLayout.closeDrawer(Gravity.LEFT)
//                }
//                R.id.contact ->{
//                    drawerLayout.closeDrawer(Gravity.LEFT)
//                    navController.navigate(R.id.action_navHostFragment_to_contactFragment)
//                }
//                R.id.gallery ->{
//                    drawerLayout.closeDrawer(Gravity.LEFT)
//                    navController.navigate(R.id.action_navHostFragment_to_galleryFragment)
//                }
//            }
//            item.onNavDestinationSelected(
//                navController
//            )
//        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    private fun inIt() {
        drawerLayout = findViewById(R.id.drawerLayout)
        navigation = findViewById(R.id.nav_view)
        toolbar = findViewById(R.id.mainToolbar)
    }

    private fun setToolbar() {
        val config = AppBarConfiguration(
            setOf(
                R.id.navHostFragment,
                R.id.settingFragment,
                R.id.notificationsFragment
            ), drawerLayout
        )
        toolbar.setupWithNavController(navController, config)
        toolbar.title = "Navigation Practice"
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.aboutAppItem -> {
                val action = NavGraphDirections.actionGlobalAboutAppFragment()
                navController.navigate(action)
                return true
            }
            else -> item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
        }
    }
}