package com.mago.espressotest

import com.mago.espressotest.ui.login.view.ILoginView
import io.mockk.impl.annotations.MockK
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @MockK
    lateinit var view: ILoginView

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
}