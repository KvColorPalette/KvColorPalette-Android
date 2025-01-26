package com.kavi.droid.color.palette.app.ui.common

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
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kavi.droid.color.palette.app.R
import com.kavi.droid.color.palette.extension.isHighLightColor
import com.kavi.droid.color.palette.util.ColorUtil

@Composable
fun SelectedColorUI(
    colorHex: MutableState<TextFieldValue>,
    selectedColor: MutableState<Color>,
    showSheet: MutableState<Boolean>
) {

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
                    color = Color.Black
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
                    value = colorHex.value,
                    maxLines = 1,
                    label = { Text(text = "Color Hex") },
                    onValueChange = { newColorHex ->
                        colorHex.value = newColorHex
                        if (ColorUtil.validateColorHex(newColorHex.text))
                            selectedColor.value = ColorUtil.getColorFromHex(newColorHex.text)
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
                    .background(selectedColor.value, shape = MaterialTheme.shapes.large)
                    .border(2.dp, MaterialTheme.colorScheme.primary, RoundedCornerShape(12.dp))
                    .clickable {
                        showSheet.value = true
                    }
            ) {
                Icon(
                    painter = painterResource(R.drawable.icon_click_me),
                    contentDescription = "Select Color",
                    tint = if (selectedColor.value.isHighLightColor) Color.Black else Color.White,
                    modifier = Modifier
                        .align(Alignment.Center)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CommonUIPreview() {
    val selectedColor = remember { mutableStateOf(Color.White) }
    val colorHex = remember { mutableStateOf(TextFieldValue("")) }
    val showSheet = remember { mutableStateOf(false) }

    SelectedColorUI(colorHex, selectedColor, showSheet)
}