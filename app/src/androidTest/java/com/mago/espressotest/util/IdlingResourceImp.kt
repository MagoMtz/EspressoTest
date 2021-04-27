package com.mago.espressotest.util

import androidx.test.espresso.IdlingResource

/**
 * @author by jmartinez
 * @since 16/02/2021.
 */
class IdlingResourceImp: IdlingResource {

    override fun getName(): String = IdlingResourceImp::class.java.simpleName

    override fun isIdleNow(): Boolean {
        TODO("Not yet implemented")
    }

    override fun registerIdleTransitionCallback(callback: IdlingResource.ResourceCallback?) {
        TODO("Not yet implemented")
    }
}