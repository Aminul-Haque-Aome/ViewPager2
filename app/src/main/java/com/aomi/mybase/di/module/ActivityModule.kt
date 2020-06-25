package com.aomi.mybase.di.module

import com.aomi.mybase.di.annotation.PerActivity
import com.aomi.mybase.ui.activity.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
    @PerActivity
    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity
}