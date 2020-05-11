package com.example.instrumentedtests

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.hamcrest.Matcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {
    @get:Rule
    val testScenario = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun test_dialog(){
        onView(withId(R.id.button_launch_dialog)).check(matches(isDisplayed()))
        onView(withId(R.id.button_launch_dialog)).perform(click())
        onView(withText(R.string.text_enter_name)).check(matches(isDisplayed()))
        onView(withText(R.string.text_ok)).perform(click())
        onView(withText(R.string.text_enter_name)).check(matches(isDisplayed()))
        onView(withId(R.id.md_input_message)).perform(typeText("Tested"))
        onView(withText(R.string.text_ok)).perform(click())
        onView(withText(R.string.text_enter_name)).check(doesNotExist())
        onView(withId(R.id.text_name)).check(matches(withText("Tested")))

    }
}