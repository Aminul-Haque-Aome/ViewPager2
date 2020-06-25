package com.aomi.mybase.data.repository.testimonial

import com.aomi.mybase.data.model.testimonial.Testimonial
import com.aomi.mybase.data.restService.TestimonialRestService
import com.aomi.mybase.extension.toFlowable
import io.reactivex.Flowable
import javax.inject.Inject

class TestimonialRepositoryImpl @Inject constructor(
    private val testimonialRestService: TestimonialRestService
) : TestimonialRepository {

    override fun getTestimonials(): Flowable<ArrayList<Testimonial>> {
        return testimonialRestService.getTestimonialResponse()
            .toFlowable()
            .map { it.testimonialList }
    }

}