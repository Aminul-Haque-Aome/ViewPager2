package com.aomi.mybase.data.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "user"
)
data class User (
    @PrimaryKey @ColumnInfo(name = "user_id") val id: Int,
    @ColumnInfo(name = "user_name") val name: String,
    @ColumnInfo(name = "user_email") val email: String,
    @ColumnInfo(name = "user_verification_status") val isVerified: Boolean = false
)