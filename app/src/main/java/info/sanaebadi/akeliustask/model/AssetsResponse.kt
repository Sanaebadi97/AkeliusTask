package info.sanaebadi.akeliustask.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AssetsResponse(
    @Json(name = "status")
    val status: String,
    @Json(name = "files")
    val fileResponses: List<FileResponse>
)