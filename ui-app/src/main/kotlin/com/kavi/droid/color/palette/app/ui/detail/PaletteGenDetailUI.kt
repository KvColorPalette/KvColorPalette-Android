package com.kavi.droid.color.palette.app.ui.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kavi.droid.color.palette.KvColorPalette
import com.kavi.droid.color.palette.app.R
import com.kavi.droid.color.palette.app.model.PaletteType
import com.kavi.droid.color.palette.app.theme.KvColorPaletteTheme
import com.kavi.droid.color.palette.app.ui.common.ColorStrip
import com.kavi.droid.color.palette.app.ui.common.picker.KvColorPickerBottomSheet
import com.kavi.droid.color.palette.extension.isHighLightColor
import com.kavi.droid.color.palette.util.ColorUtil

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaletteGenDetailUI(paletteType: PaletteType) {

    var selectedColor by remember { mutableStateOf(Color.White) }
    var colorHex by remember { mutableStateOf(TextFieldValue("")) }
    var colorPalette by remember { mutableStateOf<List<Color>>(emptyList()) }

    val showSheet = remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row (Modifier
                .fillMaxWidth()
                .padding(top = 24.dp)
            ) {
                val palletName = when(paletteType) {
                    PaletteType.KV_PALETTE -> "Kv Palette"
                    PaletteType.ALPHA_PALETTE -> "Alpha"
                    PaletteType.LIGHTNESS_PALETTE -> "Lightness"
                    PaletteType.SATURATION_PALETTE -> "Saturation"
                }
                
                Text(
                    modifier = Modifier
                        .padding(8.dp),
                    text = "Color Palette Generator [$palletName]",
                    style = MaterialTheme.typography.titleLarge,
                    fontSize = 28.sp
                )
            }

            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .border(1.dp, Color.White, shape = RoundedCornerShape(8.dp))
                    .shadow(
                        elevation = 10.dp,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .background(Color.White)
                    .padding(12.dp)
            ) {
                Row {
                    Column (
                        modifier = Modifier
                            .weight(.75f)
                    ) {
                        Text(
                            modifier = Modifier
                                .padding(top = 4.dp, bottom = 4.dp),
                            text = "Select your color",
                            style = MaterialTheme.typography.titleMedium,
                            fontSize = 20.sp,
                        )

                        Text(
                            text = "Touch on the color box or type your color-hex " +
                                    "on below to pick your primary color to generate color palette.",
                            textAlign = TextAlign.Start,
                            color = Color.Gray,
                            style = MaterialTheme.typography.bodySmall,
                            fontSize = 10.sp
                        )

                        OutlinedTextField(
                            modifier = Modifier
                                .width(200.dp)
                                .padding(1.dp),
                            value = colorHex,
                            maxLines = 1,
                            label = { Text(text = "Color Hex") },
                            onValueChange = { newColorHex ->
                                colorHex = newColorHex
                                if (ColorUtil.validateColorHex(newColorHex.text))
                                    selectedColor = ColorUtil.getColorFromHex(newColorHex.text)
                                else {
                                    TextFieldValue("")
                                    println("Not Valid")
                                }
                            }
                        )
                    }

                    // Display the current color in a Box with a MaterialTheme shape
                    Box(
                        modifier = Modifier
                            .padding(12.dp)
                            .height(80.dp)
                            .width(80.dp)
                            .weight(.25f)
                            .background(selectedColor, shape = MaterialTheme.shapes.large)
                            .border(2.dp, MaterialTheme.colorScheme.primary, RoundedCornerShape(12.dp))
                            .clickable {
                                showSheet.value = true
                            }
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.icon_click_me),
                            contentDescription = "Select Color",
                            tint = if (selectedColor.isHighLightColor) Color.Black else Color.White,
                            modifier = Modifier
                                .align(Alignment.Center)
                        )
                    }
                }
            }

            Button(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                onClick = {
                    colorPalette = when (paletteType) {
                        PaletteType.KV_PALETTE -> {
                            val closestKvColor = KvColorPalette.instance.findClosestKvColor(givenColor = selectedColor)
                            KvColorPalette.instance.generateColorPalette(givenColor = closestKvColor)
                        }
                        PaletteType.ALPHA_PALETTE -> KvColorPalette.instance.generateAlphaColorPalette(givenColor = selectedColor)
                        PaletteType.LIGHTNESS_PALETTE -> KvColorPalette.instance.generateLightnessColorPalette(givenColor = selectedColor)
                        PaletteType.SATURATION_PALETTE -> KvColorPalette.instance.generateSaturationColorPalette(givenColor = selectedColor)
                    }
                }
            ) {
                Text("Generate Palette")
            }

            if (showSheet.value) {
                KvColorPickerBottomSheet(showSheet = showSheet,
                    sheetState = sheetState, onColorSelected = {
                        selectedColor = it
                        colorHex = TextFieldValue(ColorUtil.getHex(color = selectedColor))
                })
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(8.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .verticalScroll(rememberScrollState()),
            ) {
                colorPalette.forEach {
                    ColorStrip(color = it)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PaletteGenDetailUIPreview() {
    KvColorPaletteTheme {
        PaletteGenDetailUI(paletteType = PaletteType.LIGHTNESS_PALETTE)
    }
}