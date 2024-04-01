package com.rahul.entertainmentnewz.presentation.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.rahul.entertainmentnewz.R
import com.rahul.entertainmentnewz.domain.model.ChannelListItem

@Composable
fun ChannelItem(channelListItem: ChannelListItem, onClick: (ChannelListItem) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {

        Card(elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(1f)
                .clickable {
                    onClick.invoke(channelListItem)
                }) {

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                AsyncImage(
                    model = channelListItem.pic,
                    contentDescription = null,
                    placeholder = painterResource(id = R.drawable.ic_downloading),
                    error = painterResource(id = R.drawable.ic_error),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp),
                    contentScale = ContentScale.FillWidth
                )

                Text(
                    text = channelListItem.title!!,
                    modifier = Modifier.padding(8.dp),
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}