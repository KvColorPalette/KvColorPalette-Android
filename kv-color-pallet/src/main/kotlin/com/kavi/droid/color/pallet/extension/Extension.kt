package com.kavi.droid.color.pallet.extension

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.core.graphics.ColorUtils

val Color.hsl: HSL
    get() = getHslProperties(this)

data class HSL(
    val hue: Float,
    val saturation: Float,
    val lightness: Float
)

private fun getHslProperties(color: Color): HSL {
    val outHsl = floatArrayOf(0f, 0f, 0f)

    val colorInt = color.toArgb()
    val red = android.graphics.Color.red(colorInt)
    val green = android.graphics.Color.green(colorInt)
    val blue = android.graphics.Color.blue(colorInt)

    ColorUtils.RGBToHSL(red, green, blue, outHsl)

    return HSL(outHsl[0], outHsl[1], outHsl[2])
}
