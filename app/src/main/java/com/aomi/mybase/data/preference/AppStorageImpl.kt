package com.aomi.mybase.data.preference

import javax.inject.Inject

class AppStorageImpl @Inject constructor(
    private val preferencesService: PreferencesService
) : AppStorage {

    private companion object {
        const val ACCESS_TOKEN = "access_token"
        const val REFRESH_TOKEN = "refresh_token"
        const val USER_TYPE = "user_type"
        const val IS_VERIFIED = "is_verified"
    }

    override var accessToken: String
        get() = preferencesService.getString(ACCESS_TOKEN)
        set(value) { preferencesService.saveString(ACCESS_TOKEN, value) }

    override fun deleteAccessToken() {
        preferencesService.deleteValue(ACCESS_TOKEN)
    }

    override var refreshToken: String
        get() = preferencesService.getString(REFRESH_TOKEN)
        set(value) { preferencesService.saveString(REFRESH_TOKEN, value) }

    override fun deleteRefreshToken() {
        preferencesService.deleteValue(REFRESH_TOKEN)
    }

    override var userType: String
        get() = preferencesService.getString(USER_TYPE)
        set(value) { preferencesService.saveString(USER_TYPE, value) }

    override fun deleteUserType() {
        preferencesService.deleteValue(USER_TYPE)
    }

    override var isVerified: Boolean
        get() = preferencesService.getBoolean(IS_VERIFIED)
        set(value) { preferencesService.saveBoolean(IS_VERIFIED, value) }
}