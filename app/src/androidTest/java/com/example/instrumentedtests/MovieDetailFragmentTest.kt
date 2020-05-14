package com.example.instrumentedtests

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner

import com.example.instrumentedtests.data.source.MoviesDataSource
import com.example.instrumentedtests.data.source.MoviesRemoteDataSource
import com.example.instrumentedtests.factory.MovieFragmentFactory
import com.example.instrumentedtests.fragments.MovieDetailFragment
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class MovieDetailFragmentTest{
val dataSource = MoviesRemoteDataSource()
    @Test
    fun test_MovieDetails() {
        val factory = MovieFragmentFactory()
        val movie = dataSource.getMovie(1)
        val bundle = Bundle()
        bundle.putInt("movie_id", movie!!.id)
        val scenario = launchFragmentInContainer<MovieDetailFragment>(
            fragmentArgs = bundle,
            factory = factory
        )
        onView(withId(R.id.movie_title)).check(matches(isDisplayed()))
        onView(withId(R.id.movie_title)).check(matches(withText(movie.title)))
        onView(withId(R.id.movie_description)).check(matches(withText(movie.description)))

        onView(withId(R.id.movie_directiors)).check(matches(isDisplayed()))

    }
}