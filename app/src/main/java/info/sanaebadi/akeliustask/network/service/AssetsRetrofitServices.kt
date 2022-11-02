package info.sanaebadi.akeliustask.network.service

import info.sanaebadi.akeliustask.db.entity.AssetsResponse
import retrofit2.http.GET

interface AssetsRetrofitServices {
    @GET("assets")
    suspend fun getAssets(): AssetsResponse
}