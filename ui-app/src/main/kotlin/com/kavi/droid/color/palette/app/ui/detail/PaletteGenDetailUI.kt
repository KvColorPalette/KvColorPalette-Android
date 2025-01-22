package com.kavi.droid.color.palette.app.ui.detail

import androidx.compose.foundation.background
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kavi.droid.color.palette.KvColorPalette
import com.kavi.droid.color.palette.app.theme.KvColorPaletteTheme
import com.kavi.droid.color.palette.app.ui.common.ColorStrip
import com.kavi.droid.color.palette.app.ui.common.picker.KvColorPicker

@Composable
fun PaletteGenDetailUI() {
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
                Text(
                    modifier = Modifier
                        .padding(8.dp),
                    text = "Color Palette Generator",
                    style = MaterialTheme.typography.titleLarge
                )
            }

            KvColorPicker(modifier = Modifier.padding(8.dp))

            Button(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                onClick = {
                    //navController.navigate("palette-gen-detail")
                }
            ) {
                Text("Generate Palette")
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(8.dp)
                    .shadow(
                        elevation = 1.dp,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .verticalScroll(rememberScrollState()),
            ) {
                val colorPalette = KvColorPalette.instance.generateAlphaColorPalette(givenColor = Color.Red)
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
        PaletteGenDetailUI()
    }
}