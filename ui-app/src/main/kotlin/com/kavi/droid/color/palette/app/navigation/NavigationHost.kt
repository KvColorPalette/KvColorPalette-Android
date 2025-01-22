package com.kavi.droid.color.palette.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.kavi.droid.color.palette.app.model.PaletteType
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
            composable(route = "palette-gen-detail/{paletteType}") { navBackStack ->
                val paletteType = navBackStack.arguments?.getString("paletteType")
                paletteType?.let {
                    when (it) {
                        "0" -> PaletteGenDetailUI(paletteType = PaletteType.KV_PALETTE)
                        "1" -> PaletteGenDetailUI(paletteType = PaletteType.ALPHA_PALETTE)
                        "2" -> PaletteGenDetailUI(paletteType = PaletteType.LIGHTNESS_PALETTE)
                        "3" -> PaletteGenDetailUI(paletteType = PaletteType.SATURATION_PALETTE)
                    }
                }?: run {
                    PaletteGenDetailUI(paletteType = PaletteType.KV_PALETTE)
                }
            }
            composable(route = "theme-gen-detail") {
                ThemeGenDetailUI()
            }
        }
    }
}