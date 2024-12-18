package com.kavi.droid.color.pallet.ui.tab.pallet.pager

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kavi.droid.color.pallet.KvColorPallet
import com.kavi.droid.color.pallet.color.MatPackage
import com.kavi.droid.color.pallet.model.KvColor
import com.kavi.droid.color.pallet.ui.common.ColorBox

@Composable
fun AlphaPalletPager() {

    var selectedColor by remember { mutableStateOf(Color.White) }

    Column {
        Row (Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, end = 8.dp),
        ) {
            Text(
                modifier = Modifier.padding(8.dp)
                    .padding(top = 24.dp),
                text = "Alpha Pallet",
                style = MaterialTheme.typography.titleLarge
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
        ) {
            AlphaPalletColorRow(givenColor = MatPackage.MatRed, selectedColor = selectedColor) { color -> selectedColor = color }
            AlphaPalletColorRow(givenColor = MatPackage.MatRose, selectedColor = selectedColor) { color -> selectedColor = color }
            AlphaPalletColorRow(givenColor = MatPackage.MatLPurple, selectedColor = selectedColor) { color -> selectedColor = color }
            AlphaPalletColorRow(givenColor = MatPackage.MatDPurple, selectedColor = selectedColor) { color -> selectedColor = color }
            AlphaPalletColorRow(givenColor = MatPackage.MatDBlue, selectedColor = selectedColor) { color -> selectedColor = color }
            AlphaPalletColorRow(givenColor = MatPackage.MatLBlue, selectedColor = selectedColor) { color -> selectedColor = color }
            AlphaPalletColorRow(givenColor = MatPackage.MatLLBlue, selectedColor = selectedColor) { color -> selectedColor = color }
            AlphaPalletColorRow(givenColor = MatPackage.MatLCyan, selectedColor = selectedColor) { color -> selectedColor = color }
            AlphaPalletColorRow(givenColor = MatPackage.MatDCyan, selectedColor = selectedColor) { color -> selectedColor = color }
            AlphaPalletColorRow(givenColor = MatPackage.MatDGreen, selectedColor = selectedColor) { color -> selectedColor = color }
            AlphaPalletColorRow(givenColor = MatPackage.MatLGreen, selectedColor = selectedColor) { color -> selectedColor = color }
            AlphaPalletColorRow(givenColor = MatPackage.MatLLGreen, selectedColor = selectedColor) { color -> selectedColor = color }
            AlphaPalletColorRow(givenColor = MatPackage.MatYellow, selectedColor = selectedColor) { color -> selectedColor = color }
            AlphaPalletColorRow(givenColor = MatPackage.MatGold, selectedColor = selectedColor) { color -> selectedColor = color }
            AlphaPalletColorRow(givenColor = MatPackage.MatOrange, selectedColor = selectedColor) { color -> selectedColor = color }
        }

        Row (Modifier
            .fillMaxWidth()
            .border(1.dp, Color.White, shape = RoundedCornerShape(8.dp))
            .shadow(
                elevation = 10.dp,
                shape = RoundedCornerShape(8.dp)
            )
            .background(Color.White)
        ) {
            Log.d("COLOR: ", "RED: ${selectedColor.red}, GREEN: ${selectedColor.green}, BLUE: ${selectedColor.blue}, ALPHA: ${selectedColor.alpha}")
        }
    }
}

@Composable
fun AlphaPalletColorRow(givenColor: KvColor, selectedColor: Color, onSelect: (color: Color) -> Unit) {
    val colors = KvColorPallet.instance!!.generateAlphaColorPallet(givenColor.color)
    Row {
        colors.forEach {
            ColorBox(givenColor = it, selectedColor = selectedColor, onSelect = onSelect)
        }
    }
}

@Preview
@Composable
fun AlphaPalletPagerPreview() {
    AlphaPalletPager()
}