package com.kavi.droid.color.palette.app.ui.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kavi.droid.color.palette.KvColorPalette
import com.kavi.droid.color.palette.app.model.PaletteType
import com.kavi.droid.color.palette.app.theme.KvColorPaletteTheme
import com.kavi.droid.color.palette.app.ui.common.ColorStrip
import com.kavi.droid.color.palette.app.ui.common.SelectedColorUI
import com.kavi.droid.color.palette.app.ui.common.picker.KvColorPickerBottomSheet
import com.kavi.droid.color.palette.util.ColorUtil

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaletteGenDetailUI(paletteType: PaletteType) {

    val selectedColor = remember { mutableStateOf(Color.White) }
    val colorHex = remember { mutableStateOf(TextFieldValue("")) }
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

            SelectedColorUI(colorHex, selectedColor, showSheet)

            if (showSheet.value) {
                KvColorPickerBottomSheet(showSheet = showSheet,
                    sheetState = sheetState, onColorSelected = {
                        selectedColor.value = it
                        colorHex.value = TextFieldValue(ColorUtil.getHex(color = selectedColor.value))
                    })
            }

            Button(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                onClick = {
                    colorPalette = when (paletteType) {
                        PaletteType.KV_PALETTE -> {
                            val closestKvColor = KvColorPalette.instance.findClosestKvColor(givenColor = selectedColor.value)
                            KvColorPalette.instance.generateColorPalette(givenColor = closestKvColor)
                        }
                        PaletteType.ALPHA_PALETTE -> KvColorPalette.instance.generateAlphaColorPalette(givenColor = selectedColor.value)
                        PaletteType.LIGHTNESS_PALETTE -> KvColorPalette.instance.generateLightnessColorPalette(givenColor = selectedColor.value)
                        PaletteType.SATURATION_PALETTE -> KvColorPalette.instance.generateSaturationColorPalette(givenColor = selectedColor.value)
                    }
                }
            ) {
                Text("Generate Palette")
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