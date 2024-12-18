package com.kavi.droid.color.pallet.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kavi.droid.color.pallet.R
import com.kavi.droid.color.pallet.model.TabItem
import com.kavi.droid.color.pallet.ui.tab.pallet.ColorPalletTab
import com.kavi.droid.color.pallet.ui.tab.ThemeColorGen
import com.kavi.droid.color.pallet.theme.KvColorPalletTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KvColorPalletTheme {
                TabViewExample()
            }
        }
    }
}

@Composable
fun TabViewExample() {
    val tabs = listOf("Color Pallet", "Theme Gen")
    val tabItems = listOf(
        TabItem(
            name = "Color Pallet",
            icon = R.drawable.icon_color_grid
        ),
        TabItem(name = "Theme Gen", icon = R.drawable.icon_theme_set)
    )
    var selectedTabIndex by remember { mutableStateOf(0) }

    Scaffold(
        bottomBar = {
            BottomNavigation(
                modifier = Modifier.height(100.dp)
            ) {
                tabItems.forEachIndexed { index, tabItem ->
                    BottomNavigationItem(
                        modifier = Modifier
                            .height(100.dp)
                            .background(color = MaterialTheme.colorScheme.primary),
                        selected = selectedTabIndex == index,
                        onClick = { selectedTabIndex = index },
                        label = { Text(tabItem.name) },
                        icon = {
                            Icon(painterResource(id = tabItem.icon), contentDescription = "")
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        // Content displayed above the bottom bar
        TabContent(
            selectedTabIndex = selectedTabIndex,
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        )
    }
}

@Composable
fun TabContent(selectedTabIndex: Int, modifier: Modifier = Modifier) {
    when (selectedTabIndex) {
        0 -> ColorPalletTab()
        1 -> ThemeColorGen()
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KvColorPalletTheme {
        TabViewExample()
    }
}