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
import com.kavi.droid.color.palette.model.ColorSchemeThemePalette
import com.kavi.droid.color.palette.model.KvColor
import com.kavi.droid.color.palette.model.ThemeGenMode
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
        lateinit var colorSchemeThemePalette: ColorSchemeThemePalette

        /**
         * KvColorPalette initialization. Consumer can use this to initialize the KvColorPalette from their application, if they need a
         * Theme color palette at the application start-up.
         *
         * On this initiation of KvColorPalette, library generate a theme color palette using the given color.
         * `baseColor` is mandatory parameter while initiate the library.
         *
         * @param baseColor: Color: Given color for generate theme palette.
         */
        fun initialize(baseColor: Color) {
            colorSchemeThemePalette = instance.generateThemeColorSchemePalette(givenColor = baseColor)
        }

        /**
         * KvColorPalette initialization. Consumer can use this to initialize the KvColorPalette from their application, if they need a
         * Theme color palette at the application start-up.
         *
         * On this initiation of KvColorPalette, library generate a theme color palette using the given base color and second color.
         * `baseColor` and `secondColor` are mandatory parameter while initiate the library. Other two parameters are optional.
         *
         * @param baseColor: Color: Given first for generate theme palette.
         * @param secondColor: Color: Given second color for generate theme palette.
         * @param bias: Float: The bias value to blend the two colors. In default that is 0.5f. This accept float value in a range of 0.0 - 1.0.
         * 0f means full bias to first color and 1f means full bias to second color.
         * @param themeGenMode: ThemeGenPattern: The pattern to generate the theme color palette.
         * Default is [ThemeGenMode.SEQUENCE] and available options are [ThemeGenMode.SEQUENCE] and [ThemeGenMode.BLEND]
         * - [ThemeGenMode.SEQUENCE] will add base color & primary & second color as secondary, rest of the colors will generate by using given base color.
         * - [ThemeGenMode.BLEND] will add base color & primary & second color as primary, rest of the colors will generate by after generating new color blend first and second colors.
         */
        fun initialize(baseColor: Color, secondColor: Color, bias: Float = .5f, themeGenMode: ThemeGenMode = ThemeGenMode.SEQUENCE) {
            colorSchemeThemePalette = instance.generateMultiColorThemeColorSchemePalette(
                givenColor = baseColor,
                secondColor = secondColor,
                bias = bias,
                themeGenMode = themeGenMode
            )
        }
    }

    init {
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

        val colorList = mutableListOf<Color>()
        val reviseColorCount = ColorUtil.validateAndReviseColorCount(colorCount)

        for (i in reviseColorCount downTo 1) {
            colorList.add(Color.hsl(hue = hue, saturation = saturation, lightness = ((1f/colorCount)*i)))
        }
        return colorList
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
     * this method generate a color scheme theme color palette.
     *
     * @param givenColor The color to generate the theme color palette for.
     * @return A color scheme theme palette. [ColorSchemeThemePalette]
     */
    fun generateThemeColorSchemePalette(givenColor: Color): ColorSchemeThemePalette = ThemeGenUtil.singleColorThemeColorScheme(givenColor = givenColor)

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
    fun generateMultiColorThemeColorSchemePalette(givenColor: Color, secondColor: Color, bias: Float = .5f, themeGenMode: ThemeGenMode = ThemeGenMode.SEQUENCE): ColorSchemeThemePalette {
        return ThemeGenUtil.multiColorInputThemeColorScheme(givenColor = givenColor, secondColor = secondColor, bias = bias, themeGenMode = themeGenMode)
    }
    /**
     * This method finds the closest KvColor available in the KvColorPalette-Android to the given color
     *
     * @param givenColor: The color to find closest KvColor from color packages
     * @return KvColor
     */
    fun findClosestKvColor(givenColor: Color): KvColor = ColorUtil.findClosestColor(givenColor = givenColor)
}