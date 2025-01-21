package com.kavi.droid.color.palette.app.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.kavi.droid.color.palette.app.theme.KvColorPaletteTheme
import com.kavi.droid.color.palette.app.navigation.NavigationHost

class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KvColorPaletteTheme {
                navController = rememberNavController()
                // Create the navigation host with start-up destination as 'dashboard tab ui'
                NavigationHost.NavGraph(navController = navController)
            }
        }
    }
}