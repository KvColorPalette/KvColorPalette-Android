package com.kavi.droid.color.palette.extension

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.core.graphics.ColorUtils
import com.kavi.droid.color.palette.model.HSL

/**
 * Extension property to check if a [Color] is a high-light color.
 */
val Color.isHighLightColor: Boolean
    get() = this.hsl.lightness > 0.6f

/**
 * Extension function to get HSL properties of a [Color]
 *
 * This [hsl] attribute to the [androidx.compose.ui.graphics.Color] object will provide hue, saturation and lightness properties of the color.
 */
val Color.hsl: HSL
    get() = getHslProperties(this)

/**
 * This method extract and returns the hue, saturation and lightness properties of a [Color]
 *
 * @param color The color to extract the hue, saturation and lightness properties from.
 * @return A [HSL] object containing the hue, saturation and lightness properties of the given [Color].
 */
private fun getHslProperties(color: Color): HSL {
    val outHsl = floatArrayOf(0f, 0f, 0f)

    val colorInt = color.toArgb()
    val red = android.graphics.Color.red(colorInt)
    val green = android.graphics.Color.green(colorInt)
    val blue = android.graphics.Color.blue(colorInt)

    ColorUtils.RGBToHSL(red, green, blue, outHsl)

    return HSL(outHsl[0], outHsl[1], outHsl[2])
}