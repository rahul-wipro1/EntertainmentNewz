package com.rahul.entertainmentnewz.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import coil.compose.AsyncImage
import com.rahul.entertainmentnewz.R
import com.rahul.entertainmentnewz.domain.model.ChannelListItem
import com.rahul.entertainmentnewz.ui.theme.spacing

@Composable
fun ChannelDetailScreen(result: ChannelListItem?) {
    Column(
        modifier = Modifier.padding(spacing.ten_dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = result?.title ?: stringResource(R.string.title),
            modifier = Modifier
                .padding(spacing.four_dp)
                .testTag(stringResource(R.string.title)),
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold
        )
        AsyncImage(
            model = result?.pic,
            contentDescription = null,
            placeholder = painterResource(id = R.drawable.ic_downloading),
            error = painterResource(id = R.drawable.ic_error),
            modifier = Modifier
                .fillMaxWidth()
                .height(spacing.threeFifty_dp)
                .testTag(stringResource(R.string.channel_image)),
            contentScale = ContentScale.FillWidth
        )

        Text(
            text = result?.discription ?: stringResource(R.string.no_description),
            modifier = Modifier
                .padding(spacing.four_dp)
                .testTag(stringResource(R.string.disc))
        )
    }
}