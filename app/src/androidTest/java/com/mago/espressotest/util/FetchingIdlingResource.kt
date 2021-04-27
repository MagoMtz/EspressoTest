package com.mago.espressotest.util

import androidx.test.espresso.IdlingResource

/**
 * @author by jmartinez
 * @since 15/02/2021.
 */
class FetchingIdlingResource: IdlingResource {
    private var idle = true
    private var resourceCallback: IdlingResource.ResourceCallback? = null

    override fun getName(): String {
        return FetchingIdlingResource::class.java.simpleName
    }

    override fun isIdleNow(): Boolean {
        if (idle) return true
        
        return idle
    }

    override fun registerIdleTransitionCallback(callback: IdlingResource.ResourceCallback?) {
        resourceCallback = callback
    }

}