package com.kavi.droid.color.palette.app.ui.common.picker

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kavi.droid.color.palette.app.extension.toColorInt
import com.kavi.droid.color.palette.util.ColorUtil

@Composable
fun KvColorPicker(modifier: Modifier = Modifier) {
    // State variables for RGBA values
    //val alpha = rememberSaveable { mutableFloatStateOf(1f) }
    val red = rememberSaveable { mutableFloatStateOf(0f) }
    val green = rememberSaveable { mutableFloatStateOf(0f) }
    val blue = rememberSaveable { mutableFloatStateOf(0f) }

    // Derived state for the color based on RGBA values
    val color by remember {
        derivedStateOf {
            Color(red.floatValue, green.floatValue, blue.floatValue)
        }
    }

    Row(
        modifier = modifier
            .border(1.dp, Color.White, shape = RoundedCornerShape(8.dp))
            .shadow(
                elevation = 10.dp,
                shape = RoundedCornerShape(8.dp)
            )
            .background(Color.White)
            .padding(12.dp)
    ) {
        // Sliders for adjusting RGBA values
        Column(
            modifier = Modifier
                .padding(12.dp)
                .width(250.dp),
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            //ColorSlider("A", alpha, color.copy(1f))
            ColorSlider("R", red, Color.Red)
            ColorSlider("G", green, Color.Green)
            ColorSlider("B", blue, Color.Blue)
        }

        Column {
            // Display the current color in a Box with a MaterialTheme shape
            Row {
                Box(
                    modifier = Modifier
                        .padding(start = 12.dp, top = 20.dp, end = 12.dp)
                        .height(80.dp)
                        .width(80.dp)
                        .background(color, shape = MaterialTheme.shapes.large)
                        .border(2.dp, MaterialTheme.colorScheme.primary, RoundedCornerShape(12.dp))
                )
            }

            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 12.dp, top = 10.dp, end = 12.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                Text(text = ColorUtil.getHex(color = color),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Text(text = ColorUtil.getHexWithAlpha(color = color),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
        }
    }
}

/**
 * A composable function that creates a slider for adjusting a float value associated with a color.
 *
 * @param label The label to display alongside the slider.
 * @param valueState The mutable state holding the current value of the slider.
 * @param color The color used for the active track of the slider.
 */
@Composable
fun ColorSlider(
    label: String,
    valueState: MutableState<Float>,
    color: Color,
) {
    /**
     * Displays a slider for adjusting the given [valueState] associated with the provided [label].
     * The slider's active track color is set to [color].
     */
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        Text(text = label, color = Color.Black)
        Slider(
            value = valueState.value,
            onValueChange = valueState.component2(),
            colors = SliderDefaults.colors(
                thumbColor = MaterialTheme.colorScheme.primary,
                activeTrackColor = color
            ),
            modifier = Modifier.weight(1f)
        )
        Text(
            text = valueState.value.toColorInt().toString(),
            modifier = Modifier.width(25.dp),
            textAlign = TextAlign.End,
            style = MaterialTheme.typography.bodySmall,
            color = Color.Black
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ColorPickerUIPreview() {
    KvColorPicker()
}