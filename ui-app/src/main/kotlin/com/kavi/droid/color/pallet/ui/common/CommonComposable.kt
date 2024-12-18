package com.kavi.droid.color.pallet.ui.common

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.kavi.droid.color.pallet.util.ColorUtil

@Composable
fun ColorBox(givenColor: Color, selectedColor: Color?, onSelect: (color: Color) -> Unit) {
    var isSelected by remember { mutableStateOf(false) }

    selectedColor?.let {
        isSelected = ColorUtil.getHexWithAlpha(givenColor) == ColorUtil.getHexWithAlpha(it)
    }

    Box(
        modifier = Modifier
            .width(38.dp)
            .height(38.dp)
            .background(givenColor, RectangleShape)
            .clickable {
                isSelected = true
                onSelect(givenColor)
            }
            .then(if (isSelected) Modifier.border(2.dp, Color.White) else Modifier)
    )
}

@Composable
fun ColorDetailRow(selectedColor: Color) {
    Row (Modifier
        .padding(top = 8.dp, bottom = 8.dp, start = 16.dp, end = 16.dp)
        .fillMaxWidth()
        .border(1.dp, Color.White, shape = RoundedCornerShape(8.dp))
        .shadow(
            elevation = 10.dp,
            shape = RoundedCornerShape(8.dp)
        )
        .background(Color.White)
        .padding(12.dp)
    ) {
        Box(
            Modifier.padding(end = 8.dp)
                .width(60.dp)
                .height(60.dp)
                .background(selectedColor, RectangleShape)
                .border(2.dp, MaterialTheme.colorScheme.primary, RectangleShape)
        )

        Column {
            Row {
                Text("HEX:", modifier = Modifier.width(150.dp).padding(4.dp), style = MaterialTheme.typography.bodyMedium)
                Text(ColorUtil.getHex(color = selectedColor), modifier = Modifier.padding(4.dp), style = MaterialTheme.typography.bodyLarge)
            }

            Row {
                Text("HEX with ALPHA:", modifier = Modifier.width(150.dp).padding(4.dp), style = MaterialTheme.typography.bodyMedium)
                Text(ColorUtil.getHexWithAlpha(color = selectedColor), modifier = Modifier.padding(4.dp), style = MaterialTheme.typography.bodyLarge)
            }
        }
    }
}