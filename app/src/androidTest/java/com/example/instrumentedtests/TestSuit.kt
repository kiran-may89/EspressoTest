package com.example.instrumentedtests

import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(MainActivityTest::class,SecondActivityTest::class)
class TestSuit