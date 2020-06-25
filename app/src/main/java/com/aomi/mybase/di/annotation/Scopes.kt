package com.aomi.mybase.di.annotation

import javax.inject.Scope
import kotlin.annotation.AnnotationRetention.RUNTIME

@Scope
@Retention(RUNTIME)
annotation class PerActivity

@Scope
@Retention(RUNTIME)
annotation class PerFragment