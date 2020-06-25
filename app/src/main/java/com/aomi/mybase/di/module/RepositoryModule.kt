package com.aomi.mybase.di.module

import com.aomi.mybase.data.repository.testimonial.TestimonialRepository
import com.aomi.mybase.data.repository.testimonial.TestimonialRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {

    @Binds
    abstract fun provideTestimonialRepository(repo: TestimonialRepositoryImpl): TestimonialRepository

}