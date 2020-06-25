package com.aomi.mybase.extension

import android.app.Activity
import android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN

fun Activity.setFullscreen() {
    this.window.addFlags(FLAG_FULLSCREEN)
}

fun Activity.exitFullscreen() {
    this.window.clearFlags(FLAG_FULLSCREEN)
}