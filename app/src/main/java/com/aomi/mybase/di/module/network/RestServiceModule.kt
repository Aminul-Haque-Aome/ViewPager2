package com.aomi.mybase.di.module.network

import com.aomi.mybase.data.restService.TestimonialRestService
import com.aomi.mybase.data.restService.UserAuthenticationRestService
import com.aomi.mybase.di.annotation.RetrofitType
import com.aomi.mybase.util.Network.BASIC
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(
    includes = [
        RetrofitModule::class
    ]
)
abstract class RestServiceModule {

    companion object {

        @Singleton
        @Provides
        fun provideTestimonialService(@RetrofitType(BASIC) retrofit: Retrofit): TestimonialRestService {
            return retrofit.create(TestimonialRestService::class.java)
        }

        @Singleton
        @Provides
        fun provideUserAuthenticationService(@RetrofitType(BASIC) retrofit: Retrofit): UserAuthenticationRestService {
            return retrofit.create(UserAuthenticationRestService::class.java)
        }

    }
}