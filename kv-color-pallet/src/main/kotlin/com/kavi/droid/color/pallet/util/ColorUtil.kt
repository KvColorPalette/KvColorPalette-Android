package com.kavi.droid.color.pallet.util

import androidx.compose.ui.graphics.Color
import com.kavi.droid.color.pallet.color.Mat200Package
import com.kavi.droid.color.pallet.color.Mat300Package
import com.kavi.droid.color.pallet.color.Mat50Package
import com.kavi.droid.color.pallet.color.Mat700Package
import com.kavi.droid.color.pallet.color.MatPackage
import com.kavi.droid.color.pallet.color.PackageType
import com.kavi.droid.color.pallet.model.AppThemePallet
import com.kavi.droid.color.pallet.model.KvColor
import com.kavi.droid.color.pallet.model.ThemeColorPallet
import kotlin.math.abs

object ColorUtil {

    fun getColorFromHex(color: String): Color {
        return Color(android.graphics.Color.parseColor(color))
    }

    fun getHex(color: Color): String {
        return String.format("#%02x%02x%02x", (color.red * 255).toInt(), (color.green * 255).toInt(), (color.blue * 255).toInt())
    }

    fun getHexWithAlpha(color: Color): String {
        return String.format("#%02x%02x%02x%02x", (color.alpha * 255).toInt(),(color.red * 255).toInt(), (color.green * 255).toInt(), (color.blue * 255).toInt())
    }

    internal fun findClosestColor(givenColor: Color): KvColor {
        // Do comparison with 700 color list
        val colorMatch700 = Mat700Package.compareColor(givenColor)
        if (colorMatch700.isExactMatch) {
            return colorMatch700.matchedColor
        } else {
            var shortestDistance = colorMatch700.colorDistance
            var closestColor = colorMatch700.matchedColor

            // Do comparison with 500(base) color list
            val colorMatch500 = MatPackage.compareColor(givenColor)

            if (colorMatch500.isExactMatch) {
                return colorMatch500.matchedColor
            } else {
                if (colorMatch500.colorDistance < shortestDistance) {
                    shortestDistance = colorMatch500.colorDistance
                    closestColor = colorMatch500.matchedColor

                    // Do comparison with 300 color list
                    val colorMatch300 = Mat300Package.compareColor(givenColor)

                    if (colorMatch300.isExactMatch) {
                        return colorMatch300.matchedColor
                    } else {
                        if (colorMatch300.colorDistance < shortestDistance) {
                            shortestDistance = colorMatch300.colorDistance
                            closestColor = colorMatch300.matchedColor

                            // Do comparison with 300 color list
                            val colorMatch200 = Mat200Package.compareColor(givenColor)

                            if (colorMatch200.isExactMatch) {
                                return colorMatch200.matchedColor
                            } else {
                                if (colorMatch200.colorDistance < shortestDistance) {
                                    closestColor = colorMatch200.matchedColor
                                }
                            }
                        }
                    }
                }
            }

            return closestColor
        }
    }

    internal fun getColorDistance(colorOne: Color, colorTwo: Color): Float {
        return abs(colorOne.red - colorTwo.red) +
                abs(colorOne.green - colorTwo.green) +
                abs(colorOne.blue - colorTwo.blue) +
                abs(colorOne.alpha - colorTwo.alpha)

    }
}