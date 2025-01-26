package com.kavi.droid.color.palette.app.ui.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kavi.droid.color.palette.KvColorPalette
import com.kavi.droid.color.palette.app.theme.KvColorPaletteTheme
import com.kavi.droid.color.palette.app.ui.common.SelectedColorUI
import com.kavi.droid.color.palette.app.ui.common.ThemeColorItem
import com.kavi.droid.color.palette.app.ui.common.picker.KvColorPickerBottomSheet
import com.kavi.droid.color.palette.model.AppThemePalette
import com.kavi.droid.color.palette.util.ColorUtil

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ThemeGenDetailUI() {
    val selectedColor = remember { mutableStateOf(Color.White) }
    val colorHex = remember { mutableStateOf(TextFieldValue("")) }
    var themeColorPalette by remember { mutableStateOf<AppThemePalette?>(null) }

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
            Row (
                Modifier
                .fillMaxWidth()
                .padding(top = 24.dp)
            ) {
                Text(
                    modifier = Modifier
                        .padding(8.dp),
                    text = "Theme Generator",
                    style = MaterialTheme.typography.titleLarge
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
                    themeColorPalette = KvColorPalette.instance.generateThemeColorPalette(givenColor = selectedColor.value)
                    println("Theme Color Palette: $themeColorPalette")
                }
            ) {
                Text("Generate Theme")
            }

            themeColorPalette?.let {
                Row (
                    modifier = Modifier
                ) {
                    Column (
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("Light",
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Column (
                            modifier = Modifier
                                .padding(start = 8.dp, top = 8.dp, bottom = 8.dp, end = 2.dp)
                                .clip(RoundedCornerShape(8.dp))
                                .verticalScroll(rememberScrollState())
                        ) {
                            ThemeColorItem(color = it.light.primary, itemName = "Primary")
                            ThemeColorItem(color = it.light.secondary, itemName = "Secondary")
                            ThemeColorItem(color = it.light.tertiary, itemName = "Tertiary")
                            ThemeColorItem(color = it.light.quaternary, itemName = "Quaternary")
                            ThemeColorItem(color = it.light.onPrimary, itemName = "onPrimary")
                            ThemeColorItem(color = it.light.onSecondary, itemName = "onSecondary")
                            ThemeColorItem(color = it.light.background, itemName = "Background")
                            ThemeColorItem(color = it.light.shadow, itemName = "Shadow")
                        }
                    }

                    Column (
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("Dark",
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Column (
                            modifier = Modifier
                                .weight(1f)
                                .padding(end = 8.dp, top = 8.dp, bottom = 8.dp, start = 2.dp)
                                .clip(RoundedCornerShape(8.dp))
                                .verticalScroll(rememberScrollState())
                        ) {
                            ThemeColorItem(color = it.dark.primary, itemName = "Primary")
                            ThemeColorItem(color = it.dark.secondary, itemName = "Secondary")
                            ThemeColorItem(color = it.dark.tertiary, itemName = "Tertiary")
                            ThemeColorItem(color = it.dark.quaternary, itemName = "Quaternary")
                            ThemeColorItem(color = it.dark.onPrimary, itemName = "onPrimary")
                            ThemeColorItem(color = it.dark.onSecondary, itemName = "onSecondary")
                            ThemeColorItem(color = it.dark.background, itemName = "Background")
                            ThemeColorItem(color = it.dark.shadow, itemName = "Shadow")
                        }
                    }
                }
            }


        }
    }
}

@Preview(showBackground = true)
@Composable
fun ThemeGenDetailUIPreview() {
    KvColorPaletteTheme {
        ThemeGenDetailUI()
    }
}