package com.kavi.droid.color.pallet.color

import androidx.compose.ui.graphics.Color
import com.kavi.droid.color.pallet.model.ColorCompareResult
import com.kavi.droid.color.pallet.model.KvColor
import com.kavi.droid.color.pallet.util.ColorUtil.getColorDistance

abstract class ColorPackage {

    abstract fun getColorList(): List<KvColor>

    fun compareColor(givenColor: Color): ColorCompareResult {
        var closestColor = KvColor(colorName = "White", color = Color.White)
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

    fun getColor(colorName: String): KvColor {
        return getColorList().find { it.colorName == colorName } ?: run { KvColor(colorName = "White", color = Color.White) }
    }
}