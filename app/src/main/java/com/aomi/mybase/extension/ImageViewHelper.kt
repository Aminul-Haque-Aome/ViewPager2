package com.aomi.mybase.extension

import android.widget.ImageView
import androidx.annotation.DrawableRes
import coil.api.load
import coil.transform.CircleCropTransformation
import com.aomi.mybase.R

fun ImageView.load(@DrawableRes drawableRes: Int) {
    this.load(drawableRes)
}

fun ImageView.load(url: String?) {
    if (url == null) {
        this.load(R.drawable.ic_logo)
    } else {
        this.load(url) {
            crossfade(true)
            placeholder(R.drawable.ic_logo)
            transformations(CircleCropTransformation())
        }
    }
}