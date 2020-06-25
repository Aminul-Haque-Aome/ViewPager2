package com.aomi.mybase.di.annotation

import javax.inject.Qualifier
import kotlin.annotation.AnnotationRetention.RUNTIME

@Qualifier
@MustBeDocumented
@Retention(RUNTIME)
annotation class InterceptorType(val type: String = "")

@Qualifier
@MustBeDocumented
@Retention(RUNTIME)
annotation class OkHttpClientType(val type: String = "")

@Qualifier
@MustBeDocumented
@Retention(RUNTIME)
annotation class RetrofitType(val type: String = "")