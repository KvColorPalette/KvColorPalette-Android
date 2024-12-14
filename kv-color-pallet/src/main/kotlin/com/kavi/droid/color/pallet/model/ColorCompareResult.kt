package com.kavi.droid.color.pallet.model

data class ColorCompareResult(
    var isExactMatch: Boolean = false,
    var colorDistance: Float = 0f,
    var matchedColor: KvColor
)