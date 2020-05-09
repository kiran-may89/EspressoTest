package com.example.instrumentedtests

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.instrumentedtests.data.DummyMovies.THE_RUNDOWN
import com.example.instrumentedtests.factory.MovieFragmentFactory
import com.example.instrumentedtests.fragments.DirectorsFragment
import com.example.instrumentedtests.fragments.MovieDetailFragment
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class DirectorsFragmentTest{

    @Test
    fun test_MovieDetails() {
        val factory = MovieFragmentFactory()
        val movie = THE_RUNDOWN
        val bundle = Bundle()
        bundle.putStringArrayList("args_directors", movie.directors)
        val scenario = launchFragmentInContainer<DirectorsFragment>(
            fragmentArgs = bundle,
            factory = factory
        )
        onView(withId(R.id.directors_title)).check(matches(isDisplayed()))
        onView(withId(R.id.directors_title)).check(matches(withText(DirectorsFragment.stringBuilderForDirectors(movie.directors!!))))


    }
}