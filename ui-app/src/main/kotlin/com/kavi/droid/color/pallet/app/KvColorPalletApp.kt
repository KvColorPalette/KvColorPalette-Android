package com.kavi.droid.color.pallet.app

import android.app.Application
import com.kavi.droid.color.pallet.KvColorPallet
import com.kavi.droid.color.pallet.color.MatPackage

class KvColorPalletApp: Application() {

    override fun onCreate() {
        super.onCreate()
        // Initialize the kv color pallet
        KvColorPallet.initialize(MatPackage.MatDGreen)
    }
}