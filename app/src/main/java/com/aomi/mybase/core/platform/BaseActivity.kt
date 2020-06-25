package com.aomi.mybase.core.platform

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerAppCompatActivity
import java.lang.reflect.ParameterizedType
import javax.inject.Inject

abstract class BaseActivity<M : BaseViewModel> : DaggerAppCompatActivity() {

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var viewModel: M

    @LayoutRes abstract fun getLayoutResource(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResource())

        viewModel = ViewModelProvider(this, viewModelFactory).get(getViewModelClass())
    }

    private fun getViewModelClass(): Class<M> {
        val type = (javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0]
        @Suppress("UNCHECKED_CAST")
        return type as Class<M>
    }
}