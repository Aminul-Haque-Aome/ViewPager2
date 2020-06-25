package com.aomi.mybase.di.component

import android.content.Context
import com.aomi.mybase.core.platform.BaseApplication
import com.aomi.mybase.di.module.ActivityModule
import com.aomi.mybase.di.module.AppModule
import com.aomi.mybase.di.module.FragmentModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        ActivityModule::class,
        FragmentModule::class
    ]
)
interface AppComponent : AndroidInjector<BaseApplication> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): AppComponent
    }

}