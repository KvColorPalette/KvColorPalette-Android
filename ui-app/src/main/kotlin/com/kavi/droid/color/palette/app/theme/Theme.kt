package com.kavi.droid.color.palette.app.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.kavi.droid.color.palette.KvColorPalette

@Composable
fun KvColorPaletteTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val theme = KvColorPalette.appThemePalette

    val themeLight = lightColorScheme(
        primary = theme.light.primary,
        secondary = theme.light.secondary,
        tertiary = theme.light.tertiary,
        background = theme.light.background,
        onPrimary = theme.light.onPrimary,
        onSecondary = theme.light.onSecondary
    )

    val themeDark = darkColorScheme(
        primary = theme.dark.primary,
        secondary = theme.dark.secondary,
        tertiary = theme.dark.tertiary,
        background = theme.dark.background,
        onPrimary = theme.dark.onPrimary,
        onSecondary = theme.dark.onSecondary
    )

    val appColorScheme = when {
        darkTheme -> themeDark
        else -> themeLight
    }

    MaterialTheme(
        colorScheme = appColorScheme,
        typography = AppTypography,
        content = content
    )
}

@Composable
fun navigationBarColors(): NavigationBarItemColors {
    return NavigationBarItemColors(
        selectedIconColor = MaterialTheme.colorScheme.onPrimary,
        selectedTextColor = MaterialTheme.colorScheme.onPrimary,
        unselectedIconColor = Color.Black,
        unselectedTextColor = MaterialTheme.colorScheme.onPrimary,
        selectedIndicatorColor = MaterialTheme.colorScheme.tertiary,
        disabledIconColor = Color.Gray,
        disabledTextColor = Color.Gray,
    )
}