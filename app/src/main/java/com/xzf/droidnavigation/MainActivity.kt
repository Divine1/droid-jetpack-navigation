package com.xzf.droidnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var navController : NavController;
    private lateinit var drawerLayout : DrawerLayout;
    private lateinit var appBarConfiguration : AppBarConfiguration;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // https://stackoverflow.com/a/60597670/3673073
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment


        navController = navHostFragment.navController;
        drawerLayout = findViewById(R.id.drawer_layout);
        var navigation_view = findViewById<NavigationView>(R.id.navigation_view);
        navigation_view.setupWithNavController(navController)

        appBarConfiguration = AppBarConfiguration(navController.graph,drawerLayout);
        setupActionBarWithNavController(navController,appBarConfiguration);


    }

    override
    fun onSupportNavigateUp():Boolean {
        //val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment


        //navController = navHostFragment.navController;
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp();

        //return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp();
        //return true;
     }



}