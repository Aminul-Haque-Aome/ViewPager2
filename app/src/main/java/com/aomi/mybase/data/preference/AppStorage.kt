package com.aomi.mybase.data.preference

interface AppStorage {
    var accessToken: String
    var refreshToken: String
    var userType: String
    var isVerified: Boolean

    fun deleteAccessToken()
    fun deleteRefreshToken()
    fun deleteUserType()
}