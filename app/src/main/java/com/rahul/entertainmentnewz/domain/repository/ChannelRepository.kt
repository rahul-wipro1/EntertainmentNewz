package com.rahul.entertainmentnewz.domain.repository

import com.rahul.entertainmentnewz.data.dto.ChannelsDTOItem

interface ChannelRepository {
    suspend fun getAllChannels(): List<ChannelsDTOItem>
}