package com.kavi.droid.color.palette.color

import androidx.compose.ui.graphics.Color
import com.kavi.droid.color.palette.model.ColorCompareResult
import com.kavi.droid.color.palette.model.KvColor
import com.kavi.droid.color.palette.util.ColorUtil.getColorDistance

abstract class ColorPackage {

    /**
     * Get a list of colors from the color package.
     *
     * @return A list of colors.
     */
    abstract fun getColorList(): List<KvColor>

    /**
     * Compare a given color with the colors in the color package.
     *
     * @param givenColor The color to compare.
     * @return A color compare result. This include the most matching color, distance to the
     * most matching color and the matched color is exact to the given color
     */
    fun compareColor(givenColor: Color): ColorCompareResult {
        var closestColor = MatPackage.MatWhite
        var shortestDistance: Float? = null

        getColorList().forEach { comparingColor ->
            val colorDistance = getColorDistance(givenColor, comparingColor.color)
            if (colorDistance == 0f) {
                return ColorCompareResult(isExactMatch = true, colorDistance = colorDistance, matchedColor = comparingColor)
            } else {
                shortestDistance?.let { availableShortedDistance ->
                    if (colorDistance < availableShortedDistance) {
                        shortestDistance = colorDistance
                        closestColor = comparingColor
                    }
                } ?: run {
                    shortestDistance = colorDistance
                    closestColor = comparingColor
                }
            }
        }

        return ColorCompareResult(isExactMatch = false, colorDistance = shortestDistance!!, matchedColor = closestColor)
    }

    /**
     * Get a color from the color package using color name.
     *
     * @param colorName The name of the color.
     * @return A color.
     */
    fun getColor(colorName: String): KvColor {
        return getColorList().find { it.colorName == colorName } ?: run { MatPackage.MatWhite }
    }
}