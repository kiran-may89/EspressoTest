package com.example.instrumentedtests.factory

import androidx.fragment.app.FragmentFactory
import com.example.instrumentedtests.fragments.DirectorsFragment
import com.example.instrumentedtests.fragments.MovieDetailFragment
import com.example.instrumentedtests.fragments.StarActorsFragment

class MovieFragmentFactory : FragmentFactory(){

    private val TAG: String = "AppDebug"

    override fun instantiate(classLoader: ClassLoader, className: String) =

        when(className){

            MovieDetailFragment::class.java.name -> {
                MovieDetailFragment()
            }

            DirectorsFragment::class.java.name -> {
                DirectorsFragment()
            }

            StarActorsFragment::class.java.name -> {
                StarActorsFragment()
            }

            else -> {
                super.instantiate(classLoader, className)
            }
        }


}