package com.example.weatherapp5.location.presentation

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.rule.ActivityTestRule
import com.example.weatherapp5.R
import org.junit.Rule
import org.junit.Test

class LocationActivityTest {

    @get:Rule
    val locationActivity = ActivityTestRule(LocationActivity::class.java)

    @Test
    fun checkRecyclerviewIsDisplayed() {
        onView(withId(R.id.recyclerview_locations)).check(matches(isDisplayed()))
    }
}