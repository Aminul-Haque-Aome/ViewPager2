package com.aomi.mybase.di.module.preference

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.aomi.mybase.R
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class SharedPreferencesModule {

    companion object {

        @Singleton
        @Provides
        fun provideSharedPreferences(context: Context): SharedPreferences {
            return context.getSharedPreferences(context.getString(R.string.pref_name), MODE_PRIVATE)
        }

    }
}