package com.aomi.mybase.di.annotation

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.annotation.AnnotationTarget.*
import kotlin.reflect.KClass

@Target(
    FUNCTION,
    PROPERTY_GETTER,
    PROPERTY_SETTER
)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)