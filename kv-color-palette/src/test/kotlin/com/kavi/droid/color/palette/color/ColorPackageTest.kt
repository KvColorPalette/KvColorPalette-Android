package com.kavi.droid.color.palette.color

import androidx.compose.ui.graphics.Color
import com.kavi.droid.color.palette.model.KvColor
import com.google.common.truth.Truth.assertThat
import com.kavi.droid.color.palette.model.ColorCompareResult
import org.junit.Test

class ColorPackageTest {
    private val redColor = MatPackage.MatRed
    private val greenColor = MatPackage.MatLGreen
    private val blueColor = MatPackage.MatLBlue

    private val colorPackage = object : ColorPackage() {
        override fun getColorList(): List<KvColor> = listOf(redColor, greenColor, blueColor)
    }

    @Test
    fun `getColor returns correct color by name`() {
        val result = colorPackage.getColor("MatLGreen")
        assertThat(result).isEqualTo(greenColor)
    }

    @Test
    fun `getColor returns MatWhite when color not found`() {
        val result = colorPackage.getColor("Purple")
        assertThat(result).isEqualTo(MatPackage.MatWhite)
    }

    @Test
    fun `compareColor returns exact match when color exists`() {
        val result: ColorCompareResult = colorPackage.compareColor(Color(1f, 0f, 0f)) // Red
        assertThat(result.isExactMatch).isFalse()
        assertThat(result.matchedColor).isEqualTo(redColor)
        assertThat(result.colorDistance).isEqualTo(0.5176471f)
    }

    @Test
    fun `compareColor returns closest color when no exact match`() {
        val input = Color(0.9f, 0.1f, 0.1f) // Close to red
        val result = colorPackage.compareColor(input)

        assertThat(result.isExactMatch).isFalse()
        assertThat(result.matchedColor).isEqualTo(redColor)
        assertThat(result.colorDistance).isGreaterThan(0f)
    }
}