package com.kavi.droid.color.palette.app.ui.dashboard.palette

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.kavi.droid.color.palette.app.ui.dashboard.palette.pager.AlphaPalettePager
import com.kavi.droid.color.palette.app.ui.dashboard.palette.pager.LightnessPalettePager
import com.kavi.droid.color.palette.app.ui.dashboard.palette.pager.PalettePager
import com.kavi.droid.color.palette.app.ui.dashboard.palette.pager.SaturationPalettePager

@Composable
fun ColorPaletteTab(navController: NavHostController, modifier: Modifier) {

    var selectedPagerIndex by remember { mutableIntStateOf(0) }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .verticalScroll(rememberScrollState())
    ) {
        val state = rememberPagerState { 4 }
        HorizontalPager(
            state = state,
            modifier = Modifier.fillMaxWidth()
                .padding(top = 25.dp),
            contentPadding = PaddingValues(horizontal = 0.dp),
            snapPosition = SnapPosition.Center
        ) { page ->
            when (page) {
                0 -> { PalettePager() }
                1 -> { AlphaPalettePager() }
                2 -> { LightnessPalettePager() }
                3 -> { SaturationPalettePager() }
            }
        }

        Row(
            Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
                .padding(top = 8.dp, start = 16.dp, end = 16.dp, bottom = 4.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(state.pageCount) { iteration ->
                selectedPagerIndex = state.currentPage
                val color = if (state.currentPage == iteration) Color.DarkGray else Color.LightGray
                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .clip(CircleShape)
                        .background(color)
                        .size(12.dp)
                )
            }
        }

        Button(
            modifier = Modifier
                .padding(top = 4.dp, start = 16.dp, end = 16.dp, bottom = 8.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            onClick = {

                navController.navigate("palette-gen-detail/$selectedPagerIndex")
            }
        ) {
            Text("Try it out!")
        }
    }
}

@Preview
@Composable
fun ColorPaletteTabPreview() {
    ColorPaletteTab(navController = rememberNavController(), modifier = Modifier)
}