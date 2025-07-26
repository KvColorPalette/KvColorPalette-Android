package com.kavi.droid.color.palette.util

import android.content.Context
import android.content.res.Configuration
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import com.kavi.droid.color.palette.extension.base
import com.kavi.droid.color.palette.extension.hsl
import com.kavi.droid.color.palette.model.ColorSchemeThemePalette
import com.kavi.droid.color.palette.model.ThemeGenMode

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
     * @return A theme color set. [ColorSchemeThemePalette]
     */
    internal fun singleColorThemeColorScheme(givenColor: Color): ColorSchemeThemePalette {
        val lightColorPalette = generateThemeLightColorScheme(givenColor)
        val darkColorPalette = generateThemeDarkColorScheme(givenColor)

        return ColorSchemeThemePalette(lightColorScheme = lightColorPalette, darkColorScheme = darkColorPalette)
    }

    /**
     * Generate a theme color palette. According to the feeding color,
     * this method generate a color scheme theme color palette.
     *
     * @param givenColor The color to generate the theme color palette for.
     * @param secondColor The secondary color to generate the theme color palette blending with first color.
     * @param bias The bias value to blend the two colors. In default that is 0.5f. This accept float value in a range of 0.0 - 1.0.
     * 0f means full bias to first color and 1f means full bias to second color.
     * @param themeGenMode: ThemeGenPattern: The pattern to generate the theme color palette.
     * Default is [ThemeGenMode.SEQUENCE] and available options are [ThemeGenMode.SEQUENCE] and [ThemeGenMode.BLEND]
     * - [ThemeGenMode.SEQUENCE] will add base color & primary & second color as secondary, rest of the colors will generate by using given base color.
     * - [ThemeGenMode.BLEND] will add base color & primary & second color as primary, rest of the colors will generate by after generating new color blend first and second colors.
     * @return A color scheme theme palette. [ColorSchemeThemePalette]
     */
    internal fun multiColorInputThemeColorScheme(givenColor: Color, secondColor: Color, bias: Float = 0.5f, themeGenMode: ThemeGenMode = ThemeGenMode.SEQUENCE): ColorSchemeThemePalette {
        var blendColor: Color? = null

        blendColor = when (themeGenMode) {
            ThemeGenMode.SEQUENCE -> { null }
            ThemeGenMode.BLEND -> { ColorUtil.blendColors(firstColor = givenColor, secondColor = secondColor, bias = bias) }
        }

        val lightColorPalette = generateMultiInputThemeLightColorScheme(givenColor = givenColor, secondColor = secondColor, blendColor = blendColor, themeGenMode = themeGenMode)
        val darkColorPalette = generateMultiInputThemeDarkColorScheme(givenColor = givenColor, secondColor = secondColor, blendColor = blendColor, themeGenMode = themeGenMode)

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
     * @return A light theme color set. [ColorScheme]
     */
    private fun generateThemeLightColorScheme(givenColor: Color): ColorScheme {
        val secondaryColor = generateLightSecondaryColor(givenColor)
        val backgroundColor = generateLightBackgroundColor(givenColor)
        val lightColorScheme = lightColorScheme(
            primary = givenColor,
            secondary = secondaryColor,
            tertiary = generateLightTertiaryColor(givenColor),
            background = backgroundColor,
            surface = ColorUtil.blendColors(firstColor = backgroundColor, secondColor = Color.White, .9f),
            onPrimary = ColorUtil.blendColors(firstColor = givenColor, Color.White, .9f),
            onSecondary = ColorUtil.blendColors(firstColor = secondaryColor, Color.White, .9f),
            onSurface = ColorUtil.blendColors(firstColor = Color.Black, Color.White, .25f)
        )
        lightColorScheme.base = givenColor

        return lightColorScheme
    }

    /**
     * Generate light theme color set for given colors.
     * @param givenColor The color to generate the theme color palette for.
     * @param secondColor The secondary color to generate the theme color palette blending with first color.
     * @param themeGenMode: ThemeGenPattern: The pattern to generate the theme color palette.
     * @return A light theme color set. [ColorScheme]
     */
    private fun generateMultiInputThemeLightColorScheme(givenColor: Color, secondColor: Color, blendColor: Color? = null, themeGenMode: ThemeGenMode = ThemeGenMode.SEQUENCE): ColorScheme {
        when (themeGenMode) {
            ThemeGenMode.SEQUENCE -> {
                val backgroundColor = generateLightBackgroundColor(givenColor)
                val light = lightColorScheme(
                    primary = givenColor,
                    secondary = secondColor,
                    tertiary = generateLightTertiaryColor(givenColor),
                    background = backgroundColor,
                    surface = ColorUtil.blendColors(firstColor = backgroundColor, secondColor = Color.White, .9f),
                    onPrimary = ColorUtil.blendColors(firstColor = givenColor, Color.White, .9f),
                    onSecondary = ColorUtil.blendColors(firstColor = secondColor, Color.White, .9f),
                    onSurface = ColorUtil.blendColors(firstColor = Color.Black, Color.White, .25f)
                )
                light.base = givenColor

                return light
            }
            ThemeGenMode.BLEND -> {
                val blend = blendColor ?: run { givenColor }
                val backgroundColor = generateLightBackgroundColor(blend)
                val light = lightColorScheme(
                    primary = givenColor,
                    secondary = secondColor,
                    tertiary = generateLightTertiaryColor(blend),
                    background = backgroundColor,
                    surface = ColorUtil.blendColors(firstColor = backgroundColor, secondColor = Color.White, .9f),
                    onPrimary = ColorUtil.blendColors(firstColor = givenColor, Color.White, .9f),
                    onSecondary = ColorUtil.blendColors(firstColor = secondColor, Color.White, .9f),
                    onSurface = ColorUtil.blendColors(firstColor = Color.Black, Color.White, .25f)
                )
                light.base = blend

                return light
            }
        }
    }

    /**
     * Generate dark theme color set for given color.
     * @param givenColor he color to generate theme color set.
     * @return A dark theme color set. [ColorScheme]
     */
    private fun generateThemeDarkColorScheme(givenColor: Color): ColorScheme {
        val darkPrimary = generateDarkPrimaryColor(givenColor)
        val darkSecondary = generateDarkSecondaryColor(givenColor)
        val darkBackground = generateDarkBackgroundColor(givenColor)
        val darkColorScheme = darkColorScheme(
            primary = darkPrimary,
            secondary = darkSecondary,
            tertiary = generateDarkTertiaryColor(givenColor),
            background = darkBackground,
            surface = ColorUtil.blendColors(firstColor = darkBackground, secondColor = Color.Black, .9f),
            onPrimary = ColorUtil.blendColors(firstColor = darkPrimary, secondColor = Color.White, .9f),
            onSecondary = ColorUtil.blendColors(firstColor = darkSecondary, secondColor = Color.White, .9f),
            onSurface = Color.White
        )

        darkColorScheme.base = givenColor

        return darkColorScheme
    }

    /**
     * Generate dark theme color set for given color.
     * @param givenColor The color to generate the theme color palette for.
     * @param secondColor The secondary color to generate the theme color palette blending with first color.
     * @param themeGenMode: ThemeGenPattern: The pattern to generate the theme color palette.
     * @return A dark theme color set. [ColorScheme]
     */
    private fun generateMultiInputThemeDarkColorScheme(givenColor: Color, secondColor: Color, blendColor: Color? = null, themeGenMode: ThemeGenMode = ThemeGenMode.SEQUENCE): ColorScheme {
        when (themeGenMode) {
            ThemeGenMode.SEQUENCE -> {
                val darkPrimary = generateDarkPrimaryColor(givenColor)
                val darkSecondary = generateDarkSecondaryColor(secondColor)
                val darkBackground = generateDarkBackgroundColor(givenColor)
                val dark = darkColorScheme(
                    primary = darkPrimary,
                    secondary = darkSecondary,
                    tertiary = generateDarkTertiaryColor(givenColor),
                    background = darkBackground,
                    surface = ColorUtil.blendColors(firstColor = darkBackground, secondColor = Color.Black, .9f),
                    onPrimary = ColorUtil.blendColors(firstColor = darkPrimary, secondColor = Color.White, .9f),
                    onSecondary = ColorUtil.blendColors(firstColor = darkSecondary, secondColor = Color.White, .9f),
                    onSurface = Color.White
                )
                dark.base = givenColor

                return dark
            }
            ThemeGenMode.BLEND -> {
                val blend = blendColor ?: run { givenColor }
                val darkPrimary = generateDarkPrimaryColor(givenColor)
                val darkSecondary = generateDarkSecondaryColor(secondColor)
                val darkBackground = generateDarkBackgroundColor(blend)
                val dark = darkColorScheme(
                    primary = darkPrimary,
                    secondary = darkSecondary,
                    tertiary = generateDarkTertiaryColor(blend),
                    background = darkBackground,
                    surface = ColorUtil.blendColors(firstColor = darkBackground, secondColor = Color.Black, .9f),
                    onPrimary = ColorUtil.blendColors(firstColor = darkPrimary, secondColor = Color.White, .9f),
                    onSecondary = ColorUtil.blendColors(firstColor = darkSecondary, secondColor = Color.White, .9f),
                    onSurface = Color.White
                )
                dark.base = blend

                return dark
            }
        }
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