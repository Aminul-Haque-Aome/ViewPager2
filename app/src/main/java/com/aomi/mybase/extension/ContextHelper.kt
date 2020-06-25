package com.aomi.mybase.extension

import android.content.Context
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import kotlin.math.roundToInt

fun Context.getColorFrom(@ColorRes color: Int) = ContextCompat.getColor(this, color)
fun Context.getColorState(@ColorRes color: Int) = ContextCompat.getColorStateList(this, color)
fun Context.getDrawableFrom(@DrawableRes drawable: Int) = ContextCompat.getDrawable(this, drawable)

fun Context.dpToPx(dp: Int) = ((resources.displayMetrics.density) * dp).roundToInt()