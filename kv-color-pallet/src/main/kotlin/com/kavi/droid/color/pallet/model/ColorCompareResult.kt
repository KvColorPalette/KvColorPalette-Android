package com.kavi.droid.color.pallet.model

/**
 * Result of the color comparison functionality in kv-color-pallet library.
 */
data class ColorCompareResult(
    var isExactMatch: Boolean = false,
    var colorDistance: Float = 0f,
    var matchedColor: KvColor
)