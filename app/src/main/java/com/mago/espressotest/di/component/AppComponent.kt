package com.mago.espressotest.di.component

import com.mago.espressotest.di.builder.ActivityBuilder
import com.mago.espressotest.di.module.AppModule
import dagger.Component
import javax.inject.Singleton

/**
 * @author by jmartinez
 * @since 16/02/2021.
 */
@Singleton
@Component(modules = [(AppModule::class), (ActivityBuilder::class)])
interface AppComponent {
}