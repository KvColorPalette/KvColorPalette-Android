package com.kavi.droid.color.palette.extension

import androidx.compose.material3.ColorScheme
import androidx.compose.ui.graphics.Color

/**
 * Extension property to check if a [Color] is a high-light color.
 */
val Color.isHighLightColor: Boolean
    get() = this.hsl.lightness > 0.6f

/**
 * Providing new extension fields to [ColorScheme]
 * @see base: Base color is the consumer provided color to generate the theme
 * @see quaternary: Quaternary color is for the use of using primary color in light mode with contrast color in dark mode
 * @see shadow: Shadow color is for the use of shadow in light mode and dark mode.
 */
var ColorScheme.base: Color
    get() = Color.White
    set(value) {}
var ColorScheme.quaternary: Color
    get() = Color.White
    set(value) {}
var ColorScheme.shadow: Color
    get() = Color.White
    set(value) {}
