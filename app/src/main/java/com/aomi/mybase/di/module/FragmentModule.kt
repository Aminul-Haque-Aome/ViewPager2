package com.aomi.mybase.di.module

import com.aomi.mybase.di.annotation.PerFragment
import com.aomi.mybase.ui.feature.splash.SplashFragment
import com.aomi.mybase.ui.feature.welcome.WelcomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @PerFragment
    @ContributesAndroidInjector
    abstract fun provideSplashFragment(): SplashFragment

    @PerFragment
    @ContributesAndroidInjector
    abstract fun provideWelcomeFragment(): WelcomeFragment

}