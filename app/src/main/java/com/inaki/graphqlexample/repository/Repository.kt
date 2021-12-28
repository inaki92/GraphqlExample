package com.inaki.graphqlexample.repository

import com.apollographql.apollo.api.Response
import com.apollographql.apollo.coroutines.await
import com.inaki.graphqlexample.CharactersListQuery
import com.inaki.graphqlexample.network.NetworkApi
import javax.inject.Inject

interface Repository {
    suspend fun queryCharactersList(): Response<CharactersListQuery.Data>
}

class RepositoryImpl @Inject constructor(
    private val networkApi: NetworkApi
) : Repository {

    override suspend fun queryCharactersList(): Response<CharactersListQuery.Data> =
        networkApi.getApolloClient().query(CharactersListQuery()).await()
}