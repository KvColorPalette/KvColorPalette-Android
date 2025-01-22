package com.kavi.droid.color.palette.app.ui.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kavi.droid.color.palette.app.theme.KvColorPaletteTheme
import com.kavi.droid.color.palette.app.ui.common.picker.KvColorPicker

@Composable
fun ThemeGenDetailUI() {
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

            KvColorPicker(modifier = Modifier.padding(8.dp), onColorSelected = { selectedColor ->

            })
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