package com.kavi.droid.color.pallet.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kavi.droid.color.pallet.ui.tab.ColorPalletTab
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
    val tabs = listOf("Color Pallet", "Theme Gen", "Settings")
    var selectedTabIndex by remember { mutableStateOf(0) }

    Scaffold(
        bottomBar = {
            BottomNavigation(
                modifier = Modifier.height(64.dp)
            ) {
                tabs.forEachIndexed { index, title ->
                    BottomNavigationItem(
                        modifier = Modifier
                            .height(64.dp)
                            .background(color = MaterialTheme.colorScheme.primary),
                        selected = selectedTabIndex == index,
                        onClick = { selectedTabIndex = index },
                        label = { Text(title) },
                        icon = { /* Optional: Add an Icon here if needed */ }
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
        2 -> SettingsTab()
    }
}

@Composable
fun SettingsTab() {
    Surface(modifier = Modifier.padding(16.dp)) {
        Column {
            Text(text = "Settings tab content goes here!", color = Color.Gray)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KvColorPalletTheme {
        TabViewExample()
    }
}