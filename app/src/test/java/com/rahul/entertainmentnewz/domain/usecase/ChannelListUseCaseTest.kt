package com.rahul.entertainmentnewz.domain.usecase

import com.rahul.entertainmentnewz.MainDispatcherRule
import com.rahul.entertainmentnewz.data.dto.ChannelsDTOItem
import com.rahul.entertainmentnewz.domain.model.ChannelListItem
import com.rahul.entertainmentnewz.domain.repository.ChannelRepository
import com.rahul.entertainmentnewz.utils.ResponseState
import io.mockk.MockKAnnotations
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.io.IOException

class ChannelListUseCaseTest {
    @ExperimentalCoroutinesApi
    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private lateinit var channelRepository: ChannelRepository
    private lateinit var channelListUseCase: ChannelListUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        channelRepository = mockk()
        channelListUseCase = ChannelListUseCase(channelRepository)
    }

    @After
    fun tearDown() {
        clearAllMocks()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `invoke loading by success`() = runTest{
        coEvery { channelRepository.getAllChannels()} returns listOf(ChannelsDTOItem("11-11-2023","disc","icon","pic","title"))

        val resultFlow = channelListUseCase()

        val result = mutableListOf<ResponseState<List<ChannelListItem>>>()
        resultFlow.collect{
            result.add(it)
        }
        Assert.assertTrue(result[0] is ResponseState.Loading)
        Assert.assertTrue(result[1] is ResponseState.Success)
        val successState =  result[1] as ResponseState.Success
        Assert.assertEquals(1,successState.data?.size)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `invoke loading by error`() = runTest{
        coEvery { channelRepository.getAllChannels()} throws IOException()
        val resultFlow = channelListUseCase()

        val result = mutableListOf<ResponseState<List<ChannelListItem>>>()
        resultFlow.collect{
            result.add(it)
        }
        Assert.assertTrue(result[0] is ResponseState.Loading)
        Assert.assertTrue(result[1] is ResponseState.Error)
        val errorState =  result[1] as ResponseState.Error
        Assert.assertEquals("Error Occurred",errorState.message)
    }
}