package com.aomi.mybase.data.restService

import com.aomi.mybase.data.model.userAuthentication.CredentialRenewalResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface UserAuthenticationRestService {

    @FormUrlEncoded
    @POST("signin/renew-tokens")
    fun renewCredential(
        @Field("refresh_token") refreshToken: String
    ): Call<CredentialRenewalResponse>

}