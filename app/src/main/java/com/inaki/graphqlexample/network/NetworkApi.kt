package com.inaki.graphqlexample.network

import android.os.Looper
import com.apollographql.apollo.ApolloClient
import okhttp3.OkHttpClient

class NetworkApi {

    /**
     * The apollo client to perform the network call
     */
    fun getApolloClient(): ApolloClient {

        check(Looper.myLooper() == Looper.getMainLooper()) {
            "Please call apollo from the Main thread"
        }

        // this is the okhttp client to add the time outs, and interceptors
        val okHttpClient = OkHttpClient.Builder().build()

        // this is the apollo client object to be used for the network call
        return ApolloClient.builder()
            .serverUrl(BASE_URL)
            .okHttpClient(okHttpClient)
            .build()
    }

    companion object {
        private const val BASE_URL = "https://rickandmortyapi.com/graphql"
    }
}