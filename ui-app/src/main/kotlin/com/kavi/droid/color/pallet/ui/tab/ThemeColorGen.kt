package com.kavi.droid.color.pallet.ui.tab

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kavi.droid.color.pallet.KvColorPallet
import com.kavi.droid.color.pallet.color.MatPackage
import com.kavi.droid.color.pallet.model.KvColor

@Composable
fun ThemeColorGen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ThemeColorRow(MatPackage.MatRed)
        ThemeColorRow(MatPackage.MatOrange)
        ThemeColorRow(MatPackage.MatDGreen)
    }
}

@Composable
fun ThemeColorRow(givenColor: KvColor) {
    Box(
        modifier = Modifier
            .padding(10.dp)
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, Color.White, shape = RoundedCornerShape(8.dp))
            .shadow(
                elevation = 10.dp,
                shape = RoundedCornerShape(8.dp)
            )
            .background(Color.White),
            verticalArrangement = Arrangement.Center,
        ) {
            val appThemeColorSet = KvColorPallet().generateThemeColorPallet(
                givenColor = givenColor,
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                ColorCircle(appThemeColorSet.light.primary)
                ColorCircle(appThemeColorSet.light.secondary)
                ColorCircle(appThemeColorSet.light.tertiary)
                ColorCircle(appThemeColorSet.light.background)
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                ColorCircle(appThemeColorSet.dark.primary)
                ColorCircle(appThemeColorSet.dark.secondary)
                ColorCircle(appThemeColorSet.dark.tertiary)
                ColorCircle(appThemeColorSet.dark.background)
            }
        }
    }
}

@Composable
fun ColorCircle(givenColor: Color) {

    val circleSize = 48.dp

    Box(
        modifier = Modifier
            .padding(16.dp)
    ) {
        Canvas(
            modifier = Modifier.size(circleSize)
        ) {
            drawCircle(color = givenColor, radius = circleSize.toPx() / 2)
        }
    }
}

@Preview
@Composable
fun ThemeColorGenPreview() {
    ThemeColorGen()
}