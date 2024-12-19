package com.kavi.droid.color.pallet.model

import androidx.compose.ui.graphics.Color
import com.kavi.droid.color.pallet.color.Mat100Package
import com.kavi.droid.color.pallet.color.Mat200Package
import com.kavi.droid.color.pallet.color.Mat300Package
import com.kavi.droid.color.pallet.color.Mat400Package
import com.kavi.droid.color.pallet.color.Mat50Package
import com.kavi.droid.color.pallet.color.Mat600Package
import com.kavi.droid.color.pallet.color.Mat700Package
import com.kavi.droid.color.pallet.color.MatPackage
import com.kavi.droid.color.pallet.color.ColorPackageType
import com.kavi.droid.color.pallet.util.ColorUtil

/**
 * Color object that holds,
 * name, package, hex, hex+alpha to the regular `Color` object
 *
 * @see Color
 */
data class KvColor(
    var colorName: String,
    var colorPackage: ColorPackageType = ColorPackageType.PK_0,
    var color: Color,
    var colorHex: String = ColorUtil.getHex(color),
    var colorHexWithAlpha: String = ColorUtil.getHexWithAlpha(color)
) {

    /**
     * Change the alpha of the color
     *
     * @param modifyAlpha The alpha value to be modified
     * @return The modified color
     */
    fun alphaChange(modifyAlpha: Float): KvColor {
        if (modifyAlpha == 1f) {
            return this
        } else {
            val modifiedColor = Color(color.red, color.green, color.blue, modifyAlpha)
            return KvColor(
                colorName = colorName,
                colorPackage = colorPackage,
                color = modifiedColor,
                colorHex = ColorUtil.getHex(modifiedColor),
                colorHexWithAlpha = ColorUtil.getHexWithAlpha(modifiedColor)
            )
        }
    }

    /**
     * Change the color package of the color. `KvColor` object, color package will be changed and
     * this method will return the color with requested color package.
     *
     * @param colorPackage The new color package
     * @return The modified color
     */
    fun changeColorPackage(colorPackage: ColorPackageType): KvColor {
        return when(colorPackage) {
            ColorPackageType.PK_50 -> {
                Mat50Package.getColorList().find { it.colorName == colorName } ?: run { MatPackage.MatWhite }
            }
            ColorPackageType.PK_100 -> {
                Mat100Package.getColorList().find { it.colorName == colorName } ?: run { MatPackage.MatWhite }
            }
            ColorPackageType.PK_200 -> {
                Mat200Package.getColorList().find { it.colorName == colorName } ?: run { MatPackage.MatWhite }
            }
            ColorPackageType.PK_300 -> {
                Mat300Package.getColorList().find { it.colorName == colorName } ?: run { MatPackage.MatWhite }
            }
            ColorPackageType.PK_400 -> {
                Mat400Package.getColorList().find { it.colorName == colorName } ?: run { MatPackage.MatWhite }
            }
            ColorPackageType.PK_500 -> {
                MatPackage.getColorList().find { it.colorName == colorName } ?: run { MatPackage.MatWhite }
            }
            ColorPackageType.PK_600 -> {
                Mat600Package.getColorList().find { it.colorName == colorName } ?: run { MatPackage.MatWhite }
            }
            ColorPackageType.PK_700 -> {
                Mat700Package.getColorList().find { it.colorName == colorName } ?: run { MatPackage.MatWhite }
            }
            else -> {
                MatPackage.MatWhite
            }
        }
    }
}