package com.aomi.mybase.di.module.preference

import com.aomi.mybase.data.preference.AppStorage
import com.aomi.mybase.data.preference.AppStorageImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class AppStorageModule {

    @Singleton
    @Binds
    abstract fun provideAppStorage(storage: AppStorageImpl): AppStorage

}