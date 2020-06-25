package com.aomi.mybase.di.module

import com.aomi.mybase.di.module.network.RestServiceModule
import com.aomi.mybase.di.module.preference.AppStorageModule
import com.aomi.mybase.di.module.preference.PreferenceServiceModule
import com.aomi.mybase.di.module.preference.SharedPreferencesModule
import com.aomi.mybase.di.module.persistence.DaoModule
import dagger.Module

@Module(
    includes = [
        ViewModelModule::class,
        RestServiceModule::class,
        RepositoryModule::class,
        SharedPreferencesModule::class,
        PreferenceServiceModule::class,
        AppStorageModule::class,
        DaoModule::class
    ]
)
abstract class AppModule