package com.kavi.droid.color.pallet.app.ui.tab.pallet

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kavi.droid.color.pallet.app.ui.tab.pallet.pager.AlphaPalletPager
import com.kavi.droid.color.pallet.app.ui.tab.pallet.pager.LightnessPalletPager
import com.kavi.droid.color.pallet.app.ui.tab.pallet.pager.PalletPager
import com.kavi.droid.color.pallet.app.ui.tab.pallet.pager.SaturationPalletPager

@Composable
fun ColorPalletTab(modifier: Modifier) {
    Column(modifier = modifier) {
        val state = rememberPagerState { 4 }
        HorizontalPager(
            state = state,
            modifier = Modifier.fillMaxWidth()
                .padding(top = 25.dp),
            contentPadding = PaddingValues(horizontal = 0.dp),
            snapPosition = SnapPosition.Center
        ) { page ->
            when (page) {
                0 -> { PalletPager() }
                1 -> { AlphaPalletPager() }
                2 -> { LightnessPalletPager() }
                3 -> { SaturationPalletPager() }
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
            onClick = {
            }
        ) {
            Text("Try it out!")
        }
    }
}

@Preview
@Composable
fun ColorPalletTabPreview() {
    ColorPalletTab(modifier = Modifier)
}