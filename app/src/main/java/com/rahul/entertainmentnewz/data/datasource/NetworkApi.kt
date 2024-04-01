package com.rahul.entertainmentnewz.data.datasource

import com.rahul.entertainmentnewz.data.dto.ChannelsDTOItem
import retrofit2.http.GET

interface NetworkApi {

    @GET("/channels.json")
    suspend fun getChannelsList(): List<ChannelsDTOItem>
}