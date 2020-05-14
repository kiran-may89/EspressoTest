package com.example.instrumentedtests

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.instrumentedtests.data.source.MoviesRemoteDataSource

import com.example.instrumentedtests.factory.MovieFragmentFactory
import com.example.instrumentedtests.fragments.MovieDetailFragment
import com.example.instrumentedtests.fragments.StarActorsFragment
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class StarActorlFragmentTest{
    val dataSource = MoviesRemoteDataSource()
    @Test
    fun test_MovieDetails() {
        val factory = MovieFragmentFactory()
        val movie = dataSource.getMovie(1)
        val bundle = Bundle()
        bundle.putStringArrayList("args_actors", movie!!.star_actors)
        val scenario = launchFragmentInContainer<StarActorsFragment>(
            fragmentArgs = bundle,
            factory = factory
        )
        onView(withId(R.id.star_actors_title)).check(matches(isDisplayed()))
        onView(withId(R.id.star_actors_title)).check(matches(withText(StarActorsFragment.stringBuilderForStarActors(movie.star_actors!!))))

    }
}