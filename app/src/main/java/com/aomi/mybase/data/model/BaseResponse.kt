package com.aomi.mybase.data.model

import com.google.gson.annotations.SerializedName

open class BaseResponse(
    @SerializedName("status") val status: Int = 0,
    @SerializedName("message") val message: String? = null
)