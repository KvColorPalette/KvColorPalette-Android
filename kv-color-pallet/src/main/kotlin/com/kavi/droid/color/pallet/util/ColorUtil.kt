package com.kavi.droid.color.pallet.util

import androidx.compose.ui.graphics.Color
import com.kavi.droid.color.pallet.color.Mat200Package
import com.kavi.droid.color.pallet.color.Mat300Package
import com.kavi.droid.color.pallet.color.Mat700Package
import com.kavi.droid.color.pallet.color.MatPackage
import com.kavi.droid.color.pallet.model.KvColor
import kotlin.math.abs

object ColorUtil {

    /**
     * Convert hex color to [Color]
     *
     * @param color hex color String
     * @return [Color]
     */
    fun getColorFromHex(color: String): Color {
        return Color(android.graphics.Color.parseColor(color))
    }

    /**
     * Get hex value of given color
     *
     * @param color [Color]
     * @return hex color String
     */
    fun getHex(color: Color): String {
        return String.format("#%02x%02x%02x", (color.red * 255).toInt(), (color.green * 255).toInt(), (color.blue * 255).toInt())
    }

    /**
     * Get hex value of given color with alpha
     *
     * @param color [Color]
     * @return hex color String
     */
    fun getHexWithAlpha(color: Color): String {
        return String.format("#%02x%02x%02x%02x", (color.alpha * 255).toInt(),(color.red * 255).toInt(), (color.green * 255).toInt(), (color.blue * 255).toInt())
    }

    /**
     * Get closest color to the given color from available color packages.
     * This compares the available colors and find out the closest `KvColor` to the given color.
     *
     * @param givenColor [Color]
     * @return [KvColor] closest color to the given color
     */
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

                            // Do comparison with 200 color list
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

    /**
     * Get distance between two colors
     *
     * @param colorOne [Color]
     * @param colorTwo [Color]
     * @return distance between two colors
     */
    internal fun getColorDistance(colorOne: Color, colorTwo: Color): Float {
        return abs(colorOne.red - colorTwo.red) +
                abs(colorOne.green - colorTwo.green) +
                abs(colorOne.blue - colorTwo.blue) +
                abs(colorOne.alpha - colorTwo.alpha)

    }
}