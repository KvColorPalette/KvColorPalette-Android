package com.kavi.droid.color.palette.model

/**
 * Result of the color comparison functionality in kv-color-pallet library.
 */
data class ColorCompareResult(
    var isExactMatch: Boolean = false,
    var colorDistance: Float = 0f,
    var matchedColor: KvColor
)