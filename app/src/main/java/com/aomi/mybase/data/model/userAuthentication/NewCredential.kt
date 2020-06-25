package com.aomi.mybase.data.model.userAuthentication

import com.google.gson.annotations.SerializedName

data class NewCredential(
    @SerializedName("refresh_token") val refreshToken: Token,
    @SerializedName("access_token") val accessToken: Token,
    @SerializedName("otp_verified") val isOtpVerified: Boolean
)