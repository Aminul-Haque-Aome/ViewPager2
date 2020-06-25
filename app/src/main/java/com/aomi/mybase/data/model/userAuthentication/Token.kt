package com.aomi.mybase.data.model.userAuthentication

import com.google.gson.annotations.SerializedName

data class Token(
    @SerializedName("created_at") val createdDate: String,
    @SerializedName("expired_at") val expiredDate: String,
    @SerializedName("token") val token: String
)