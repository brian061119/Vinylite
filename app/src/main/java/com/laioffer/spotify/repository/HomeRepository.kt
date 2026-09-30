package com.laioffer.spotify.repository

import com.laioffer.spotify.datamodel.Section
import com.laioffer.spotify.network.NetworkApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class HomeRepository @Inject constructor(private val networkApi: NetworkApi) {

    suspend fun getHomeFeed(): List<Section> = withContext(Dispatchers.IO) {
        // networkApi.getHomeFeed
        val call = networkApi.getHomeFeed()
        val response: retrofit2.Response<List<Section>> = call.execute()
        response.body() ?: listOf()
    }
}
