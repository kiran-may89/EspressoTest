package com.example.instrumentedtests

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import kotlinx.android.synthetic.main.fragment_movie_details.*
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class ActivityNavigation {

    @Test
    fun test_navigation() {
        val scenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.movie_directiors)).check(matches(isDisplayed()))
        onView(withId(R.id.movie_directiors)).perform(click())

        onView(withId(R.id.directors_title)).check(matches((isDisplayed())))
        pressBack()
        onView(withId(R.id.movie_directiors)).check(matches(isDisplayed()))
        onView(withId(R.id.movie_star_actors)).perform(click())

        onView(withId(R.id.star_actors_title)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
    }
}