package com.rahul.entertainmentnewz.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rahul.entertainmentnewz.domain.usecase.ChannelListUseCase
import com.rahul.entertainmentnewz.presentation.stateholder.ChannelListStateHolder
import com.rahul.entertainmentnewz.utils.Constant.UNEXPECTED_ERROR
import com.rahul.entertainmentnewz.utils.ResponseState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/** This ChannelList View model is used to fetch
 * the data from the ChannelListUseCase
 */
@HiltViewModel
class ChannelListViewModel @Inject constructor(
    private val channelListUseCase: ChannelListUseCase,
) : ViewModel() {

    private val _channelListValue = mutableStateOf(ChannelListStateHolder())
    var channelListState: State<ChannelListStateHolder> = _channelListValue

    init {
        getAllChannelList()
    }

    /** This function is used to get the channel list */
    fun getAllChannelList() = viewModelScope.launch {
        channelListUseCase().collect {
            when (it) {
                is ResponseState.Loading -> {
                    _channelListValue.value = ChannelListStateHolder(isLoading = true)
                }

                is ResponseState.Success -> {
                    _channelListValue.value =
                        ChannelListStateHolder(channelListItem = it.data ?: emptyList())
                }

                is ResponseState.Error -> {
                    _channelListValue.value =
                        ChannelListStateHolder(error = it.message ?: UNEXPECTED_ERROR)
                }
            }
        }
    }
}