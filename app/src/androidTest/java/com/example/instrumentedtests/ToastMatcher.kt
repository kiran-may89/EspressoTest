package com.example.instrumentedtests

import android.os.Binder
import android.os.IBinder
import android.view.WindowManager
import androidx.test.espresso.Root
import org.hamcrest.Description
import org.hamcrest.TypeSafeMatcher

class ToastMatcher:TypeSafeMatcher<Root?>() {
    override fun describeTo(description: Description?) {
       description?.appendText("Toast Description")
    }

    override fun matchesSafely(item: Root?): Boolean {

        val type:Int? = item?.windowLayoutParams?.get()?.type
        if (type  == WindowManager.LayoutParams.TYPE_TOAST){
            val windowBinder:IBinder = item.decorView.windowToken
            val apptoken:IBinder = item.decorView.applicationWindowToken
            return apptoken == windowBinder
        }
        return false
    }

}