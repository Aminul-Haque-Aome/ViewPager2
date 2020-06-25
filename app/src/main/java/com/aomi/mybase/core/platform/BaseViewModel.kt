package com.aomi.mybase.core.platform

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aomi.mybase.util.Event
import io.reactivex.disposables.CompositeDisposable
import java.io.IOException

open class BaseViewModel : ViewModel() {

    val compositeDisposable = CompositeDisposable()

    val loader = MutableLiveData<Event<Boolean>>()
    val toastMessage = MutableLiveData<Event<String>>()

    fun handleException(throwable: Throwable) {
        when(throwable) {
            is IOException -> toastMessage.value = Event("Can't communicate with server")
            else -> toastMessage.value = Event("JSON parsing error")
        }
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}