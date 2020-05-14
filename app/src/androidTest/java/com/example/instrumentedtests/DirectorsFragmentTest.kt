package com.example.instrumentedtests

import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.instrumentedtests.data.FakeMovieData

import com.example.instrumentedtests.factory.MovieFragmentFactory
import com.example.instrumentedtests.fragments.DirectorsFragment
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class DirectorsFragmentTest{

    @Test
    fun test_MovieDetails() {
        val factory = MovieFragmentFactory()
        val movie = FakeMovieData.movies[1]
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