package com.aomi.mybase.di.module.network

import com.aomi.mybase.BuildConfig
import com.aomi.mybase.di.annotation.OkHttpClientType
import com.aomi.mybase.di.annotation.RetrofitType
import com.orhanobut.logger.Logger
import com.aomi.mybase.util.Network.BASIC
import com.aomi.mybase.util.Network.BEARER
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(
    includes = [
        OkHttpClientModule::class
    ]
)
abstract class RetrofitModule {

    companion object {
        private const val BASE_URL = BuildConfig.BASE_URL

        @Singleton
        @RetrofitType(BASIC)
        @Provides
        fun provideBasicRetrofit(@OkHttpClientType(BASIC) okHttpClient: OkHttpClient): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .callbackExecutor { Logger.d("returning") }
                .build()
        }

        @Singleton
        @RetrofitType(BEARER)
        @Provides
        fun provideBearerRetrofit(@OkHttpClientType(BEARER) okHttpClient: OkHttpClient): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .callbackExecutor { Logger.d("returning") }
                .build()
        }

    }
}