package com.aomi.mybase.data.model.userAuthentication

import com.aomi.mybase.data.model.BaseResponse
import com.google.gson.annotations.SerializedName

data class CredentialRenewalResponse(
    @SerializedName("data") val newCredential: NewCredential
): BaseResponse()