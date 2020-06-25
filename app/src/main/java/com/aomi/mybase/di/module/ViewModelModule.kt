package com.aomi.mybase.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aomi.mybase.di.annotation.ViewModelKey
import com.aomi.mybase.ui.activity.MainViewModel
import com.aomi.mybase.ui.feature.splash.SplashViewModel
import com.aomi.mybase.ui.feature.welcome.WelcomeViewModel
import com.aomi.mybase.util.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun provideMainViewModel(viewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    abstract fun provideSplashViewModel(viewModel: SplashViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(WelcomeViewModel::class)
    abstract fun provideWelcomeViewModel(viewModel: WelcomeViewModel): ViewModel

}