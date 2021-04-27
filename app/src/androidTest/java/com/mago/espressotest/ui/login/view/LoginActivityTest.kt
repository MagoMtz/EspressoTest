package com.mago.espressotest.ui.login.view

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.IdlingResource
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.mago.espressotest.R
import com.mago.espressotest.util.FetchingIdlingResource
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * @author by jmartinez
 * @since 15/02/2021.
 */
@RunWith(AndroidJUnit4::class)
@LargeTest
class LoginActivityTest {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(LoginActivity::class.java)

    private val fetchingIdlingResource = FetchingIdlingResource()

    @Before
    fun setup() {
        IdlingRegistry.getInstance().register(fetchingIdlingResource)
    }

    @Test
    fun incorrectDataLoginShowIncorrectDataMsg() {
        onView(withId(R.id.et_username)).perform(typeText("user"))
        onView(withId(R.id.et_password)).perform(typeText("pass"))

        onView(withId(R.id.btn_login)).perform(click())

        Thread.sleep(1100)

        onView(withId(R.id.tv_session_status))
            .check(matches(isDisplayed()))
        onView(withId(R.id.tv_session_status))
            .check(matches(withText(R.string.incorrect_data)))
    }

    @Test
    fun showProgressBar() {
    }

    @Test
    fun hideProgressBar() {
    }

    @Test
    fun incorrectData() {
    }

    @Test
    fun onLoginSuccess() {
    }

    @Test
    fun onLoginError() {
    }

}