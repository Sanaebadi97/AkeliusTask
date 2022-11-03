package info.sanaebadi.akeliustask.network.service

import info.sanaebadi.akeliustask.model.AssetsResponse
import retrofit2.http.GET

interface AssetsRetrofitServices {
    @GET("assets")
    suspend fun getAssets(): AssetsResponse
}