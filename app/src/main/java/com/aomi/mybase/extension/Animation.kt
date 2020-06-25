package com.aomi.mybase.extension

import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.animation.OvershootInterpolator
import io.reactivex.Completable

fun View.slideIn(offset: Float): Completable {
    return Completable.create {
        visibility = VISIBLE
        alpha = 0f
        scaleX = 0f
        scaleY = 0f
        translationY = offset
        animate().alpha(1f)
            .translationY(0f)
            .scaleX(1f)
            .scaleY(1f)
            .setDuration(200)
            .setInterpolator(OvershootInterpolator())
            .withEndAction(it::onComplete)
    }
}

fun View.slideOut(offset: Float): Completable {
    return Completable.create {
        animate().alpha(0f)
            .scaleX(0f)
            .scaleY(0f)
            .translationY(offset)
            .setDuration(200)
            .withEndAction {
                visibility = GONE
                it.onComplete()
            }
    }
}

fun View.fadeIn(duration: Long = 300): Completable {
    return Completable.create {
        visibility = VISIBLE
        alpha = 0f
        animate().alpha(1f)
            .setDuration(duration)
            .withEndAction(it::onComplete)
    }
}

fun View.fadeOut(duration: Long = 300): Completable {
    return Completable.create {
        animate().setDuration(duration)
            .alpha(0f)
            .withEndAction {
                visibility = GONE
                it.onComplete()
            }
    }
}

fun View.rotate(degree: Float): Completable {
    return Completable.create {
        animate().rotation(degree)
            .setDuration(2000)
            .withEndAction(it::onComplete)
    }
}

//    myView.fadeOut().subscribe()
//    longFab.slideIn(fabMiniSize).andThen(longLabel.fadeIn())