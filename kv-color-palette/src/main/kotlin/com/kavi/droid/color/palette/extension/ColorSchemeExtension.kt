package com.kavi.droid.color.palette.extension

import androidx.compose.material3.ColorScheme
import androidx.compose.ui.graphics.Color
import com.kavi.droid.color.palette.KvColorPalette
import com.kavi.droid.color.palette.util.ThemeGenUtil
import java.util.WeakHashMap

/**
 * Providing new extension fields to [ColorScheme]
 * @see base: Base color is the consumer provided color to generate the theme
 * @see quaternary: Quaternary color is for the use of using primary color in light mode with contrast color in dark mode
 * @see shadow: Shadow color is for the use of shadow in light mode and dark mode.
 */
private val colorSchemeMap = WeakHashMap<String, Color>()

/**
 * This is the base given color. This is gonna be same as provided color in light and dark modes.
 */
var ColorScheme.base: Color
    get() = colorSchemeMap["base"] ?: Color.White
    set(value) {
        colorSchemeMap["base"] = value
    }

/**
 * This is for use light theme White color and dark theme Black color. This can use most of background or
 * shadow mode with alpha value on the color according to the theme.
 */
val ColorScheme.default: Color
    get() = getDefaultColor(this)

/**
 * This is for use light theme primary color dark theme contrast color
 */
val ColorScheme.quaternary: Color
    get() = getQuaternaryColor(this)

/**
 * This is for use the shadow color of a component
 */
val ColorScheme.shadow: Color
    get() = getShadowColor(this)

/**
 * This is for use the inverse color of onPrimary color
 */
val ColorScheme.inverseOnPrimary: Color
    get() = getInverseOnPrimaryColor(this)

/**
 * This is for use the inverse color of onBackground color
 */
val ColorScheme.inverseOnBackground: Color
    get() = getInverseOnBackgroundColor(this)


/**
 * This returns default color according to the theme mode. This method finds the mode from the
 * theme color scheme's background color. If the background color is a lighter one, it's assume
 * this is light mode and generate the default color.
 *
 * @param colorScheme: [ColorScheme] of the theme
 * @return color: [Color] default color for theme
 */
private fun getDefaultColor(colorScheme: ColorScheme): Color {
    return if (colorScheme.background.isHighLightColor)
        Color.White
    else
        Color.Black
}

/**
 * This returns quaternary color according to the theme mode. This method finds the mode from the
 * theme color scheme's background color. If the background color is a lighter one, it's assume
 * this is light mode and generate the quaternary color.
 *
 * @param colorScheme: [ColorScheme] of the theme
 * @return color: [Color] quaternary color for theme
 */
private fun getQuaternaryColor(colorScheme: ColorScheme): Color {
    return if (colorScheme.background.isHighLightColor)
        ThemeGenUtil.generateLightQuaternaryColor(colorScheme.base)
    else
        ThemeGenUtil.generateDarkQuaternaryColor(colorScheme.base)
}

/**
 * This returns shadow color according to the theme mode. This method finds the mode from the
 * theme color scheme's background color. If the background color is a lighter one, it's assume
 * this is light mode and returns the shadow color.
 *
 * @param colorScheme: [ColorScheme] of the theme
 * @return color: [Color] shadow color for theme
 */
private fun getShadowColor(colorScheme: ColorScheme): Color {
    return if (colorScheme.background.isHighLightColor)
        Color.Gray
    else
        Color.White
}

/**
 * This returns inverse onPrimary color according to the theme mode. This method finds the mode from the
 * theme color scheme's background color. If the background color is a lighter one, it's assume
 * this is light mode and returns the inverse of onPrimary color.
 *
 * @param colorScheme: [ColorScheme] of the theme
 * @return color: [Color] inverse of onPrimary color for theme
 */
private fun getInverseOnPrimaryColor(colorScheme: ColorScheme): Color {
    return if (colorScheme.background.isHighLightColor) {
        KvColorPalette.colorSchemeThemePalette.darkColorScheme.onPrimary
    } else {
        KvColorPalette.colorSchemeThemePalette.lightColorScheme.onPrimary
    }
}

/**
 * This returns inverse onBackground color according to the theme mode. This method finds the mode from the
 * theme color scheme's background color. If the background color is a lighter one, it's assume
 * this is light mode and returns the inverse of onBackground color.
 *
 * @param colorScheme: [ColorScheme] of the theme
 * @return color: [Color] inverse of onBackground color for theme
 */
private fun getInverseOnBackgroundColor(colorScheme: ColorScheme): Color {
    return if (colorScheme.background.isHighLightColor) {
        KvColorPalette.colorSchemeThemePalette.darkColorScheme.onBackground
    } else {
        KvColorPalette.colorSchemeThemePalette.lightColorScheme.onBackground
    }
}
