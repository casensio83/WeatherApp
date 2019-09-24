package com.example.weatherapp5.location.presentation

import androidx.test.rule.ActivityTestRule
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.action.ViewActions.*
import com.example.weatherapp5.R
import org.junit.Rule
import org.junit.Test

class NewLocationActivityTest {

    @get:Rule
    val newLocationActivity = ActivityTestRule(NewLocationActivity::class.java)

    @get:Rule
    val locationActivity = ActivityTestRule(LocationActivity::class.java)

    @Test
    fun checkButtonIsDisplayed() {
        onView(withId(R.id.bt_add_location)).check(matches(isDisplayed()))
    }

    @Test
    fun checkClickButton_goToLocationActivity() {
        onView(withId(R.id.bt_add_location)).perform(click())
        onView(withId(R.id.recyclerview_locations)).check(matches(isDisplayed()))
    }
}