package com.kavi.droid.color.palette.util

import androidx.compose.ui.graphics.Color
import com.kavi.droid.color.palette.color.Mat200Package
import com.kavi.droid.color.palette.color.Mat300Package
import com.kavi.droid.color.palette.color.Mat700Package
import com.kavi.droid.color.palette.color.MatPackage
import com.kavi.droid.color.palette.model.KvColor
import kotlin.math.abs

object ColorUtil {

    /**
     * Convert hex color to [Color]
     *
     * @param colorHex hex color String
     * @return [Color]
     */
    fun getColorFromHex(colorHex: String): Color {
        return Color(android.graphics.Color.parseColor(colorHex))
    }

    /**
     * Validate if given color hex is valid
     *
     * @param colorHex hex color String
     * @return [Boolean]
     */
    fun validateColorHex(colorHex: String): Boolean {
        val colorRegex = Regex("^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{8})$")
        return colorRegex.matches(colorHex)
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
     * This method is to blend given two colors and return new color
     *
     * @param firstColor [Color] First color to blend
     * @param secondColor [Color] Second color to blend
     * @param bias [Float] Bias to the new color for first / second color.
     */
    internal fun blendColors(firstColor: Color, secondColor: Color, bias: Float = 0.5f): Color {
        val blendRed = colorBlendingComponent(firstColor.red, secondColor.red, bias)
        val blendGreen = colorBlendingComponent(firstColor.green, secondColor.green, bias)
        val blendBlue = colorBlendingComponent(firstColor.blue, secondColor.blue, bias)

        return Color(blendRed / 255, blendGreen / 255, blendBlue / 255)
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

    /**
     * Validate the color count requested by the user in the color palette.
     * If the color count is greater than 30, then it will return 30. If the color count is less than 1, then it will return 1.
     *
     * @param colorCount [Int] The number of colors to generate.
     * @return Int: The validated color count.
     */
    internal fun validateAndReviseColorCount(colorCount: Int): Int =
        if (colorCount >= 30) { 30 } else if (colorCount <= 1) { 1 } else { colorCount }

    /**
     * This method can return the color value of red/green/blue according to the blending bias
     * with given first color's red/green/blue value and second color's red/green/blue value.
     *
     * @param firstColor The first color's red/green/blue value
     * @param secondColor The second color's red/green/blue value
     * @param bias The blending bias value.
     *
     */
    private fun colorBlendingComponent(firstColor: Float, secondColor: Float, bias: Float): Float {
        val difference = abs(firstColor * 255 - secondColor * 255)
        val blending = difference * bias // How bias to the blending colors, first or second

        return if (firstColor < secondColor) {
            (firstColor * 255) + blending // First color is in lower end, therefore adding bias
        } else if (firstColor > secondColor) {
            (firstColor * 255) - blending // First color is in higher end, therefore subtracting bias
        } else {
            (firstColor * 255) // This means, first component and second component are same. Therefore, returns same value.
        }
    }
}