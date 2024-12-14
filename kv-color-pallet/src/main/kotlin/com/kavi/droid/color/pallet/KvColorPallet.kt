package com.kavi.droid.color.pallet

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
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

class KvColorPallet(private val givenColor: Color = Color.White) {

    companion object {
        private var instance: KvColorPallet? = null
        lateinit var appThemePallet: AppThemePallet

        fun init(givenColor: Color = Color.White) {
            instance ?: run {
                instance = KvColorPallet(givenColor = givenColor)
            }
        }
    }

    init {
        val closestColor = ColorUtil.findClosestColor(givenColor)
        appThemePallet = generateThemeColorPallet(closestColor)
    }

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

    fun generateThemeColorPallet(givenColor: KvColor): AppThemePallet {
        return ThemeGenUtil.generateThemeColorSet(givenColor = givenColor)
    }
}