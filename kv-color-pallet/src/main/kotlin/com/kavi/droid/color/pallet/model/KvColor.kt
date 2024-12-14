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
import com.kavi.droid.color.pallet.color.PackageType
import com.kavi.droid.color.pallet.util.ColorUtil

data class KvColor(
    var colorName: String,
    var packageType: PackageType = PackageType.PK_0,
    var color: Color,
    var colorHex: String = ColorUtil.getHex(color),
    var colorHexWithAlpha: String = ColorUtil.getHexWithAlpha(color)
) {
    fun alphaChange(modifyAlpha: Float): KvColor {
        if (modifyAlpha == 1f) {
            return this
        } else {
            val modifiedColor = Color(color.red, color.green, color.blue, modifyAlpha)
            return KvColor(
                colorName = colorName,
                packageType = packageType,
                color = modifiedColor,
                colorHex = ColorUtil.getHex(modifiedColor),
                colorHexWithAlpha = ColorUtil.getHexWithAlpha(modifiedColor)
            )
        }
    }

    fun changePackageType(packageType: PackageType): KvColor {
        return when(packageType) {
            PackageType.PK_50 -> {
                Mat50Package.getColorList().find { it.packageType == packageType } ?: run { KvColor(colorName = "White", color = Color.White) }
            }
            PackageType.PK_100 -> {
                Mat100Package.getColorList().find { it.packageType == packageType } ?: run { KvColor(colorName = "White", color = Color.White) }
            }
            PackageType.PK_200 -> {
                Mat200Package.getColorList().find { it.packageType == packageType } ?: run { KvColor(colorName = "White", color = Color.White) }
            }
            PackageType.PK_300 -> {
                Mat300Package.getColorList().find { it.packageType == packageType } ?: run { KvColor(colorName = "White", color = Color.White) }
            }
            PackageType.PK_400 -> {
                Mat400Package.getColorList().find { it.packageType == packageType } ?: run { KvColor(colorName = "White", color = Color.White) }
            }
            PackageType.PK_500 -> {
                MatPackage.getColorList().find { it.packageType == packageType } ?: run { KvColor(colorName = "White", color = Color.White) }
            }
            PackageType.PK_600 -> {
                Mat600Package.getColorList().find { it.packageType == packageType } ?: run { KvColor(colorName = "White", color = Color.White) }
            }
            PackageType.PK_700 -> {
                Mat700Package.getColorList().find { it.packageType == packageType } ?: run { KvColor(colorName = "White", color = Color.White) }
            }
            else -> {
                KvColor(colorName = "White", color = Color.White)
            }
        }
    }
}