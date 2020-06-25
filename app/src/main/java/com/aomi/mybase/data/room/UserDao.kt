package com.aomi.mybase.data.room

import androidx.room.*
import com.aomi.mybase.data.model.entity.User
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface UserDao {

    @Insert
    fun insertUser(user: User): Completable

    @Update
    fun updateUser(user: User): Completable

    @Delete
    fun deleteUser(user: User): Completable

    @Query("SELECT * FROM user")
    fun getUser(): Single<User>

}