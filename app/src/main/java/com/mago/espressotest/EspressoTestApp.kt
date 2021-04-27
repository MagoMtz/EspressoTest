package com.mago.espressotest

import android.app.Application
import dagger.android.DaggerApplication

/**
 * @author by jmartinez
 * @since 16/02/2021.
 */
class EspressoTestApp: Application() {

    val appComponent = DaggerApplication

}