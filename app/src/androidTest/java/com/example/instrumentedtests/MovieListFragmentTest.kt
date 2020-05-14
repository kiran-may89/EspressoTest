package com.example.instrumentedtests

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.instrumentedtests.adapter.MoviesListAdapter
import com.example.instrumentedtests.data.Movie
import com.example.instrumentedtests.data.source.MoviesRemoteDataSource
import org.hamcrest.CoreMatchers.*
import org.hamcrest.Matchers.allOf
import org.hamcrest.collection.IsMapContaining.hasEntry
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class MovieListFragmentTest{

    @get:Rule
    val scenario  = ActivityScenarioRule(MainActivity::class.java)
    val datasource = MoviesRemoteDataSource()

    @Test
    public  fun test_list_visible(){
        val item_position = 4;
        val movie  = datasource.getMovie(item_position)
        onView(withId(R.id.recycler_view)).check(matches(isDisplayed()))

        onView(withId(R.id.recycler_view)).perform(actionOnItemAtPosition<MoviesListAdapter.MovieViewHolder>(item_position,click()))

        onView(withId(R.id.movie_title)).check(matches(withText(movie!!.title) ))

    }


}