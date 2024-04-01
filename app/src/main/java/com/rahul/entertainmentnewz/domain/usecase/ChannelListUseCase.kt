package com.rahul.entertainmentnewz.domain.usecase

import com.rahul.entertainmentnewz.data.mapper.toChanelList
import com.rahul.entertainmentnewz.domain.model.ChannelListItem
import com.rahul.entertainmentnewz.domain.repository.ChannelRepository
import com.rahul.entertainmentnewz.utils.Constant.ERROR_OCCURRED
import com.rahul.entertainmentnewz.utils.ResponseState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class ChannelListUseCase @Inject constructor(
    private val channelRepository: ChannelRepository,
) {
    operator fun invoke(): Flow<ResponseState<List<ChannelListItem>>> = flow {
        try {
            emit(ResponseState.Loading())
            val channel = channelRepository.getAllChannels().map {
                it.toChanelList()
            }
            emit(ResponseState.Success(channel))
        } catch (e: HttpException) {
            emit(ResponseState.Error(e.localizedMessage ?: ERROR_OCCURRED))
        } catch (e: IOException) {
            emit(ResponseState.Error(ERROR_OCCURRED))
        }
    }
}