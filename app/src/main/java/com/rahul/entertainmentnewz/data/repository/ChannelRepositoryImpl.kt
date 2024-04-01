package com.rahul.entertainmentnewz.data.repository

import com.rahul.entertainmentnewz.data.datasource.NetworkApi
import com.rahul.entertainmentnewz.data.dto.ChannelsDTOItem
import com.rahul.entertainmentnewz.domain.repository.ChannelRepository
import javax.inject.Inject

class ChannelRepositoryImpl @Inject constructor(
    private val networkApi: NetworkApi,
) : ChannelRepository {
    override suspend fun getAllChannels(): List<ChannelsDTOItem> {
        return networkApi.getChannelsList()
    }
}