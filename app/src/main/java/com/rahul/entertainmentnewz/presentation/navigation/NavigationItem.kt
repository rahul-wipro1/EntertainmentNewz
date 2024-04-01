package com.rahul.entertainmentnewz.presentation.navigation

sealed class NavigationItem(val route: String) {
    object ChannelList : NavigationItem("channel_list")
    object ChannelDetail : NavigationItem("channel_detail")
}
