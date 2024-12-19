package com.kavi.droid.color.pallet

import androidx.compose.ui.graphics.Color
import com.kavi.droid.color.pallet.color.Mat100Package
import com.kavi.droid.color.pallet.color.Mat50Package
import com.kavi.droid.color.pallet.color.Mat200Package
import com.kavi.droid.color.pallet.color.Mat300Package
import com.kavi.droid.color.pallet.color.Mat400Package
import com.kavi.droid.color.pallet.color.Mat600Package
import com.kavi.droid.color.pallet.color.Mat700Package
import com.kavi.droid.color.pallet.color.MatPackage
import com.kavi.droid.color.pallet.model.AppThemePallet
import com.kavi.droid.color.pallet.model.KvColor
import com.kavi.droid.color.pallet.util.ColorUtil
import com.kavi.droid.color.pallet.util.ThemeGenUtil

/**
 * This is the kv-color-pallet android library.
 */
class KvColorPallet(private val givenColor: Color = Color.White) {

    companion object {
        var instance: KvColorPallet? = null
        lateinit var appThemePallet: AppThemePallet

        fun init(givenColor: Color) {
            instance ?: run {
                instance = KvColorPallet(givenColor = givenColor)
            }
        }
    }

    init {
        /**
         * On initiation of kv-color-pallet, we generate a theme color pallet using the given color.
         * `givenColor` is mandatory parameter while initiate the library.
         *
         * Consumer who is using kv-color-pallet, will get a color pallet for the theme of the application
         */
        val closestColor = ColorUtil.findClosestColor(givenColor)
        appThemePallet = generateThemeColorPallet(closestColor)
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
    fun generateThemeColorPallet(givenColor: KvColor): AppThemePallet {
        return ThemeGenUtil.generateThemeColorSet(givenColor = givenColor)
    }
}