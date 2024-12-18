package com.kavi.droid.color.pallet

import android.app.Application
import com.kavi.droid.color.pallet.color.MatPackage

class KvColorPalletApp: Application() {

    override fun onCreate() {
        super.onCreate()
        // Initialize the kv color pallet
        KvColorPallet.init(MatPackage.MatDGreen.color)
    }
}