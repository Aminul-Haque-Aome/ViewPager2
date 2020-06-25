package com.aomi.mybase.ui.feature.welcome

import androidx.recyclerview.widget.RecyclerView.OVER_SCROLL_NEVER
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import com.aomi.mybase.R
import com.aomi.mybase.core.platform.BaseFragment
import com.aomi.mybase.extension.*
import com.aomi.mybase.ui.feature.welcome.adapter.TestimonialAdapter
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers.mainThread
import kotlinx.android.synthetic.main.fragment_welcome.*
import java.util.concurrent.TimeUnit.MILLISECONDS
import kotlin.math.abs

class WelcomeFragment : BaseFragment<WelcomeViewModel>() {

    private val testimonialAdapter: TestimonialAdapter by lazy {
        TestimonialAdapter { }
    }

    override fun getLayoutResource() = R.layout.fragment_welcome

    override fun initWidget() {
        val compositePagerTransformer = CompositePageTransformer()
        with(compositePagerTransformer) {
            addTransformer(MarginPageTransformer(15))
            addTransformer { page, position ->
                val r = 1 - abs(position)
                page.scaleY = ((0.85f + r * 0.15).toFloat())
            }
        }

        with(testimonial_view_pager) {
            clipToPadding = false
            clipChildren = false
            offscreenPageLimit = 3
            getChildAt(0).overScrollMode = OVER_SCROLL_NEVER

            adapter = testimonialAdapter
            setPageTransformer(compositePagerTransformer)
        }

    }

//    override fun onStart() {
//        super.onStart()
//        viewModel.getTestimonials()
//    }

    override fun onStart() {
        super.onStart()

        testimonialAdapter.submitList(viewModel.testimonialList)
        startAutoSliding()
    }

//    override fun observeLiveData() {
//        this.observeEvent(viewModel.loader) {
//            if (it) Log.d("loader", "before")
//            else Log.d("loader", "after")
//        }
//
//        this.observe(viewModel.testimonials) {
//            testimonialAdapter.submitList(it)
//            startAutoSliding()
//        }
//
//        this.observeEvent(viewModel.toastMessage) {
//            welcome_view_holder.showSnackBar(it)
//        }
//    }

    private fun startAutoSliding() {
        compositeDisposable += Observable.interval(5000, MILLISECONDS)
            .observeOn(mainThread())
            .subscribe {
                if (testimonial_view_pager.currentItem < testimonialAdapter.itemCount - 1) {
                    testimonial_view_pager.currentItem = testimonial_view_pager.currentItem + 1
                } else {
                    testimonial_view_pager.currentItem = 0
                }
            }
    }

}