package com.aomi.mybase.core.platform

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.aomi.mybase.R
import com.aomi.mybase.extension.inflate
import dagger.android.support.DaggerFragment
import io.reactivex.disposables.CompositeDisposable
import java.lang.reflect.ParameterizedType
import javax.inject.Inject

abstract class BaseFragment<VM: BaseViewModel> : DaggerFragment() {
    val compositeDisposable = CompositeDisposable()

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var viewModel: VM

    open var activityContext: Activity? = null
    open var isActivityAsLifecycleOwner: Boolean = false

    @LayoutRes
    abstract fun getLayoutResource(): Int

    open fun initWidget() {}
    open fun observeLiveData() {}

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        activityContext = activity
        return container?.inflate(getLayoutResource())
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = (if (isActivityAsLifecycleOwner) {
            activity?.let { ViewModelProvider(it, viewModelFactory).get(getViewModelClass()) }
        } else {
            ViewModelProvider(this, viewModelFactory).get(getViewModelClass())
        }) as VM

        initWidget()
        observeLiveData()
    }

    private fun getViewModelClass(): Class<VM> {
        val type = (javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0]
        @Suppress("UNCHECKED_CAST")
        return type as Class<VM>
    }

    override fun onPause() {
        super.onPause()
        compositeDisposable.clear()
    }

    override fun onDestroy() {
        if (!compositeDisposable.isDisposed) compositeDisposable.dispose()
        super.onDestroy()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        activityContext = null
    }

    protected fun navigate(destinationFragmentId: Int, bundle: Bundle? = null) {
        findNavController().navigate(destinationFragmentId, bundle)
    }

    protected fun navigateTo(destinationFragmentId: Int, bundle: Bundle? = null) {
        val navOptions = NavOptions.Builder()
            .setEnterAnim(R.anim.slide_in_right)
            .setExitAnim(R.anim.slide_out_left)
            .setPopEnterAnim(R.anim.slide_in_left)
            .setPopExitAnim(R.anim.slide_out_right)
            .build()
        findNavController().navigate(destinationFragmentId, bundle, navOptions)
    }

    protected fun navigateBack() {
        findNavController().navigateUp()
    }

    protected fun navigateBackTo(destinationFragmentId: Int, inclusive: Boolean = false) {
        findNavController().popBackStack(destinationFragmentId, inclusive)
    }
}