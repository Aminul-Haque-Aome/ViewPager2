package com.aomi.mybase.ui.feature.welcome.adapter

import android.view.ViewGroup
import com.aomi.mybase.R
import com.aomi.mybase.core.platform.BaseAdapter
import com.aomi.mybase.data.model.testimonial.Testimonial
import com.aomi.mybase.extension.inflate

class TestimonialAdapter(
    onClick: (Testimonial) -> Unit
) : BaseAdapter<Testimonial>(onClick, TestimonialDiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestimonialViewHolder {
        return TestimonialViewHolder(parent.inflate(R.layout.item_testimonial))
    }

}



