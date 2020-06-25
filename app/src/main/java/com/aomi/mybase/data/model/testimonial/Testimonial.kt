package com.aomi.mybase.data.model.testimonial

import com.google.gson.annotations.SerializedName

data class Testimonial(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("photo") val photo: Int,
    @SerializedName("comment") val comment: String,
    @SerializedName("designation") val designation: String,
    @SerializedName("type") val type: String
)