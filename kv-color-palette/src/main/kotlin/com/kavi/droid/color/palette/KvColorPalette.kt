package com.kavi.droid.color.palette

import androidx.compose.ui.graphics.Color
import com.kavi.droid.color.palette.color.Mat100Package
import com.kavi.droid.color.palette.color.Mat50Package
import com.kavi.droid.color.palette.color.Mat200Package
import com.kavi.droid.color.palette.color.Mat300Package
import com.kavi.droid.color.palette.color.Mat400Package
import com.kavi.droid.color.palette.color.Mat600Package
import com.kavi.droid.color.palette.color.Mat700Package
import com.kavi.droid.color.palette.color.Mat800Package
import com.kavi.droid.color.palette.color.Mat900Package
import com.kavi.droid.color.palette.color.MatPackage
import com.kavi.droid.color.palette.extension.hsl
import com.kavi.droid.color.palette.model.AppThemePalette
import com.kavi.droid.color.palette.model.ColorSchemeThemePalette
import com.kavi.droid.color.palette.model.KvColor
import com.kavi.droid.color.palette.util.ColorUtil
import com.kavi.droid.color.palette.util.ThemeGenUtil

/**
 * This is the KvColorPalette android library.
 */
class KvColorPalette {

    companion object {
        /**
         * This is a basic initialization without a basic color.  When consumer use this initialization, in default KvColorPalette with not
         * provide a theme color palette. Consumer can use this as a singleton.
         */
        var instance: KvColorPalette = KvColorPalette()
        @Deprecated("This field is deprecated. This is replaced by colorSchemeThemePalette")
        lateinit var appThemePalette: AppThemePalette
        lateinit var colorSchemeThemePalette: ColorSchemeThemePalette

        /**
         * KvColorPalette initialization. Consumer can use this to initialize the KvColorPalette from their application, if they need a
         * Theme color palette at the application start-up.
         *
         * On this initiation of KvColorPalette, we generate a theme color palette using the given color.
         * `basicColor` is mandatory parameter while initiate the library.
         *
         * @param basicColor: Color: Given color for generate theme palette.
         */
        fun initialize(basicColor: Color) {
            val closestColor = ColorUtil.findClosestColor(givenColor = basicColor)
            appThemePalette = instance.generateThemeColorPalette(givenColor = closestColor.color)
            colorSchemeThemePalette = instance.generateThemeColorSchemePalette(givenColor = closestColor.color)
        }
    }

    init {
        /**
         * This generate theme-palette with color transparent. This is un-usable.
         */
        appThemePalette = generateThemeColorPalette(Color.Transparent)

        /**
         * This generate theme-palette with color transparent. This is un-usable.
         */
        colorSchemeThemePalette = generateThemeColorSchemePalette(Color.Transparent)
    }

    /**
     * Generate a list of colors with alpha values. According to the feeding color,
     * this method generate a list of colors with different alpha values.
     *
     * @param givenColor The color to generate the alpha values for.
     * @param colorCount The number of colors to generate. In default that returns 10 colors.
     * This accept integer value in a range of 2 - 30. Even someone passes number more than 30, this will returns only 30 colors.
     * @return A list of colors.
     */
    fun generateAlphaColorPalette(givenColor: Color, colorCount: Int = 10): List<Color> {
        val colorList = mutableListOf<Color>()
        val reviseColorCount = ColorUtil.validateAndReviseColorCount(colorCount)
        for (i in reviseColorCount downTo 1) {
            colorList.add(Color(givenColor.red, givenColor.green, givenColor.blue, ((1f/colorCount)*i)))
        }
        return colorList
    }

    /**
     * Generate a list of colors with color saturation values. According to the feeding color,
     * this method generate a list of color with different saturation values.
     *
     * @param givenColor The color to generate the saturation values for.
     * @param colorCount The number of colors to generate. In default that returns 10 colors.
     * This accept integer value in a range of 2 - 30. Even someone passes number more than 30, this will returns only 30 colors.
     * @return A list of colors.
     */
    fun generateSaturationColorPalette(givenColor: Color, colorCount: Int = 10): List<Color> {
        val hue = givenColor.hsl.hue
        val lightness = givenColor.hsl.lightness

        val colorList = mutableListOf<Color>()
        val reviseColorCount = ColorUtil.validateAndReviseColorCount(colorCount)

        for (i in reviseColorCount downTo 1) {
            colorList.add(Color.hsl(hue = hue, saturation = ((1f/colorCount)*i), lightness = lightness))
        }
        return colorList
    }

    /**
     * Generate a list of colors with color lightness values. According to the feeding color,
     * this method generate a list of color with different lightness values.
     *
     * @param givenColor The color to generate the lightness values for.
     * @param colorCount The number of colors to generate. In default that returns 10 colors.
     * This accept integer value in a range of 2 - 30. Even someone passes number more than 30, this will returns only 30 colors.
     * @return A list of colors.
     */
    fun generateLightnessColorPalette(givenColor: Color, colorCount: Int = 10): List<Color> {
        val hue = givenColor.hsl.hue
        val saturation = givenColor.hsl.saturation

        return listOf(
            Color.hsl(hue = hue, saturation = saturation, lightness = 1f),
            Color.hsl(hue = hue, saturation = saturation, lightness = 0.9f),
            Color.hsl(hue = hue, saturation = saturation, lightness = 0.8f),
            Color.hsl(hue = hue, saturation = saturation, lightness = 0.7f),
            Color.hsl(hue = hue, saturation = saturation, lightness = 0.6f),
            Color.hsl(hue = hue, saturation = saturation, lightness = 0.5f),
            Color.hsl(hue = hue, saturation = saturation, lightness = 0.4f),
            Color.hsl(hue = hue, saturation = saturation, lightness = 0.3f),
            Color.hsl(hue = hue, saturation = saturation, lightness = 0.2f),
            Color.hsl(hue = hue, saturation = saturation, lightness = 0.1f)
        )
    }

    /**
     * Generate a list of colors with pre-defined color packages. According to the feeding color,
     * this method generate a list of colors.
     *
     * @param givenColor The color to generate the color packages for.
     * @return A list of colors.
     */
    fun generateColorPalette(givenColor: KvColor, alphaChange: Float = 1f): List<Color> =
        listOf(
            Mat900Package.getColor(colorName = givenColor.colorName).alphaChange(alphaChange).color,
            Mat800Package.getColor(colorName = givenColor.colorName).alphaChange(alphaChange).color,
            Mat700Package.getColor(colorName = givenColor.colorName).alphaChange(alphaChange).color,
            Mat600Package.getColor(colorName = givenColor.colorName).alphaChange(alphaChange).color,
            MatPackage.getColor(colorName = givenColor.colorName).alphaChange(alphaChange).color,
            Mat400Package.getColor(colorName = givenColor.colorName).alphaChange(alphaChange).color,
            Mat300Package.getColor(colorName = givenColor.colorName).alphaChange(alphaChange).color,
            Mat200Package.getColor(colorName = givenColor.colorName).alphaChange(alphaChange).color,
            Mat100Package.getColor(colorName = givenColor.colorName).alphaChange(alphaChange).color,
            Mat50Package.getColor(colorName = givenColor.colorName).alphaChange(alphaChange).color
        )

    /**
     * Generate a theme color palette. According to the feeding color,
     * this method generate a theme color palette.
     *
     * @param givenColor The color to generate the theme color palette for.
     * @return A theme color palette.
     */
    @Deprecated("This method is deprecated and replaced by generateThemeColorSchemePalette method", replaceWith = ReplaceWith(
        "KvColorPalette.instance.generateThemeColorSchemePalette(givenColor = givenColor)"
    ))
    fun generateThemeColorPalette(givenColor: Color): AppThemePalette = ThemeGenUtil.generateThemeColorSet(givenColor = givenColor)

    /**
     * Generate a theme color palette. According to the feeding color,
     * this method generate a color scheme theme color palette.
     *
     * @param givenColor The color to generate the theme color palette for.
     * @return A color scheme theme palette. [ColorSchemeThemePalette]
     */
    fun generateThemeColorSchemePalette(givenColor: Color): ColorSchemeThemePalette = ThemeGenUtil.generateThemeColorScheme(givenColor = givenColor)

    /**
     * This method finds the closest KvColor available in the KvColorPalette-Android to the given color
     *
     * @param givenColor: The color to find closest KvColor from color packages
     * @return KvColor
     */
    fun findClosestKvColor(givenColor: Color): KvColor = ColorUtil.findClosestColor(givenColor = givenColor)
}