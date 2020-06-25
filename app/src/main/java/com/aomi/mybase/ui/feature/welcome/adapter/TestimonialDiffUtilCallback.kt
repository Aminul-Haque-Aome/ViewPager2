package com.aomi.mybase.ui.feature.welcome.adapter

import com.aomi.mybase.core.platform.BaseDiffUtilCallback
import com.aomi.mybase.data.model.testimonial.Testimonial

class TestimonialDiffUtilCallback : BaseDiffUtilCallback<Testimonial>() {

    override fun areItemsTheSame(oldItem: Testimonial, newItem: Testimonial): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Testimonial, newItem: Testimonial): Boolean {
        return oldItem == newItem
    }
}