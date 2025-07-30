package com.kavi.droid.color.palette.util

import androidx.compose.ui.graphics.Color
import com.kavi.droid.color.palette.color.Mat200Package
import com.kavi.droid.color.palette.color.Mat300Package
import com.kavi.droid.color.palette.color.Mat700Package
import com.kavi.droid.color.palette.color.MatPackage
import com.kavi.droid.color.palette.model.ColorCompareResult
import io.mockk.every
import io.mockk.mockkObject
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import org.junit.Before
import org.junit.Test

class ColorUtilTest {

    @Before
    fun setupMocks() {
        mockkObject(Mat700Package, MatPackage, Mat300Package, Mat200Package, Color)
    }

    @Test
    fun `validateColorHex returns true for valid 6-digit hex`() {
        assertTrue(ColorUtil.validateColorHex("#A1B2C3"))
    }

    @Test
    fun `validateColorHex returns true for valid 8-digit hex`() {
        assertTrue(ColorUtil.validateColorHex("#FFAABBCC"))
    }

    @Test
    fun `validateColorHex returns false for invalid hex`() {
        assertFalse(ColorUtil.validateColorHex("123456"))
        assertFalse(ColorUtil.validateColorHex("#XYZ123"))
        assertFalse(ColorUtil.validateColorHex("#123"))
    }

    @Test
    fun `getHex returns correct hex string`() {
        val color = Color(0.5f, 0.25f, 0.75f)
        val hex = ColorUtil.getHex(color)
        assertEquals("#8040bf", hex)
    }

    @Test
    fun `getHexWithAlpha returns correct hex string with alpha`() {
        val color = Color(0.5f, 0.25f, 0.75f, 0.5f)
        val hex = ColorUtil.getHexWithAlpha(color)
        assertEquals("#808040bf", hex)
    }

    @Test
    fun `blendColors returns mid color for bias 0_5`() {
        val red = Color(1f, 0f, 0f)
        val blue = Color(0f, 0f, 1f)
        val blended = ColorUtil.blendColors(red, blue, 0.5f)
        assertTrue(blended.red > 0f)
        assertTrue(blended.blue > 0f)
        assertEquals(0f, blended.green, 0.01f)
    }

    @Test
    fun `getColorDistance returns correct distance`() {
        val c1 = Color(1f, 0f, 0f, 1f)
        val c2 = Color(0f, 1f, 0f, 1f)
        val distance = ColorUtil.getColorDistance(c1, c2)
        assertEquals(2.0f, distance, 0.01f)
    }

    @Test
    fun `validateAndReviseColorCount returns revised limits`() {
        assertEquals(1, ColorUtil.validateAndReviseColorCount(0))
        assertEquals(30, ColorUtil.validateAndReviseColorCount(100))
        assertEquals(15, ColorUtil.validateAndReviseColorCount(15))
    }

    @Test
    fun `findClosestColor returns exact match from 700`() {
        val color = Color.Red
        val kvColor = Mat700Package.MatRed
        every { Mat700Package.compareColor(color) } returns ColorCompareResult(true, 0f, kvColor)

        val result = ColorUtil.findClosestColor(color)
        assertEquals(kvColor, result)
    }

    @Test
    fun `findClosestColor returns closest after checking all packages`() {
        val givenColor = Mat700Package.MatRed.color
        val kvColor = Mat700Package.MatRed

        every { Mat700Package.compareColor(any()) } returns ColorCompareResult(false, 0.3f,
            Mat700Package.MatRed)
        every { MatPackage.compareColor(any()) } returns ColorCompareResult(false, 0.2f,
            Mat700Package.MatRed)
        every { Mat300Package.compareColor(any()) } returns ColorCompareResult(false, 0.1f,
            Mat700Package.MatRed)
        every { Mat200Package.compareColor(any()) } returns ColorCompareResult(false, 0.5f,
            Mat700Package.MatRed)

        val result = ColorUtil.findClosestColor(givenColor)
        assertEquals(kvColor, result)
    }
}