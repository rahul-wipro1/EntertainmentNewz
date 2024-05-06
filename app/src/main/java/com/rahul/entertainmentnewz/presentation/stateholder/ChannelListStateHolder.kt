package com.rahul.entertainmentnewz.presentation.stateholder

import com.rahul.entertainmentnewz.domain.model.ChannelListItem

/** This data class is used to handle the isLoading
 * and channelList and error message in viewModel
 */
data class ChannelListStateHolder(
    var isLoading: Boolean? = null,
    var channelListItem: List<ChannelListItem>? = emptyList(),
    var error: String? = null,
)