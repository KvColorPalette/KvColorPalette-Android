package com.kavi.droid.color.pallet.ui.tab.pallet.pager

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.kavi.droid.color.pallet.KvColorPallet
import com.kavi.droid.color.pallet.color.MatPackage
import com.kavi.droid.color.pallet.model.KvColor
import com.kavi.droid.color.pallet.ui.common.ColorBox
import com.kavi.droid.color.pallet.ui.common.ColorDetailRow

@Composable
fun PalletPager() {

    var selectedColor by remember { mutableStateOf(Color.White) }

    Column {
        Row (Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, end = 8.dp),
        ) {
            Text(
                modifier = Modifier.padding(8.dp)
                    .padding(top = 24.dp),
                text = "Color Pallet",
                style = MaterialTheme.typography.titleLarge
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp, start = 16.dp, end = 16.dp, bottom = 8.dp),
        ) {
            PalletColorRow(givenColor = MatPackage.MatRed, selectedColor = selectedColor) { color -> selectedColor = color }
            PalletColorRow(givenColor = MatPackage.MatRose, selectedColor = selectedColor) { color -> selectedColor = color }
            PalletColorRow(givenColor = MatPackage.MatLPurple, selectedColor = selectedColor) { color -> selectedColor = color }
            PalletColorRow(givenColor = MatPackage.MatDPurple, selectedColor = selectedColor) { color -> selectedColor = color }
            PalletColorRow(givenColor = MatPackage.MatDBlue, selectedColor = selectedColor) { color -> selectedColor = color }
            PalletColorRow(givenColor = MatPackage.MatLBlue, selectedColor = selectedColor) { color -> selectedColor = color }
            PalletColorRow(givenColor = MatPackage.MatLLBlue, selectedColor = selectedColor) { color -> selectedColor = color }
            PalletColorRow(givenColor = MatPackage.MatLCyan, selectedColor = selectedColor) { color -> selectedColor = color }
            PalletColorRow(givenColor = MatPackage.MatDCyan, selectedColor = selectedColor) { color -> selectedColor = color }
            PalletColorRow(givenColor = MatPackage.MatDGreen, selectedColor = selectedColor) { color -> selectedColor = color }
            PalletColorRow(givenColor = MatPackage.MatLGreen, selectedColor = selectedColor) { color -> selectedColor = color }
            PalletColorRow(givenColor = MatPackage.MatLLGreen, selectedColor = selectedColor) { color -> selectedColor = color }
            PalletColorRow(givenColor = MatPackage.MatYellow, selectedColor = selectedColor) { color -> selectedColor = color }
            PalletColorRow(givenColor = MatPackage.MatGold, selectedColor = selectedColor) { color -> selectedColor = color }
            PalletColorRow(givenColor = MatPackage.MatOrange, selectedColor = selectedColor) { color -> selectedColor = color }
        }

        ColorDetailRow(selectedColor = selectedColor)
    }
}

@Composable
fun PalletColorRow(givenColor: KvColor, selectedColor: Color, onSelect: (color: Color) -> Unit) {
    val colors = KvColorPallet(givenColor.color).generateColorPallet(givenColor)
    Row {
        colors.forEach {
            ColorBox(givenColor = it, selectedColor = selectedColor, onSelect = onSelect)
        }
    }
}