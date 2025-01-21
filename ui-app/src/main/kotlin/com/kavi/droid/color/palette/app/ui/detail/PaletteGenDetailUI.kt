package com.kavi.droid.color.palette.app.ui.detail

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.kavi.droid.color.palette.app.theme.KvColorPaletteTheme

@Composable
fun PaletteGenDetailUI() {
    Text(text = "PaletteGenDetailUI")
}

@Preview(showBackground = true)
@Composable
fun PaletteGenDetailUIPreview() {
    KvColorPaletteTheme {
        PaletteGenDetailUI()
    }
}