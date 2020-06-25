package com.aomi.mybase.ui.feature.splash

import com.aomi.mybase.R
import com.aomi.mybase.R.id.splash_to_welcome
import com.aomi.mybase.core.platform.BaseFragment
import com.aomi.mybase.extension.*
import io.reactivex.android.schedulers.AndroidSchedulers.mainThread
import kotlinx.android.synthetic.main.fragment_splash.*

class SplashFragment : BaseFragment<SplashViewModel>() {

    override fun getLayoutResource() = R.layout.fragment_splash

    override fun initWidget() {
        activity?.setFullscreen()

        compositeDisposable += logo_image_view.fadeOut(3000)
            .observeOn(mainThread())
            .subscribe()
    }

    override fun onStart() {
        super.onStart()
        viewModel.startTimerForNavigatingToMainFragment()
    }

    override fun observeLiveData() {
        this.observeEvent(viewModel.isTimerEnd) {
            navigate(splash_to_welcome)
        }
    }

    override fun onPause() {
        super.onPause()
        activity?.exitFullscreen()
    }

}