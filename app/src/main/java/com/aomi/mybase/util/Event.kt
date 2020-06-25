package com.aomi.mybase.util

open class Event<out T>(private val content: T) {

    /**
     * Allow external read
     * but not write
     */
    var hasBeenHandled = false
        private set

    /**
     * Returns the content
     * and prevents its use again.
     */
    fun getEventIfNotHandled(): T? {
        return if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            content
        }
    }

}