package com.aomi.mybase.di.module.persistence

import android.content.Context
import androidx.room.Room
import com.aomi.mybase.R
import com.aomi.mybase.data.room.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class AppDatabaseModule {

    companion object {

        @Singleton
        @Provides
        fun provideAppDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                context.getString(R.string.app_database_name)
            ).fallbackToDestructiveMigrationFrom().build()
        }

    }
}