package com.aomi.mybase.extension

import android.widget.EditText
import android.widget.TextView
import androidx.annotation.DrawableRes

fun TextView.getValue() = text.toString()

fun EditText.getValue() = text.toString()

fun EditText.clear() { setText("") }

fun TextView.setDrawableLeft(@DrawableRes drawableImage: Int) {
    this.setCompoundDrawablesWithIntrinsicBounds(drawableImage, 0, 0, 0)
}

fun TextView.setDrawableRight(@DrawableRes drawableImage: Int) {
    this.setCompoundDrawablesWithIntrinsicBounds(0, 0, drawableImage, 0)
}