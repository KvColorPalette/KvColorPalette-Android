package com.kavi.droid.color.palette.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.kavi.droid.color.palette.app.ui.detail.PaletteGenDetailUI
import com.kavi.droid.color.palette.app.ui.detail.ThemeGenDetailUI
import com.kavi.droid.color.palette.app.ui.dashboard.DashboardTabUI

object NavigationHost {
    @Composable
    fun NavGraph(navController: NavHostController) {
        NavHost(navController = navController, startDestination = "dashboard-tab") {
            composable(route = "dashboard-tab") {
                DashboardTabUI(navController = navController)
            }
            composable(route = "palette-gen-detail") {
                PaletteGenDetailUI()
            }
            composable(route = "theme-gen-detail") {
                ThemeGenDetailUI()
            }
        }
    }
}