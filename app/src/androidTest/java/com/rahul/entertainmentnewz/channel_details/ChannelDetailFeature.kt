package com.rahul.entertainmentnewz.channel_details

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onChildAt
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import com.rahul.entertainmentnewz.MainActivity
import com.rahul.entertainmentnewz.utils.Constant.CHANNEL_IMAGE
import com.rahul.entertainmentnewz.utils.Constant.CHANNEL_LIST
import com.rahul.entertainmentnewz.utils.Constant.DELAY_2000
import com.rahul.entertainmentnewz.utils.Constant.DELAY_3000
import com.rahul.entertainmentnewz.utils.Constant.DISC
import com.rahul.entertainmentnewz.utils.Constant.TITLE
import com.rahul.entertainmentnewz.utils.Constant.ZERO
import org.junit.Rule
import org.junit.Test

class ChannelDetailFeature {

    @get:Rule
    val composeRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun validateImageIsVisible() {
        composeRule.apply {
            Thread.sleep(DELAY_3000)
            onNodeWithTag(CHANNEL_LIST).onChildAt(ZERO).performClick()
            onNodeWithTag(CHANNEL_IMAGE).assertIsDisplayed()
        }
    }

    @Test
    fun validateTitle() {
        composeRule.apply {
            Thread.sleep(DELAY_2000)
            onNodeWithTag(CHANNEL_LIST).onChildAt(ZERO).performClick()
            onNodeWithTag(TITLE).assertIsDisplayed()
        }
    }

    @Test
    fun validateDisc() {
        composeRule.apply {
            Thread.sleep(DELAY_2000)
            onNodeWithTag(CHANNEL_LIST).onChildAt(ZERO).performClick()
            onNodeWithTag(DISC).assertIsDisplayed()
        }
    }
}