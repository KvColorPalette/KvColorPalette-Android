package com.kavi.droid.color.pallet.color

import androidx.compose.ui.graphics.Color
import com.kavi.droid.color.pallet.model.KvColor

enum class PackageType {
    PK_0, PK_50, PK_100, PK_200, PK_300, PK_400, PK_500, PK_600, PK_700
}

/**
 * Material colors 500
 */
object MatPackage: ColorPackage() {
    val MatWhite = KvColor(colorName = "MatRed", packageType= PackageType.PK_500, color = Color(0xAAFFFFFF))
    val MatRed = KvColor(colorName = "MatRed", packageType= PackageType.PK_500, color = Color(0xFFF44336))
    val MatRose = KvColor(colorName = "MatRose", packageType= PackageType.PK_500, color = Color(0xFFE91E63))
    val MatLPurple = KvColor(colorName = "MatLPurple", packageType= PackageType.PK_500, color = Color(0xFF9C27B0))
    val MatDPurple = KvColor(colorName = "MatDPurple", packageType= PackageType.PK_500, color = Color(0xFF673AB7))
    val MatDBlue = KvColor(colorName = "MatDBlue", packageType= PackageType.PK_500, color = Color(0xFF3F51B5))
    val MatLBlue = KvColor(colorName = "MatLBlue", packageType= PackageType.PK_500, color = Color(0xFF2196F3))
    val MatLLBlue = KvColor(colorName = "MatLLBlue", packageType= PackageType.PK_500, color = Color(0xFF03A9F4))
    val MatLCyan = KvColor(colorName = "MatLCyan", packageType= PackageType.PK_500, color = Color(0xFF00BCD4))
    val MatDCyan = KvColor(colorName = "MatDCyan", packageType= PackageType.PK_500, color = Color(0xFF009688))
    val MatDGreen = KvColor(colorName = "MatDGreen", packageType= PackageType.PK_500, color = Color(0xFF4CAF50))
    val MatLGreen = KvColor(colorName = "MatLGreen", packageType= PackageType.PK_500, color = Color(0xFF8BC34A))
    val MatLLGreen = KvColor(colorName = "MatLLGreen", packageType= PackageType.PK_500, color = Color(0xFFCDDC39))
    val MatYellow = KvColor(colorName = "MatYellow", packageType= PackageType.PK_500, color = Color(0xFFFFEB3B))
    val MatGold = KvColor(colorName = "MatGold", packageType= PackageType.PK_500, color = Color(0xFFFFC107))
    val MatOrange = KvColor(colorName = "MatOrange", packageType= PackageType.PK_500, color = Color(0xFFFF9800))
    val MatBlack = KvColor(colorName = "MatOrange", packageType= PackageType.PK_500, color = Color(0xAA000000))

    override fun getColorList(): List<KvColor> = listOf(
        MatRed,
        MatRose,
        MatLPurple,
        MatDPurple,
        MatDBlue,
        MatLBlue,
        MatLLBlue,
        MatLCyan,
        MatDCyan,
        MatDGreen,
        MatLGreen,
        MatLLGreen,
        MatYellow,
        MatGold,
        MatOrange,
    )
}

/**
 * Material colors 700
 * This is for internal usage only.
 */
internal object Mat700Package: ColorPackage() {
    val MatRed = KvColor(colorName = "MatRed", packageType= PackageType.PK_700, color = Color(0xFFD32F2F))
    val MatRose = KvColor(colorName = "MatRose", packageType= PackageType.PK_700, color = Color(0xFFC2185B))
    val MatLPurple = KvColor(colorName = "MatLPurple", packageType= PackageType.PK_700, color = Color(0xFF7B1FA2))
    val MatDPurple = KvColor(colorName = "MatDPurple", packageType= PackageType.PK_700, color = Color(0xFF512DA8))
    val MatDBlue = KvColor(colorName = "MatDBlue", packageType= PackageType.PK_700, color = Color(0xFF303F9F))
    val MatLBlue = KvColor(colorName = "MatLBlue", packageType= PackageType.PK_700, color = Color(0xFF1976D2))
    val MatLLBlue = KvColor(colorName = "MatLLBlue", packageType= PackageType.PK_700, color = Color(0xFF0288D1))
    val MatLCyan = KvColor(colorName = "MatLCyan", packageType= PackageType.PK_700, color = Color(0xFF0097A7))
    val MatDCyan = KvColor(colorName = "MatDCyan", packageType= PackageType.PK_700, color = Color(0xFF00796B))
    val MatDGreen = KvColor(colorName = "MatDGreen", packageType= PackageType.PK_700, color = Color(0xFF388E3C))
    val MatLGreen = KvColor(colorName = "MatLGreen", packageType= PackageType.PK_700, color = Color(0xFF689F38))
    val MatLLGreen = KvColor(colorName = "MatLLGreen", packageType= PackageType.PK_700, color = Color(0xFFAFB42B))
    val MatYellow = KvColor(colorName = "MatYellow", packageType= PackageType.PK_700, color = Color(0xFFFBC02D))
    val MatGold = KvColor(colorName = "MatGold", packageType= PackageType.PK_700, color = Color(0xFFFFA000))
    val MatOrange = KvColor(colorName = "MatOrange", packageType= PackageType.PK_700, color = Color(0xFFF57C00))

    override fun getColorList(): List<KvColor> = listOf(
        MatRed,
        MatRose,
        MatLPurple,
        MatDPurple,
        MatDBlue,
        MatLBlue,
        MatLLBlue,
        MatLCyan,
        MatDCyan,
        MatDGreen,
        MatLGreen,
        MatLLGreen,
        MatYellow,
        MatGold,
        MatOrange,
    )
}

/**
 * Material colors 600
 * This is for internal usage only.
 */
internal object Mat600Package: ColorPackage() {
    val MatRed = KvColor(colorName = "MatRed", packageType= PackageType.PK_600, color = Color(0xFFE53935))
    val MatRose = KvColor(colorName = "MatRose", packageType= PackageType.PK_600, color = Color(0xFFD81B60))
    val MatLPurple = KvColor(colorName = "MatLPurple", packageType= PackageType.PK_600, color = Color(0xFF8E24AA))
    val MatDPurple = KvColor(colorName = "MatDPurple", packageType= PackageType.PK_600, color = Color(0xFF5E35B1))
    val MatDBlue = KvColor(colorName = "MatDBlue", packageType= PackageType.PK_600, color = Color(0xFF3949AB))
    val MatLBlue = KvColor(colorName = "MatLBlue", packageType= PackageType.PK_600, color = Color(0xFF1E88E5))
    val MatLLBlue = KvColor(colorName = "MatLLBlue", packageType= PackageType.PK_600, color = Color(0xFF039BE5))
    val MatLCyan = KvColor(colorName = "MatLCyan", packageType= PackageType.PK_600, color = Color(0xFF00ACC1))
    val MatDCyan = KvColor(colorName = "MatDCyan", packageType= PackageType.PK_600, color = Color(0xFF00897B))
    val MatDGreen = KvColor(colorName = "MatDGreen", packageType= PackageType.PK_600, color = Color(0xFF43A047))
    val MatLGreen = KvColor(colorName = "MatLGreen", packageType= PackageType.PK_600, color = Color(0xFF7CB342))
    val MatLLGreen = KvColor(colorName = "MatLLGreen", packageType= PackageType.PK_600, color = Color(0xFFC0CA33))
    val MatYellow = KvColor(colorName = "MatYellow", packageType= PackageType.PK_600, color = Color(0xFFFDD835))
    val MatGold = KvColor(colorName = "MatGold", packageType= PackageType.PK_600, color = Color(0xFFFFB300))
    val MatOrange = KvColor(colorName = "MatOrange", packageType= PackageType.PK_600, color = Color(0xFFFB8C00))

    override fun getColorList(): List<KvColor> = listOf(
        MatRed,
        MatRose,
        MatLPurple,
        MatDPurple,
        MatDBlue,
        MatLBlue,
        MatLLBlue,
        MatLCyan,
        MatDCyan,
        MatDGreen,
        MatLGreen,
        MatLLGreen,
        MatYellow,
        MatGold,
        MatOrange,
    )
}

/**
 * Material colors 400
 * This is for internal usage only.
 */
internal object Mat400Package: ColorPackage() {
    val MatRed = KvColor(colorName = "MatRed", packageType= PackageType.PK_400, color = Color(0xFFEF5350))
    val MatRose = KvColor(colorName = "MatRose", packageType= PackageType.PK_400, color = Color(0xFFEC407A))
    val MatLPurple = KvColor(colorName = "MatLPurple", packageType= PackageType.PK_400, color = Color(0xFFAB47BC))
    val MatDPurple = KvColor(colorName = "MatDPurple", packageType= PackageType.PK_400, color = Color(0xFF7E57C2))
    val MatDBlue = KvColor(colorName = "MatDBlue", packageType= PackageType.PK_400, color = Color(0xFF5C6BC0))
    val MatLBlue = KvColor(colorName = "MatLBlue", packageType= PackageType.PK_400, color = Color(0xFF42A5F5))
    val MatLLBlue = KvColor(colorName = "MatLLBlue", packageType= PackageType.PK_400, color = Color(0xFF29B6F6))
    val MatLCyan = KvColor(colorName = "MatLCyan", packageType= PackageType.PK_400, color = Color(0xFF26C6DA))
    val MatDCyan = KvColor(colorName = "MatDCyan", packageType= PackageType.PK_400, color = Color(0xFF26A69A))
    val MatDGreen = KvColor(colorName = "MatDGreen", packageType= PackageType.PK_400, color = Color(0xFF66BB6A))
    val MatLGreen = KvColor(colorName = "MatLGreen", packageType= PackageType.PK_400, color = Color(0xFF9CCC65))
    val MatLLGreen = KvColor(colorName = "MatLLGreen", packageType= PackageType.PK_400, color = Color(0xFFD4E157))
    val MatYellow = KvColor(colorName = "MatYellow", packageType= PackageType.PK_400, color = Color(0xFFFFEE58))
    val MatGold = KvColor(colorName = "MatGold", packageType= PackageType.PK_400, color = Color(0xFFFFCA28))
    val MatOrange = KvColor(colorName = "MatOrange", packageType= PackageType.PK_400, color = Color(0xFFFFA726))

    override fun getColorList(): List<KvColor> = listOf(
        MatRed,
        MatRose,
        MatLPurple,
        MatDPurple,
        MatDBlue,
        MatLBlue,
        MatLLBlue,
        MatLCyan,
        MatDCyan,
        MatDGreen,
        MatLGreen,
        MatLLGreen,
        MatYellow,
        MatGold,
        MatOrange,
    )
}

/**
 * Material colors 300
 * This is for internal usage only.
 */
internal object Mat300Package: ColorPackage() {
    val MatRed = KvColor(colorName = "MatRed", packageType= PackageType.PK_300, color = Color(0xFFE57373))
    val MatRose = KvColor(colorName = "MatRose", packageType= PackageType.PK_300, color = Color(0xFFF06292))
    val MatLPurple = KvColor(colorName = "MatLPurple", packageType= PackageType.PK_300, color = Color(0xFFBA68C8))
    val MatDPurple = KvColor(colorName = "MatDPurple", packageType= PackageType.PK_300, color = Color(0xFF9575CD))
    val MatDBlue = KvColor(colorName = "MatDBlue", packageType= PackageType.PK_300, color = Color(0xFF7986CB))
    val MatLBlue = KvColor(colorName = "MatLBlue", packageType= PackageType.PK_300, color = Color(0xFF64B5F6))
    val MatLLBlue = KvColor(colorName = "MatLLBlue", packageType= PackageType.PK_300, color = Color(0xFF4FC3F7))
    val MatLCyan = KvColor(colorName = "MatLCyan", packageType= PackageType.PK_300, color = Color(0xFF4DD0E1))
    val MatDCyan = KvColor(colorName = "MatDCyan", packageType= PackageType.PK_300, color = Color(0xFF4DB6AC))
    val MatDGreen = KvColor(colorName = "MatDGreen", packageType= PackageType.PK_300, color = Color(0xFF81C784))
    val MatLGreen = KvColor(colorName = "MatLGreen", packageType= PackageType.PK_300, color = Color(0xFFAED581))
    val MatLLGreen = KvColor(colorName = "MatLLGreen", packageType= PackageType.PK_300, color = Color(0xFFDCE775))
    val MatYellow = KvColor(colorName = "MatYellow", packageType= PackageType.PK_300, color = Color(0xFFFFF176))
    val MatGold = KvColor(colorName = "MatGold", packageType= PackageType.PK_300, color = Color(0xFFFFD54F))
    val MatOrange = KvColor(colorName = "MatOrange", packageType= PackageType.PK_300, color = Color(0xFFFFB74D))

    override fun getColorList(): List<KvColor> = listOf(
        MatRed,
        MatRose,
        MatLPurple,
        MatDPurple,
        MatDBlue,
        MatLBlue,
        MatLLBlue,
        MatLCyan,
        MatDCyan,
        MatDGreen,
        MatLGreen,
        MatLLGreen,
        MatYellow,
        MatGold,
        MatOrange,
    )
}

/**
 * Material colors 200
 * This is for internal usage only.
 */
internal object Mat200Package: ColorPackage() {
    val MatRed = KvColor(colorName = "MatRed", packageType= PackageType.PK_200, color = Color(0xFFEF9A9A))
    val MatRose = KvColor(colorName = "MatRose", packageType= PackageType.PK_200, color = Color(0xFFF48FB1))
    val MatLPurple = KvColor(colorName = "MatLPurple", packageType= PackageType.PK_200, color = Color(0xFFCE93D8))
    val MatDPurple = KvColor(colorName = "MatDPurple", packageType= PackageType.PK_200, color = Color(0xFFB39DDB))
    val MatDBlue = KvColor(colorName = "MatDBlue", packageType= PackageType.PK_200, color = Color(0xFF9FA8DA))
    val MatLBlue = KvColor(colorName = "MatLBlue", packageType= PackageType.PK_200, color = Color(0xFF90CAF9))
    val MatLLBlue = KvColor(colorName = "MatLLBlue", packageType= PackageType.PK_200, color = Color(0xFF81D4FA))
    val MatLCyan = KvColor(colorName = "MatLCyan", packageType= PackageType.PK_200, color = Color(0xFF80DEEA))
    val MatDCyan = KvColor(colorName = "MatDCyan", packageType= PackageType.PK_200, color = Color(0xFF80CBC4))
    val MatDGreen = KvColor(colorName = "MatDGreen", packageType= PackageType.PK_200, color = Color(0xFFA5D6A7))
    val MatLGreen = KvColor(colorName = "MatLGreen", packageType= PackageType.PK_200, color = Color(0xFFC5E1A5))
    val MatLLGreen = KvColor(colorName = "MatLLGreen", packageType= PackageType.PK_200, color = Color(0xFFE6EE9C))
    val MatYellow = KvColor(colorName = "MatYellow", packageType= PackageType.PK_200, color = Color(0xFFFFF59D))
    val MatGold = KvColor(colorName = "MatGold", packageType= PackageType.PK_200, color = Color(0xFFFFE082))
    val MatOrange = KvColor(colorName = "MatOrange", packageType= PackageType.PK_200, color = Color(0xFFFFCC80))

    override fun getColorList(): List<KvColor> = listOf(
        MatRed,
        MatRose,
        MatLPurple,
        MatDPurple,
        MatDBlue,
        MatLBlue,
        MatLLBlue,
        MatLCyan,
        MatDCyan,
        MatDGreen,
        MatLGreen,
        MatLLGreen,
        MatYellow,
        MatGold,
        MatOrange,
    )
}

/**
 * Material colors 100
 * This is for internal usage only.
 */
internal object Mat100Package: ColorPackage() {
    val MatRed = KvColor(colorName = "MatRed", packageType= PackageType.PK_100, color = Color(0xFFFFCDD2))
    val MatRose = KvColor(colorName = "MatRose", packageType= PackageType.PK_100, color = Color(0xFFF8BBD0))
    val MatLPurple = KvColor(colorName = "MatLPurple", packageType= PackageType.PK_100, color = Color(0xFFE1BEE7))
    val MatDPurple = KvColor(colorName = "MatDPurple", packageType= PackageType.PK_100, color = Color(0xFFD1C4E9))
    val MatDBlue = KvColor(colorName = "MatDBlue", packageType= PackageType.PK_100, color = Color(0xFFC5CAE9))
    val MatLBlue = KvColor(colorName = "MatLBlue", packageType= PackageType.PK_100, color = Color(0xFFBBDEFB))
    val MatLLBlue = KvColor(colorName = "MatLLBlue", packageType= PackageType.PK_100, color = Color(0xFFB3E5FC))
    val MatLCyan = KvColor(colorName = "MatLCyan", packageType= PackageType.PK_100, color = Color(0xFFB2EBF2))
    val MatDCyan = KvColor(colorName = "MatDCyan", packageType= PackageType.PK_100, color = Color(0xFFB2DFDB))
    val MatDGreen = KvColor(colorName = "MatDGreen", packageType= PackageType.PK_100, color = Color(0xFFC8E6C9))
    val MatLGreen = KvColor(colorName = "MatLGreen", packageType= PackageType.PK_100, color = Color(0xFFDCEDC8))
    val MatLLGreen = KvColor(colorName = "MatLLGreen", packageType= PackageType.PK_100, color = Color(0xFFF0F4C3))
    val MatYellow = KvColor(colorName = "MatYellow", packageType= PackageType.PK_100, color = Color(0xFFFFF9C4))
    val MatGold = KvColor(colorName = "MatGold", packageType= PackageType.PK_100, color = Color(0xFFFFECB3))
    val MatOrange = KvColor(colorName = "MatOrange", packageType= PackageType.PK_100, color = Color(0xFFFFE0B2))

    override fun getColorList(): List<KvColor> = listOf(
        MatRed,
        MatRose,
        MatLPurple,
        MatDPurple,
        MatDBlue,
        MatLBlue,
        MatLLBlue,
        MatLCyan,
        MatDCyan,
        MatDGreen,
        MatLGreen,
        MatLLGreen,
        MatYellow,
        MatGold,
        MatOrange,
    )
}

/**
 * Material colors 50
 * This is for internal usage only.
 */
internal object Mat50Package: ColorPackage() {
    val MatRed = KvColor(colorName = "MatRed", packageType= PackageType.PK_50, color = Color(0xFFFFEBEE))
    val MatRose = KvColor(colorName = "MatRose", packageType= PackageType.PK_50, color = Color(0xFFFCE4EC))
    val MatLPurple = KvColor(colorName = "MatLPurple", packageType= PackageType.PK_50, color = Color(0xFFF3E5F5))
    val MatDPurple = KvColor(colorName = "MatDPurple", packageType= PackageType.PK_50, color = Color(0xFFEDE7F6))
    val MatDBlue = KvColor(colorName = "MatDBlue", packageType= PackageType.PK_50, color = Color(0xFFE8EAF6))
    val MatLBlue = KvColor(colorName = "MatLBlue", packageType= PackageType.PK_50, color = Color(0xFFE3F2FD))
    val MatLLBlue = KvColor(colorName = "MatLLBlue", packageType= PackageType.PK_50, color = Color(0xFFE1F5FE))
    val MatLCyan = KvColor(colorName = "MatLCyan", packageType= PackageType.PK_50, color = Color(0xFFE0F7FA))
    val MatDCyan = KvColor(colorName = "MatDCyan", packageType= PackageType.PK_50, color = Color(0xFFE0F2F1))
    val MatDGreen = KvColor(colorName = "MatDGreen", packageType= PackageType.PK_50, color = Color(0xFFE8F5E9))
    val MatLGreen = KvColor(colorName = "MatLGreen", packageType= PackageType.PK_50, color = Color(0xFFF1F8E9))
    val MatLLGreen = KvColor(colorName = "MatLLGreen", packageType= PackageType.PK_50, color = Color(0xFFF9FBE7))
    val MatYellow = KvColor(colorName = "MatYellow", packageType= PackageType.PK_50, color = Color(0xFFFFFDE7))
    val MatGold = KvColor(colorName = "MatGold", packageType= PackageType.PK_50, color = Color(0xFFFFF8E1))
    val MatOrange = KvColor(colorName = "MatOrange", packageType= PackageType.PK_50, color = Color(0xFFFFF3E0))

    override fun getColorList(): List<KvColor> = listOf(
        MatRed,
        MatRose,
        MatLPurple,
        MatDPurple,
        MatDBlue,
        MatLBlue,
        MatLLBlue,
        MatLCyan,
        MatDCyan,
        MatDGreen,
        MatLGreen,
        MatLLGreen,
        MatYellow,
        MatGold,
        MatOrange,
    )
}