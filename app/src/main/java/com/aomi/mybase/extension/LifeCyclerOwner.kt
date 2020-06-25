package com.aomi.mybase.extension

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.aomi.mybase.util.Event

inline fun <T> LifecycleOwner.observe(liveData: LiveData<T>, crossinline action: (T) -> Unit) {
    liveData.observe(this, Observer { it?.let(action) })
}

inline fun <T> LifecycleOwner.observe(liveData: MutableLiveData<T>, crossinline action: (T) -> Unit) {
    liveData.observe(this, Observer { it?.let(action) })
}

inline fun <T> LifecycleOwner.observeEvent(liveData: LiveData<Event<T>>, crossinline action: (T) -> Unit) {
    liveData.observe(this, Observer { it?.getEventIfNotHandled()?.let(action) })
}