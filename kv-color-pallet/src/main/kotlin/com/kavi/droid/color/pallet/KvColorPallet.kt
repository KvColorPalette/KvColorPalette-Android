package com.kavi.droid.color.pallet

import androidx.compose.ui.graphics.Color
import com.kavi.droid.color.pallet.color.Mat100Package
import com.kavi.droid.color.pallet.color.Mat50Package
import com.kavi.droid.color.pallet.color.Mat200Package
import com.kavi.droid.color.pallet.color.Mat300Package
import com.kavi.droid.color.pallet.color.Mat400Package
import com.kavi.droid.color.pallet.color.Mat600Package
import com.kavi.droid.color.pallet.color.Mat700Package
import com.kavi.droid.color.pallet.color.Mat800Package
import com.kavi.droid.color.pallet.color.Mat900Package
import com.kavi.droid.color.pallet.color.MatPackage
import com.kavi.droid.color.pallet.model.AppThemePallet
import com.kavi.droid.color.pallet.model.KvColor
import com.kavi.droid.color.pallet.util.ColorUtil
import com.kavi.droid.color.pallet.util.ThemeGenUtil

/**
 * This is the kv-color-pallet android library.
 */
class KvColorPallet {

    companion object {
        /**
         * This is a basic initialization without a basic color.  When consumer use this initialization, in default KvColorPallet with not
         * provide a theme color pallet. Consumer can use this as a singleton.
         */
        var instance: KvColorPallet = KvColorPallet()
        lateinit var appThemePallet: AppThemePallet

        /**
         * KvColorPallet initialization. Consumer can use this to initialize the KvColorPallet from their application delegate if they need a
         * Theme color pallet at the application start-up.
         *
         * On this initiation of kv-color-pallet, we generate a theme color pallet using the given color.
         * `basicColor` is mandatory parameter while initiate the library.
         */
        fun initialize(basicColor: KvColor) {
            val closestColor = ColorUtil.findClosestColor(basicColor.color)
            appThemePallet = instance.generateThemeColorPallet(closestColor.color)
        }
    }

    init {
        /**
         * This generate theme-pallet with color transparent. This is un-usable.
         */
        appThemePallet = generateThemeColorPallet(Color.Transparent)
    }

    /**
     * Generate a list of colors with alpha values. According to the feeding color,
     * this method generate a list of colors with different alpha values.
     *
     * @param givenColor The color to generate the alpha values for.
     * @return A list of colors with alpha values.
     */
    fun generateAlphaColorPallet(givenColor: Color): List<Color> {
        return listOf(
            Color(givenColor.red, givenColor.green, givenColor.blue, 1f),
            Color(givenColor.red, givenColor.green, givenColor.blue, .9f),
            Color(givenColor.red, givenColor.green, givenColor.blue, .8f),
            Color(givenColor.red, givenColor.green, givenColor.blue, .7f),
            Color(givenColor.red, givenColor.green, givenColor.blue, .6f),
            Color(givenColor.red, givenColor.green, givenColor.blue, .5f),
            Color(givenColor.red, givenColor.green, givenColor.blue, .4f),
            Color(givenColor.red, givenColor.green, givenColor.blue, .3f),
            Color(givenColor.red, givenColor.green, givenColor.blue, .2f),
            Color(givenColor.red, givenColor.green, givenColor.blue, .1f),
        )
    }

    /**
     * Generate a list of colors with pre-defined color packages. According to the feeding color,
     * this method generate a list of colors.
     *
     * @param givenColor The color to generate the color packages for.
     * @return A list of colors.
     */
    fun generateColorPallet(givenColor: KvColor, alphaChange: Float = 1f): List<Color> {
        return listOf(
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
    }

    /**
     * Generate a theme color pallet. According to the feeding color,
     * this method generate a theme color pallet.
     *
     * @param givenColor The color to generate the theme color pallet for.
     * @return A theme color pallet.
     */
    fun generateThemeColorPallet(givenColor: Color): AppThemePallet {
        return ThemeGenUtil.generateThemeColorSet(givenColor = givenColor)
    }
}