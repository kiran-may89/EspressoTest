package com.example.instrumentedtests

import android.app.Activity.RESULT_OK
import android.app.Instrumentation
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.provider.MediaStore
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.Intents.intending
import androidx.test.espresso.intent.matcher.IntentMatchers.hasAction
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.instrumentedtests.ImageViewHasDrawableMatcher.hasDrawable
import org.hamcrest.Matcher
import org.hamcrest.Matchers.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class CameraActivityTest{
    @get:Rule
    val intenttest = IntentsTestRule(CameraActivity::class.java)

    @Test
    fun test_camera(){
        val expected: Matcher<Intent> =  hasAction(MediaStore.ACTION_IMAGE_CAPTURE)
        val result = createActivityResultStub()
        intending(expected).respondWith(result)
        onView(withId(R.id.image)).check(matches(not(hasDrawable())))
        onView(withId(R.id.button_launch_camera)).perform(click())
        intended(expected)
        onView(withId(R.id.image)).check(matches(hasDrawable()))
    }

    fun createActivityResultStub(): Instrumentation.ActivityResult {
        val bundle = Bundle()
        val bitmap =  BitmapFactory.decodeResource(intenttest.activity.resources,R.drawable.ic_launcher_background)
        bundle.putParcelable(KEY_IMAGE_DATA,bitmap)
        val resultIntent  = Intent()
        resultIntent.putExtras(bundle)
        return Instrumentation.ActivityResult(RESULT_OK,resultIntent)

    }
}