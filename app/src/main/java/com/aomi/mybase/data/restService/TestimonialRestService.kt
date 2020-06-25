package com.aomi.mybase.data.restService

import com.aomi.mybase.data.model.testimonial.TestimonialResponse
import io.reactivex.Flowable
import retrofit2.Response
import retrofit2.http.GET

interface TestimonialRestService {

    @GET("testimonial")
    fun getTestimonialResponse(): Flowable<Response<TestimonialResponse>>

}