package com.aomi.mybase.data

import com.aomi.mybase.data.model.userAuthentication.NewCredential
import com.aomi.mybase.data.preference.AppStorage
import com.aomi.mybase.data.restService.UserAuthenticationRestService
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CredentialAuthenticator @Inject constructor(
    private val userAuthenticationRestService: UserAuthenticationRestService,
    private val appStorage: AppStorage
): Authenticator {

    override fun authenticate(route: Route?, response: Response): Request? {
        val request = response.request
        if (!request.header("Authorization").equals("Bearer ${appStorage.accessToken}"))
            return null

        var newAccessToken: String? = null

        userAuthenticationRestService.renewCredential(appStorage.refreshToken).execute().let {
            if (it.isSuccessful) {
                it.body()?.newCredential?.let { newCredential ->
                    newAccessToken = newCredential.accessToken.token
                    saveCredentialToPreference(newCredential)
                }
            }
        }

        return if (newAccessToken != null) {
            request.newBuilder()
                .header("Authorization", "Bearer $newAccessToken")
                .build()
        } else {
            null
        }
    }

    private fun saveCredentialToPreference(newCredential: NewCredential) {
        appStorage.accessToken = newCredential.accessToken.token
        appStorage.refreshToken = newCredential.refreshToken.token
    }

}