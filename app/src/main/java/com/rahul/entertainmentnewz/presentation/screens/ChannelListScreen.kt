package com.rahul.entertainmentnewz.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.rahul.entertainmentnewz.domain.model.ChannelListItem
import com.rahul.entertainmentnewz.presentation.component.ChannelItem
import com.rahul.entertainmentnewz.presentation.navigation.NavigationItem
import com.rahul.entertainmentnewz.presentation.viewmodel.ChannelListViewModel

@Composable
fun ChannelListScreen(
    navController: NavController, viewModelItem: ChannelListViewModel = hiltViewModel()
) {
    val result by viewModelItem.channelListState.collectAsState()

    if (result.isLoading) {
        ShowLoading()
    }

    if (result.channelListItem != null) {
        DisplayTheContent(result.channelListItem!!, navController)
    }

    if (result.error.isNotBlank()) {
        ShowError(result.error)
    }
}

/**
 *  display the content in list
 */
@Composable
fun DisplayTheContent(channelListItem: List<ChannelListItem>, navController: NavController) {
    Column(modifier = Modifier.padding(12.dp)) {
        LazyColumn(modifier = Modifier.testTag("channel_list")) {
            items(channelListItem) {
                ChannelItem(it) {
                    navController.currentBackStackEntry?.savedStateHandle?.set(
                        key = "channelItem",
                        value = it
                    )
                    navController.navigate(NavigationItem.ChannelDetail.route)
                }
            }
        }
    }
}

/**
 * This fun is used to show the circular progressBar
 */
@Composable
fun ShowLoading() {
    Column(
        modifier = Modifier.fillMaxSize(1f),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CircularProgressIndicator()
    }
}
/**
 * This fun is used to show the Error
 */
@Composable
fun ShowError(error: String) {
    Column(
        modifier = Modifier.fillMaxSize(1f),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = error, color = Color.Red)
    }
}
