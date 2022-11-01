package info.sanaebadi.akeliustask.db.entity


import androidx.room.Embedded
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AssetsResponse(
    @Json(name = "status")
    val status: String,
    @Json(name = "files")
    @Embedded
    val fileResponses: List<FileResponse?>?
)