package com.kavi.droid.color.pallet.model

import androidx.compose.ui.graphics.Color

/**
 * Application theme pallet for light and dark mode.
 */
data class AppThemePallet(
    val light: ThemeColorPallet,
    val dark: ThemeColorPallet
)

/**
 * Color pallet for theme.
 */
data class ThemeColorPallet(
    val base: Color,
    val primary: Color,
    val secondary: Color,
    val tertiary: Color,
    val background: Color = Color.White,
    val onPrimary: Color = Color.White,
    val onSecondary: Color = Color.White,
    val shadow: Color = Color.Gray
)
