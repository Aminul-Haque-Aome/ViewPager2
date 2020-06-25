package com.aomi.mybase.di.module.persistence

import com.aomi.mybase.data.room.AppDatabase
import com.aomi.mybase.data.room.UserDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(
    includes = [
        AppDatabaseModule::class
    ]
)
abstract class DaoModule {

    companion object {

        @Singleton
        @Provides
        fun provideUserDao(appDatabase: AppDatabase): UserDao {
            return appDatabase.getUserDao()
        }

    }
}