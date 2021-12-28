package com.inaki.graphqlexample.di

import com.inaki.graphqlexample.network.NetworkApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Provides
    @Singleton
    fun providesNetworkService(): NetworkApi = NetworkApi()
}