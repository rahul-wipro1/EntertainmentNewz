package com.rahul.entertainmentnewz.presentation.viewmodel

import com.rahul.entertainmentnewz.MainDispatcherRule
import com.rahul.entertainmentnewz.domain.model.ChannelListItem
import com.rahul.entertainmentnewz.domain.usecase.ChannelListUseCase
import com.rahul.entertainmentnewz.utils.ResponseState
import io.mockk.MockKAnnotations
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ChannelListViewModelTest{
    @ExperimentalCoroutinesApi
    @get:Rule
    val dispatcherRule = MainDispatcherRule()

    private lateinit var channelListUseCase: ChannelListUseCase
    private lateinit var channelListViewModel: ChannelListViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        channelListUseCase = mockk(relaxed = true)
        channelListViewModel = ChannelListViewModel(channelListUseCase)
    }

    @After
    fun tearDown() {
        clearAllMocks()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `test loading state`() = runTest {
        coEvery { channelListUseCase.invoke() } returns flow {
            emit(ResponseState.Loading<List<ChannelListItem>>())
        }
        //Trigger the getAllChannelList to be tested
        channelListViewModel.getAllChannelList()
        //verify
        coVerify { channelListUseCase.invoke() }
        dispatcherRule.dispatcher.scheduler.advanceUntilIdle()
        assertEquals(true, channelListViewModel.channelListState.value.isLoading)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `test fetchData success`() = runTest {
        val listData = listOf(
            ChannelListItem("11-12-2023", "Discription", "icon", "pic", "title")
        )
        val successData = ResponseState.Success(listData)

        coEvery { channelListUseCase.invoke() } returns flow {
            emit(successData)
        }

        channelListViewModel.getAllChannelList()
        coVerify { channelListUseCase.invoke() }
        dispatcherRule.dispatcher.scheduler.advanceUntilIdle()
        assertEquals(listData, channelListViewModel.channelListState.value.channelListItem)

    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `test for negative scenario `() = runTest {
        val errorMessage = "Error Occurred"
        //Mock the behaviour
        coEvery { channelListUseCase.invoke() } returns flow {
            emit(ResponseState.Error<List<ChannelListItem>>(errorMessage))
        }
        //Trigger the getAllChannelList to be tested
        channelListViewModel.getAllChannelList()
        //verify
        coVerify { channelListUseCase.invoke() }
        dispatcherRule.dispatcher.scheduler.advanceUntilIdle()
        assertEquals(errorMessage, channelListViewModel.channelListState.value.error)
    }
}
