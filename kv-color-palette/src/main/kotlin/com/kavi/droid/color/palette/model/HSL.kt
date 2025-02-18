package com.kavi.droid.color.palette.model

import androidx.compose.ui.graphics.Color

/**
 * Data class to hold the hue, saturation and lightness properties of a [Color]
 */
data class HSL(
    val hue: Float,
    val saturation: Float,
    val lightness: Float
)