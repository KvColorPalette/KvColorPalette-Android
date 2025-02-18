package com.kavi.droid.color.palette.model

import androidx.compose.material3.ColorScheme
import androidx.compose.ui.graphics.Color

/**
 * Application theme palette for light and dark mode.
 */
data class AppThemePalette(
    val light: ThemeColorPalette,
    val dark: ThemeColorPalette
)

/**
 * Application [ColorScheme] theme palette for light and dark mode.
 */
data class ColorSchemeThemePalette(
    val lightColorScheme: ColorScheme,
    val darkColorScheme: ColorScheme
)

/**
 * Color palette for theme.
 */
data class ThemeColorPalette(
    val base: Color,
    val primary: Color,
    val secondary: Color,
    val tertiary: Color,
    val quaternary: Color,
    val background: Color = Color.White,
    val onPrimary: Color = Color.White,
    val onSecondary: Color = Color.White,
    val shadow: Color = Color.Gray
)
