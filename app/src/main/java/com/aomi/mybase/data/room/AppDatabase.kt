package com.aomi.mybase.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.aomi.mybase.data.model.entity.User

@Database(
    version = 1,
    exportSchema = false,
    entities = [
        User::class
    ]
)
abstract class AppDatabase: RoomDatabase() {

    abstract fun getUserDao(): UserDao

}