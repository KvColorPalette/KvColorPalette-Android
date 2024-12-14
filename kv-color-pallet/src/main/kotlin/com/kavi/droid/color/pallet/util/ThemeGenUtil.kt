package com.kavi.droid.color.pallet.util

import androidx.compose.ui.graphics.Color
import com.kavi.droid.color.pallet.color.Mat100Package
import com.kavi.droid.color.pallet.color.Mat200Package
import com.kavi.droid.color.pallet.color.Mat50Package
import com.kavi.droid.color.pallet.color.Mat700Package
import com.kavi.droid.color.pallet.model.AppThemePallet
import com.kavi.droid.color.pallet.model.KvColor
import com.kavi.droid.color.pallet.model.ThemeColorPallet
import com.kavi.droid.color.pallet.util.ColorUtil.findClosestColor

object ThemeGenUtil {

    internal fun generateThemeColorSet(givenColor: KvColor): AppThemePallet {
        val closestColor = findClosestColor(givenColor.color)

        val lightColorPallet = generateLightThemeColorSet(closestColor)
        val darkColorPallet = generateDarkThemeColorSet(closestColor)

        return AppThemePallet(light = lightColorPallet, dark = darkColorPallet)
    }

    private fun generateLightThemeColorSet(closestColor: KvColor): ThemeColorPallet {
        return ThemeColorPallet(
            primary = closestColor.color,
            secondary = generateLightSecondaryColor(closestColor.color),
            tertiary = generateLightTeriaryColor(closestColor),
            background = generateLightBackgroundColor(closestColor)
        )
    }

    private fun generateDarkThemeColorSet(primaryColor: KvColor): ThemeColorPallet {
        val closestColor = findClosestColor(primaryColor.color)

        return ThemeColorPallet(
            primary = generateDarkPrimaryColor(closestColor.color),
            secondary = generateDarkSecondaryColor(closestColor.color),
            tertiary = generateDarkTeriaryColor(closestColor),
            background = generateDarkBackgroundColor(closestColor.color)
        )
    }

    private fun generateLightSecondaryColor(primaryColor: Color): Color {
        return Color(primaryColor.red/2, primaryColor.green/2, primaryColor.blue/2, 1f)
    }

    private fun generateLightTeriaryColor(primaryColor: KvColor): Color {
        return Mat200Package.getColor(colorName = primaryColor.colorName).color
    }

    private fun generateLightBackgroundColor(primaryColor: KvColor): Color {
        return Mat50Package.getColor(colorName = primaryColor.colorName).alphaChange(.5f).color
    }

    private fun generateDarkPrimaryColor(primaryColor: Color): Color {
        return Color(primaryColor.red*0.3f, primaryColor.green*0.3f, primaryColor.blue*0.3f, 1f)
        //return Mat200Package.getColor(colorName = primaryColor.colorName).color
    }

    private fun generateDarkSecondaryColor(primaryColor: Color): Color {
        return Color(primaryColor.red*1.5f, primaryColor.green*1.5f, primaryColor.blue*1.5f, 1f)
    }

    private fun generateDarkTeriaryColor(primaryColor: KvColor): Color {
        return Mat700Package.getColor(colorName = primaryColor.colorName).color
    }

    private fun generateDarkBackgroundColor(primaryColor: Color): Color {
        return Color(primaryColor.red*0.3f, primaryColor.green*0.2f, primaryColor.blue*0.1f, 1f)
    }
}