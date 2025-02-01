package com.kavi.droid.color.palette.app.ui.common

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kavi.droid.color.palette.KvColorPalette
import com.kavi.droid.color.palette.extension.isHighLightColor
import com.kavi.droid.color.palette.util.ColorUtil

@Composable
fun ColorCircle(givenColor: Color, colorLetter: String = "", letterColor: Color = MaterialTheme.colorScheme.onPrimary) {

    val circleSize = 48.dp

    Box(
        modifier = Modifier
            .padding(4.dp)
    ) {
        Canvas(
            modifier = Modifier.size(circleSize)
        ) {
            drawCircle(color = givenColor, radius = circleSize.toPx() / 2)
        }

        Text(colorLetter, modifier = Modifier
            .padding(8.dp)
            .align(Alignment.Center),
            style = MaterialTheme.typography.bodyLarge,
            color = letterColor
        )
    }
}

@Composable
fun ThemeColorRow(givenColor: Color) {
    Box(
        modifier = Modifier
            .padding(10.dp)
    ) {
        Row(modifier = Modifier
            .border(1.dp, Color.White, shape = RoundedCornerShape(8.dp))
            .shadow(
                elevation = 10.dp,
                shape = RoundedCornerShape(8.dp)
            )
            .background(Color.White),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box (modifier = Modifier
                .width(60.dp)
                .height(220.dp)
                .padding(top = 16.dp, start = 16.dp, end = 4.dp, bottom = 16.dp)
                .background(givenColor)
            ) {
                Text("BASE",
                    modifier = Modifier
                        .padding(8.dp)
                        .width(2.dp),
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.ExtraBold,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }

            Column(modifier = Modifier
                .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
            ) {
                val appThemeColorSet = KvColorPalette.instance.generateThemeColorPalette(
                    givenColor = givenColor,
                )

                Text("Light Theme", Modifier.padding(top = 8.dp, start = 8.dp), style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.ExtraBold, color = Color.Black)

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 4.dp, start = 8.dp, end = 8.dp, bottom = 4.dp),
                    //horizontalArrangement = Arrangement.Center
                ) {
                    ColorCircle(appThemeColorSet.light.primary, colorLetter = "P")
                    ColorCircle(appThemeColorSet.light.secondary, colorLetter = "S")
                    ColorCircle(appThemeColorSet.light.tertiary, colorLetter = "T")
                    ColorCircle(appThemeColorSet.light.quaternary, colorLetter = "Q")
                    ColorCircle(appThemeColorSet.light.background, colorLetter = "B", letterColor = Color.Black)
                }

                Text("Dark Theme", Modifier.padding(top = 8.dp, start = 8.dp), style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.ExtraBold, color = Color.Black)

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 4.dp, start = 8.dp, end = 8.dp, bottom = 4.dp),
                    //horizontalArrangement = Arrangement.Center
                ) {
                    ColorCircle(appThemeColorSet.dark.primary, colorLetter = "P")
                    ColorCircle(appThemeColorSet.dark.secondary, colorLetter = "S", letterColor = Color.Black)
                    ColorCircle(appThemeColorSet.dark.tertiary, colorLetter = "T")
                    ColorCircle(appThemeColorSet.dark.quaternary, colorLetter = "Q", letterColor = Color.Black)
                    ColorCircle(appThemeColorSet.dark.background, colorLetter = "B")
                }
            }
        }
    }
}

@Composable
fun ThemeColorItem(color: Color, itemName: String) {
    Box (
        modifier = Modifier
            .height(60.dp)
            .fillMaxWidth()
            .background(color = color)
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(start = 8.dp, end = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = itemName,
                textAlign = TextAlign.Start,
                fontSize = 12.sp,
                color = if (color.isHighLightColor) Color.Black else Color.White
            )

            SelectionContainer {
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = ColorUtil.getHexWithAlpha(color),
                    textAlign = TextAlign.End,
                    fontSize = 14.sp,
                    color = if (color.isHighLightColor) Color.Black else Color.White
                )
            }
        }
    }
}