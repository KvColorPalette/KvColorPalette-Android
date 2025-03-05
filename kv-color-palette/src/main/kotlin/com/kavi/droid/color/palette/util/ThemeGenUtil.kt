package com.kavi.droid.color.palette.util

import android.content.Context
import android.content.res.Configuration
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import com.kavi.droid.color.palette.extension.base
import com.kavi.droid.color.palette.extension.hsl
import com.kavi.droid.color.palette.extension.quaternary
import com.kavi.droid.color.palette.extension.shadow
import com.kavi.droid.color.palette.model.AppThemePalette
import com.kavi.droid.color.palette.model.ColorSchemeThemePalette
import com.kavi.droid.color.palette.model.ThemeColorPalette

object ThemeGenUtil {

    /**
     * This is to find out application is in dark mode or not.
     *
     * @param context: Context: Android context
     * @return Boolean: Boolean value says application in dark mode or not.
     */
    fun isAppInNightMode(context: Context): Boolean {
        return when (context.resources.configuration.uiMode.and(Configuration.UI_MODE_NIGHT_MASK)) {
            Configuration.UI_MODE_NIGHT_YES -> {
                true
            }
            Configuration.UI_MODE_NIGHT_NO,
            Configuration.UI_MODE_NIGHT_UNDEFINED -> {
                false
            }
            else -> {
                false
            }
        }
    }

    /**
     * Generate theme color set for given color.
     * @param givenColor The color to generate theme color set.
     * @return A theme color set. [AppThemePalette]
     */
    @Deprecated(
        message = "This method is deprecated and replaced by generateThemeColorScheme.",
        replaceWith = ReplaceWith("ThemeGenUtil.generateThemeColorScheme(givenColor = givenColor)")
    )
    internal fun generateThemeColorSet(givenColor: Color): AppThemePalette {
        val lightColorPalette = generateLightThemeColorSet(givenColor)
        val darkColorPalette = generateDarkThemeColorSet(givenColor)

        return AppThemePalette(light = lightColorPalette, dark = darkColorPalette)
    }

    /**
     * Generate theme color set for given color.
     * @param givenColor The color to generate theme color set.
     * @return A theme color set. [ColorSchemeThemePalette]
     */
    internal fun generateThemeColorScheme(givenColor: Color): ColorSchemeThemePalette {
        val lightColorPalette = generateThemeLightColorScheme(givenColor)
        val darkColorPalette = generateThemeDarkColorScheme(givenColor)

        return ColorSchemeThemePalette(lightColorScheme = lightColorPalette, darkColorScheme = darkColorPalette)
    }

    /**
     * This method is generating quaternary color in the color theme palette for light mode. This is for internal use method
     * @param givenColor: Color to generate light mode quaternary color
     * @return Color
     */
    internal fun generateLightQuaternaryColor(givenColor: Color): Color =
        givenColor

    /**
     * This method is generating quaternary color in the color theme palette for dark mode. This is for internal use method
     * @param givenColor: Color to generate dark mode quaternary color
     * @return Color
     */
    internal fun generateDarkQuaternaryColor(givenColor: Color): Color =
        generateDarkSecondaryColor(givenColor)

    /**
     * Generate light theme color set for given color.
     * @param givenColor The color to generate theme color set.
     * @return A light theme color set. [ThemeColorPalette]
     */
    @Deprecated(
        message = "This method is deprecated and replaced by generateThemeLightColorScheme.",
        replaceWith = ReplaceWith("ThemeGenUtil.generateThemeLightColorScheme(givenColor = givenColor)")
    )
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
     * Generate light theme color set for given color.
     * @param givenColor The color to generate theme color set.
     * @return A light theme color set. [ColorScheme]
     */
    private fun generateThemeLightColorScheme(givenColor: Color): ColorScheme {
        val lightColorScheme = lightColorScheme(
            primary = givenColor,
            secondary = generateLightSecondaryColor(givenColor),
            tertiary = generateLightTertiaryColor(givenColor),
            background = generateLightBackgroundColor(givenColor),
            onPrimary = Color.White,
            onSecondary = Color.White
        )
        lightColorScheme.base = givenColor

        return lightColorScheme
    }

    /**
     * Generate dark theme color set for given color.
     * @param givenColor he color to generate theme color set.
     * @return A dark theme color set. [ThemeColorPalette]
     */
    @Deprecated(
        message = "This method is deprecated and replaced by generateThemeDarkColorScheme.",
        replaceWith = ReplaceWith("ThemeGenUtil.generateThemeDarkColorScheme(givenColor = givenColor)")
    )
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
     * Generate dark theme color set for given color.
     * @param givenColor he color to generate theme color set.
     * @return A dark theme color set. [ColorScheme]
     */
    private fun generateThemeDarkColorScheme(givenColor: Color): ColorScheme {
        val darkColorScheme = darkColorScheme(
            primary = generateDarkPrimaryColor(givenColor),
            secondary = generateDarkSecondaryColor(givenColor),
            tertiary = generateDarkTertiaryColor(givenColor),
            background = generateDarkBackgroundColor(givenColor),
            onPrimary = Color.White,
            onSecondary = Color.Black,
        )

        darkColorScheme.base = givenColor

        return darkColorScheme
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