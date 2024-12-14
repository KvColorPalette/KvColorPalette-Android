package com.kavi.droid.color.pallet.model

import androidx.compose.ui.graphics.Color

data class AppThemePallet(
    val light: ThemeColorPallet,
    val dark: ThemeColorPallet
)

data class ThemeColorPallet(
    val primary: Color,
    val secondary: Color,
    val tertiary: Color,
    val background: Color = Color.White
)
