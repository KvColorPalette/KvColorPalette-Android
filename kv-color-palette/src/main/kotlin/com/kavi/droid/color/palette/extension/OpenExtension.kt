package com.kavi.droid.color.palette.extension

import androidx.compose.ui.graphics.Color

/**
 * Extension property to check if a [Color] is a high-light color.
 */
val Color.isHighLightColor: Boolean
    get() = this.hsl.lightness > 0.6f