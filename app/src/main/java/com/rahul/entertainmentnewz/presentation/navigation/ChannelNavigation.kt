package com.rahul.entertainmentnewz.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.rahul.entertainmentnewz.domain.model.ChannelListItem
import com.rahul.entertainmentnewz.presentation.screens.ChannelDetailScreen
import com.rahul.entertainmentnewz.presentation.screens.ChannelListScreen

@Composable
fun ChannelNavigation(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = NavigationItem.ChannelList.route
    ) {
        composable(NavigationItem.ChannelList.route) { ChannelListScreen(navController = navHostController) }
        composable(NavigationItem.ChannelDetail.route) {
            val result =
                navHostController.previousBackStackEntry?.savedStateHandle?.get<ChannelListItem>("channelItem")
            ChannelDetailScreen(result)
        }
    }
}