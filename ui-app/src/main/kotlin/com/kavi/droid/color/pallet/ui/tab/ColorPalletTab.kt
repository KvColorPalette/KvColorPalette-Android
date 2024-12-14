package com.kavi.droid.color.pallet.ui.tab

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.kavi.droid.color.pallet.KvColorPallet
import com.kavi.droid.color.pallet.color.MatPackage
import com.kavi.droid.color.pallet.model.KvColor
import com.kavi.droid.color.pallet.util.ColorUtil

@Composable
fun ColorPalletTab() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .padding(top = 40.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        ColorRow(givenColor = MatPackage.MatRed)
        ColorRow(givenColor = MatPackage.MatRose)
        ColorRow(givenColor = MatPackage.MatLPurple)
        ColorRow(givenColor = MatPackage.MatDPurple)
        ColorRow(givenColor = MatPackage.MatDBlue)
        ColorRow(givenColor = MatPackage.MatLBlue)
        ColorRow(givenColor = MatPackage.MatLLBlue)
        ColorRow(givenColor = MatPackage.MatLCyan)
        ColorRow(givenColor = MatPackage.MatDCyan)
        ColorRow(givenColor = MatPackage.MatDGreen)
        ColorRow(givenColor = MatPackage.MatLGreen)
        ColorRow(givenColor = MatPackage.MatLLGreen)
        ColorRow(givenColor = MatPackage.MatYellow)
        ColorRow(givenColor = MatPackage.MatGold)
        ColorRow(givenColor = MatPackage.MatOrange)
    }
}

@Composable
fun ColorRow(givenColor: KvColor) {
    val colors = KvColorPallet(givenColor.color).generateAlphaColorPallet(givenColor.color)
//    val colors = KvColorPallet(givenColor.color).generateColorPallet(givenColor)
    Row {
        colors.forEach {
            ColorBox(givenColor = it)
        }
    }
}

@Composable
fun ColorBox(givenColor: Color) {
    var isSelected by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .width(40.dp)
            .height(40.dp)
            .background(givenColor, RectangleShape)
            .clickable {
                isSelected = true
                Log.d(
                    "ColorBox",
                    "RED: ${givenColor.red}, GREEN: ${givenColor.green}, BLUE: ${givenColor.blue}, ALPHA: ${givenColor.alpha}"
                )
                Log.d("ColorBox", "HEX: ${ColorUtil.getHexWithAlpha(givenColor)}")

//                val closestColor = ColorUtil.findClosestColor(givenColor)
//                Log.d(
//                    "ClosestColor",
//                    "name: ${closestColor.colorName} + package: ${closestColor.colorPackage} + HEX: ${closestColor.colorHexWithAlpha}"
//                )

//                val closestColor1 = ColorUtil.findClosestColor(Color.Blue)
//                Log.d(
//                    "ClosestColor",
//                    "name: ${closestColor1.colorName} + package: ${closestColor1.colorPackage} + HEX: ${closestColor1.colorHexWithAlpha}"
//                )
            }
            .then(if (isSelected) Modifier.border(2.dp, Color.White) else Modifier)
    )
}