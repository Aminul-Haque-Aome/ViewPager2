package com.aomi.mybase.ui.feature.welcome.adapter

import android.view.View
import com.aomi.mybase.core.platform.BaseViewHolder
import com.aomi.mybase.data.model.testimonial.Testimonial
import com.aomi.mybase.extension.load
import kotlinx.android.synthetic.main.item_testimonial.view.*

class TestimonialViewHolder(private val view: View) : BaseViewHolder<Testimonial>(view) {

    override fun bind(item: Testimonial, onClick: (Testimonial) -> Unit) {
        with(view) {
            client_image_view.load(item.photo)
            name_text_view.text = item.name
            designation_text_view.text = item.designation
            comment_text_view.text = item.comment
        }
    }

}