package com.aomi.mybase.di.module.network

import com.aomi.mybase.BuildConfig
import com.aomi.mybase.data.preference.AppStorage
import com.aomi.mybase.di.annotation.InterceptorType
import com.aomi.mybase.util.Network.BASIC
import com.aomi.mybase.util.Network.BEARER
import dagger.Module
import dagger.Provides
import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level.BODY
import okhttp3.logging.HttpLoggingInterceptor.Level.NONE
import javax.inject.Singleton

@Module
class InterceptorModule {

    companion object {

        @Singleton
        @Provides
        fun provideLoggingInterceptor(): HttpLoggingInterceptor {
            return HttpLoggingInterceptor().apply {
                level = if (BuildConfig.DEBUG) BODY else NONE
            }
        }

        @Singleton
        @InterceptorType(BASIC)
        @Provides
        fun provideBasicInterceptor(): Interceptor {
            val basicAuthCredential = Credentials.basic(
                "ct_android",
                "\$2y\$12\$ej.DK5rJIZjF9FokTWErDeDylA7N.4apw0FZ2FllcK53KEYZqDryO"
            )

            try {
                return Interceptor {
                    val request = it.request()

                    it.proceed(
                        request.newBuilder()
                            .header("Accept", "application/json")
                            .header("Content-Type", "application/json")
                            .header("Authorization", basicAuthCredential)
                            .build()
                    )
                }
            } catch (exception: Exception) {
                throw Exception(exception.message)
            }
        }

        @Singleton
        @InterceptorType(BEARER)
        @Provides
        fun provideAuthInterceptor(appStorage: AppStorage): Interceptor {
            var accessToken = appStorage.accessToken

            try {
                return Interceptor {
                    val request = it.request()

                    it.proceed(
                        request.newBuilder()
                            .header("Accept", "application/json")
                            .header("Content-Type", "application/json")
                            .header("Authorization", "Bearer $accessToken")
                            .build()
                    )
                }
            } catch (exception: Exception) {
                throw Exception(exception.message)
            }
        }

    }
}