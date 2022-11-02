package info.sanaebadi.akeliustask.db.entity


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FileResponse(
    @Json(name = "path")
    val path: String,
    @Json(name = "stats")
    val statsResponse: StatsResponse
)