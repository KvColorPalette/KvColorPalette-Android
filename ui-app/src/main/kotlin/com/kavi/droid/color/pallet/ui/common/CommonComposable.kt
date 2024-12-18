package com.kavi.droid.color.pallet.ui.common

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.kavi.droid.color.pallet.util.ColorUtil

@Composable
fun ColorBox(givenColor: Color, selectedColor: Color, onSelect: (color: Color) -> Unit) {
    var isSelected by remember { mutableStateOf(false) }

    if (ColorUtil.getHexWithAlpha(givenColor) == ColorUtil.getHexWithAlpha(selectedColor)) {
        isSelected = true
    } else {
        isSelected = false
    }

    Box(
        modifier = Modifier
            .width(40.dp)
            .height(40.dp)
            .background(givenColor, RectangleShape)
            .clickable {
                isSelected = true
                onSelect(givenColor)
//                Log.d(
//                    "ColorBox",
//                    "RED: ${givenColor.red}, GREEN: ${givenColor.green}, BLUE: ${givenColor.blue}, ALPHA: ${givenColor.alpha}"
//                )
//                Log.d("ColorBox", "HEX: ${ColorUtil.getHexWithAlpha(givenColor)}")

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