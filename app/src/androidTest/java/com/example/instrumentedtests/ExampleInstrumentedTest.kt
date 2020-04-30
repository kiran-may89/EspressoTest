package com.example.instrumentedtests

import android.view.View
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule
import java.util.regex.Matcher

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4ClassRunner::class)
class ExampleInstrumentedTest {


    @Test
    fun test_isVisible() {
        // Context of the app under test.
        ActivityScenario.launch(MainActivity::class.java)
        onView(withId((R.id.main))).check(matches(isDisplayed()))
    }

    @Test
    fun test_allElementsVisible() {
        ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.activity_main_title)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))

        onView(withId(R.id.button_next_activity)).check(matches(isDisplayed()))
    }

    @Test
    fun isTextEqual() {
        ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.activity_main_title)).check(matches(withText(R.string.text_mainactivity)))


    }
}
