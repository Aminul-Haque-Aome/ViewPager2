package com.aomi.mybase.ui.feature.splash

import androidx.lifecycle.MutableLiveData
import com.aomi.mybase.core.platform.BaseViewModel
import com.aomi.mybase.extension.performOnBackgroundOutputOnMain
import com.aomi.mybase.extension.plusAssign
import com.aomi.mybase.util.Event
import io.reactivex.Observable
import java.util.concurrent.TimeUnit.SECONDS
import javax.inject.Inject

class SplashViewModel @Inject constructor(): BaseViewModel() {

    var isTimerEnd = MutableLiveData<Event<Boolean>>()

    fun startTimerForNavigatingToMainFragment() {
        compositeDisposable += Observable.timer(3L, SECONDS)
            .performOnBackgroundOutputOnMain()
            .subscribe {
                isTimerEnd.value = Event(true)
            }
    }

}
