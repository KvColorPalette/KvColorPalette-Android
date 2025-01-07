package com.kavi.droid.color.pallet.util

import androidx.compose.ui.graphics.Color
import com.kavi.droid.color.pallet.color.ColorPackageType
import com.kavi.droid.color.pallet.model.AppThemePallet
import com.kavi.droid.color.pallet.model.KvColor
import com.kavi.droid.color.pallet.model.ThemeColorPallet
import com.kavi.droid.color.pallet.util.ColorUtil.findClosestColor

object ThemeGenUtil {

    /**
     * Generate theme color set for given color.
     * @param givenColor The color to generate theme color set.
     * @return A theme color set. [AppThemePallet]
     */
    internal fun generateThemeColorSet(givenColor: Color): AppThemePallet {
        val closestColor = findClosestColor(givenColor)

        val lightColorPallet = generateLightThemeColorSet(givenColor, closestColor)
        val darkColorPallet = generateDarkThemeColorSet(givenColor, closestColor)

        return AppThemePallet(light = lightColorPallet, dark = darkColorPallet)
    }

    /**
     * Generate light theme color set for given color.
     * @param closestColor The closest color to original consumer given color.
     * @return A light theme color set. [ThemeColorPallet]
     */
    private fun generateLightThemeColorSet(givenColor: Color, closestColor: KvColor): ThemeColorPallet {
        return ThemeColorPallet(
            base = givenColor,
            primary = closestColor.color,
            secondary = generateLightSecondaryColor(closestColor.color),
            tertiary = generateLightTeriaryColor(closestColor),
            background = generateLightBackgroundColor(closestColor),
            onPrimary = Color.White,
            onSecondary = Color.White,
            shadow = Color.Gray
        )
    }

    /**
     * Generate dark theme color set for given color.
     * @param closestColor The closest color to original consumer given color.
     * @return A dark theme color set. [ThemeColorPallet]
     */
    private fun generateDarkThemeColorSet(givenColor: Color, primaryColor: KvColor): ThemeColorPallet {
        val closestColor = findClosestColor(primaryColor.color)

        return ThemeColorPallet(
            base = givenColor,
            primary = generateDarkPrimaryColor(closestColor.color),
            secondary = generateDarkSecondaryColor(closestColor.color),
            tertiary = generateDarkTeriaryColor(closestColor),
            background = generateDarkBackgroundColor(closestColor.color),
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
    private fun generateLightTeriaryColor(primaryColor: KvColor): Color {
        return primaryColor.changeColorPackage(ColorPackageType.PK_200).color
    }

    /**
     * Generate light background color for given color.
     */
    private fun generateLightBackgroundColor(primaryColor: KvColor): Color {
        return primaryColor.changeColorPackage(ColorPackageType.PK_50).alphaChange(.5f).color
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
    private fun generateDarkTeriaryColor(primaryColor: KvColor): Color {
        return primaryColor.changeColorPackage(ColorPackageType.PK_700).color
    }

    /**
     * Generate dark background color for given color.
     */
    private fun generateDarkBackgroundColor(primaryColor: Color): Color {
        return Color(primaryColor.red*0.1f, primaryColor.green*0.1f, primaryColor.blue*0.1f, 1f)
    }
}