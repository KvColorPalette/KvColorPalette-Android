package com.kavi.droid.color.palette.util

import androidx.compose.ui.graphics.Color
import com.kavi.droid.color.palette.extension.hsl
import com.kavi.droid.color.palette.model.AppThemePalette
import com.kavi.droid.color.palette.model.ThemeColorPalette

object ThemeGenUtil {

    /**
     * Generate theme color set for given color.
     * @param givenColor The color to generate theme color set.
     * @return A theme color set. [AppThemePalette]
     */
    internal fun generateThemeColorSet(givenColor: Color): AppThemePalette {
        val lightColorPalette = generateLightThemeColorSet(givenColor)
        val darkColorPalette = generateDarkThemeColorSet(givenColor)

        return AppThemePalette(light = lightColorPalette, dark = darkColorPalette)
    }

    /**
     * Generate light theme color set for given color.
     * @param givenColor The color to generate theme color set.
     * @return A light theme color set. [ThemeColorPalette]
     */
    private fun generateLightThemeColorSet(givenColor: Color): ThemeColorPalette {
        return ThemeColorPalette(
            base = givenColor,
            primary = givenColor,
            secondary = generateLightSecondaryColor(givenColor),
            tertiary = generateLightTertiaryColor(givenColor),
            quaternary = givenColor, // This is for use light theme primary color dark theme contrast color
            background = generateLightBackgroundColor(givenColor),
            onPrimary = Color.White,
            onSecondary = Color.White,
            shadow = Color.Gray
        )
    }

    /**
     * Generate dark theme color set for given color.
     * @param givenColor he color to generate theme color set.
     * @return A dark theme color set. [ThemeColorPalette]
     */
    private fun generateDarkThemeColorSet(givenColor: Color): ThemeColorPalette {
        return ThemeColorPalette(
            base = givenColor,
            primary = generateDarkPrimaryColor(givenColor),
            secondary = generateDarkSecondaryColor(givenColor),
            tertiary = generateDarkTertiaryColor(givenColor),
            quaternary = generateDarkSecondaryColor(givenColor), // This is for use light theme primary color dark theme contrast color
            background = generateDarkBackgroundColor(givenColor),
            onPrimary = Color.White,
            onSecondary = Color.Black,
            shadow = Color.White
        )
    }

    /**
     * Generate light secondary color for given color.
     */
    private fun generateLightSecondaryColor(primaryColor: Color): Color {
        return Color(primaryColor.red/2, primaryColor.green/2, primaryColor.blue/2, 1f)
    }

    /**
     * Generate light tertiary color for given color.
     */
    private fun generateLightTertiaryColor(primaryColor: Color): Color {
        val firstColor = Color(primaryColor.red/1.5f, primaryColor.green/1.5f, primaryColor.blue/1.5f, 1f)
        return Color.hsl(hue = firstColor.hsl.hue, saturation = firstColor.hsl.saturation, lightness = .8f)
    }

    /**
     * Generate light background color for given color.
     */
    private fun generateLightBackgroundColor(primaryColor: Color): Color {
        return Color.hsl(hue = primaryColor.hsl.hue, saturation = .4f, lightness = .95f)
    }

    /**
     * Generate dark primary color for given color.
     */
    private fun generateDarkPrimaryColor(primaryColor: Color): Color {
        return Color(primaryColor.red*0.3f, primaryColor.green*0.3f, primaryColor.blue*0.3f, 1f)
    }

    /**
     * Generate dark secondary color for given color.
     */
    private fun generateDarkSecondaryColor(primaryColor: Color): Color {
        return Color(primaryColor.red*1.5f, primaryColor.green*1.5f, primaryColor.blue*1.5f, 1f)
    }

    /**
     * Generate dark tertiary color for given color.
     */
    private fun generateDarkTertiaryColor(primaryColor: Color): Color {
        return Color.hsl(hue = primaryColor.hsl.hue, saturation = primaryColor.hsl.saturation, lightness = .45f)
    }

    /**
     * Generate dark background color for given color.
     */
    private fun generateDarkBackgroundColor(primaryColor: Color): Color {
        return Color(primaryColor.red*0.1f, primaryColor.green*0.1f, primaryColor.blue*0.1f, 1f)
    }
}