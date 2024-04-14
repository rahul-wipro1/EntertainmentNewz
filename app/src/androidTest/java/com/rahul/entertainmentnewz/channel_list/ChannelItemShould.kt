package com.rahul.entertainmentnewz.channel_list

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import com.rahul.entertainmentnewz.domain.model.ChannelListItem
import com.rahul.entertainmentnewz.presentation.component.ChannelItem
import com.rahul.entertainmentnewz.utils.Constant.CARTOON_NETWORK
import com.rahul.entertainmentnewz.utils.Constant.CHANNEL_ITEM
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ChannelItemShould {

    @get:Rule
    val composeRule = createComposeRule()
    private lateinit var channelListItem: ChannelListItem

    @Before
    fun setUp() {
        channelListItem = ChannelListItem(
            date = "02-04-2024",
            discription = "Disc",
            icon = "icon",
            pic = "pic",
            title = "Cartoon Network"
        )

        composeRule.setContent {
            ChannelItem(channelListItem = channelListItem) {}
        }
    }

    @Test
    fun displayItem() {
        composeRule.onNodeWithTag(CHANNEL_ITEM).assertIsDisplayed()
    }

    @Test
    fun containTitle() {
        composeRule.onNodeWithText(CARTOON_NETWORK).assertIsDisplayed()
    }
}