package com.aomi.mybase.data.repository.testimonial

import com.aomi.mybase.data.model.testimonial.Testimonial
import io.reactivex.Flowable

interface TestimonialRepository {
    fun getTestimonials(): Flowable<ArrayList<Testimonial>>
}