package com.aomi.mybase.di.module.preference

import com.aomi.mybase.data.preference.PreferencesService
import com.aomi.mybase.data.preference.PreferencesServiceImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class PreferenceServiceModule {

    @Singleton
    @Binds
    abstract fun providePreferenceService(pref: PreferencesServiceImpl): PreferencesService

}