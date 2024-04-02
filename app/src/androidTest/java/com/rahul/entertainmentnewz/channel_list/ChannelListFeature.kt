package com.rahul.entertainmentnewz.channel_list

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onChildAt
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import com.rahul.entertainmentnewz.MainActivity
import org.junit.Rule
import org.junit.Test

class ChannelListFeature {

    @get:Rule
    val composeRule = createAndroidComposeRule<MainActivity>()


    @Test
    fun validateCircularProgress() {
        composeRule.apply {
            onNodeWithTag("circular_progress").assertIsDisplayed()
        }
    }

    @Test
    fun validateChannelListIsVisible() {
        composeRule.apply {
            Thread.sleep(2500L)
            onNodeWithTag("channel_list").assertIsDisplayed()
        }
    }

    @Test
    fun validateClickToNavigateToDetails() {
        composeRule.apply {
            Thread.sleep(3000L)
            onNodeWithTag("channel_list").onChildAt(0).performClick()
            onNodeWithTag("title").assertIsDisplayed()
        }
    }
}