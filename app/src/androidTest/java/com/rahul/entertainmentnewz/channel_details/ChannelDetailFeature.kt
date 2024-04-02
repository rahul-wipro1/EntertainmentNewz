package com.rahul.entertainmentnewz.channel_details

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onChildAt
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import com.rahul.entertainmentnewz.MainActivity
import org.junit.Rule
import org.junit.Test

class ChannelDetailFeature {

    @get:Rule
    val composeRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun validateImageIsVisible() {
        composeRule.apply {
            Thread.sleep(3000L)
            onNodeWithTag("channel_list").onChildAt(0).performClick()
            onNodeWithTag("channel_image").assertIsDisplayed()
        }
    }

    @Test
    fun validateTitle() {
        composeRule.apply {
            Thread.sleep(2000L)
            onNodeWithTag("channel_list").onChildAt(0).performClick()
            onNodeWithTag("title").assertIsDisplayed()
        }
    }

    @Test
    fun validateDisc() {
        composeRule.apply {
            Thread.sleep(2000L)
            onNodeWithTag("channel_list").onChildAt(0).performClick()
            onNodeWithTag("disc").assertIsDisplayed()
        }
    }
}