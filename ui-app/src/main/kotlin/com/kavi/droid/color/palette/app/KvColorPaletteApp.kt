package com.kavi.droid.color.palette.app

import android.app.Application
import com.kavi.droid.color.palette.KvColorPalette
import com.kavi.droid.color.palette.color.MatPackage

class KvColorPaletteApp: Application() {

    override fun onCreate() {
        super.onCreate()
        // Initialize the kv color palette
        KvColorPalette.initialize(MatPackage.MatDGreen.color)
    }
}