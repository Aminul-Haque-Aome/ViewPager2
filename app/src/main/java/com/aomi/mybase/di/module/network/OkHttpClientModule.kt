package com.aomi.mybase.di.module.network

import com.aomi.mybase.data.CredentialAuthenticator
import com.aomi.mybase.di.annotation.InterceptorType
import com.aomi.mybase.di.annotation.OkHttpClientType
import com.aomi.mybase.util.Network.BASIC
import com.aomi.mybase.util.Network.BEARER
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit.SECONDS
import javax.inject.Singleton

@Module(
    includes = [
        InterceptorModule::class
    ]
)
abstract class OkHttpClientModule {

    companion object {
        private const val TIME_OUT = 60L

        @Singleton
        @OkHttpClientType(BASIC)
        @Provides
        fun provideBasicOkHttpClient(loggingInterceptor: HttpLoggingInterceptor, @InterceptorType(BASIC) basicInterceptor: Interceptor): OkHttpClient {
            return OkHttpClient.Builder()
                .connectTimeout(TIME_OUT, SECONDS)
                .readTimeout(TIME_OUT, SECONDS)
                .writeTimeout(TIME_OUT, SECONDS)
                .addInterceptor(loggingInterceptor)
                .addInterceptor(basicInterceptor)
                .build()
        }

        @Singleton
        @OkHttpClientType(BEARER)
        @Provides
        fun provideBearerOkHttpClient(loggingInterceptor: HttpLoggingInterceptor, @InterceptorType(BEARER) authInterceptor: Interceptor, credentialAuthenticator: CredentialAuthenticator): OkHttpClient {
            return OkHttpClient.Builder()
                .connectTimeout(TIME_OUT, SECONDS)
                .readTimeout(TIME_OUT, SECONDS)
                .writeTimeout(TIME_OUT, SECONDS)
                .addInterceptor(loggingInterceptor)
                .addInterceptor(authInterceptor)
                .authenticator(credentialAuthenticator)
                .build()
        }

    }

}