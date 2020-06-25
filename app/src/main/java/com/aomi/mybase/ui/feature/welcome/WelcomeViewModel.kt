package com.aomi.mybase.ui.feature.welcome

import androidx.lifecycle.MutableLiveData
import com.aomi.mybase.R
import com.aomi.mybase.core.platform.BaseViewModel
import com.aomi.mybase.data.repository.testimonial.TestimonialRepository
import com.aomi.mybase.data.model.testimonial.Testimonial
import com.aomi.mybase.data.restService.TestimonialRestService
import com.aomi.mybase.extension.performOnBackgroundOutputOnMain
import com.aomi.mybase.extension.plusAssign
import com.aomi.mybase.extension.toFlowable
import com.aomi.mybase.util.Event
import com.orhanobut.logger.Logger
import javax.inject.Inject

class WelcomeViewModel @Inject constructor(
    private val testimonialRestService: TestimonialRestService
) : BaseViewModel() {

    var testimonials = MutableLiveData<ArrayList<Testimonial>>()

    fun getTestimonials() {
        if(testimonials.value == null) {
            compositeDisposable += testimonialRestService.getTestimonialResponse().toFlowable()
                .map { it.testimonialList }
                .performOnBackgroundOutputOnMain()
                .doOnSubscribe { loader.value = Event(true) }
                .doAfterTerminate { loader.value = Event(false) }
                .subscribe({
//                    Logger.d(it)
                    testimonials.value = it
                }, {
                    handleException(it)
                })
        }
    }

    val testimonialList = arrayListOf(
        Testimonial(1, "Hasibur Rahman", R.drawable.ic_logo, "Caretutors.com has been a prolific provider of tuition for us tutors. It not just only matches you with the right students but also lays out a secured structure for both the students and the tutors. I personally recommend everyone to use Caretutors.com as a medium of searching tuitions and other services they come up with.", "Bangladesh University of Professionals","Tutor"),
        Testimonial(2, "Nilhan Sarwar", R.drawable.ic_logo,"I got my first tuition through Caretutors.com. They sent me to the student's home for two days of trial class. As I entered there I was very nervous but all my nervousness was gone as soon as I started teaching. And I gave my 100%. But there were also some ups and downs where I thought that I can't teach anymore as my student was a little bit arrogant. But I had patience and tried to handle and teach calmly. As a tutor, one must have patience and confidence. It is very important for teaching. Caretutors.com has always been very helpful and supportive. They always try to give tips regarding enhancing teaching techniques and its a very helpful platform for those students who are in need of tuitions. Thank you.", "American International University- Banngladesh (AIUB)","Tutor"),
        Testimonial(3, "Marsia Tabassum Rimsha", R.drawable.ic_logo,"I got a call for my first tuition job within a month of my joining. As an online platform, Caretutors.com can surely be trusted for its policies and method of authentication. People associated with this platform are well cooperative. So, anyone who’s out there looking for a tuition can surely check out their website.", "Bangladesh University of Professionals (BUP)","Tutor"),
        Testimonial(4, "Zakaria Habib", R.drawable.ic_logo,"I found this platform very safe & secure. I already got two tutors by using this platform and feeling like they are being part of our family. Best wishes for the Caretutors.com family.", "Anderkilla, Chattogram","Tutor"),
        Testimonial(9, "Hasibur Rahman", R.drawable.ic_logo, "Caretutors.com has been a prolific provider of tuition for us tutors. It not just only matches you with the right students but also lays out a secured structure for both the students and the tutors. I personally recommend everyone to use Caretutors.com as a medium of searching tuitions and other services they come up with.", "Bangladesh University of Professionals","Tutor")
    )

}