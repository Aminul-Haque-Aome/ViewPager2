package com.aomi.mybase.data.model.testimonial

import com.aomi.mybase.data.model.BaseResponse
import com.google.gson.annotations.SerializedName

data class TestimonialResponse(
    @SerializedName("data") val testimonialList : ArrayList<Testimonial>
) : BaseResponse()