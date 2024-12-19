package com.kavi.droid.color.pallet.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.kavi.droid.color.pallet.KvColorPallet

/*private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40,
    background = Color.Gray
    /* Other default colors to override */
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
)*/

@Composable
fun KvColorPalletTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val theme = KvColorPallet.appThemePallet

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