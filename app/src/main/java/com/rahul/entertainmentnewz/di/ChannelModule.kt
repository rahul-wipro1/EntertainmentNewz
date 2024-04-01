package com.rahul.entertainmentnewz.di

import com.rahul.entertainmentnewz.data.datasource.NetworkApi
import com.rahul.entertainmentnewz.data.repository.ChannelRepositoryImpl
import com.rahul.entertainmentnewz.domain.repository.ChannelRepository
import com.rahul.entertainmentnewz.utils.Constant.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ChannelModule {

    @Provides
    @Singleton
    fun provideNetworkApi(): NetworkApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NetworkApi::class.java)
    }

    @Provides
    @Singleton
    fun provideChannelRepository(networkApi: NetworkApi): ChannelRepository {
        return ChannelRepositoryImpl(networkApi)
    }
}