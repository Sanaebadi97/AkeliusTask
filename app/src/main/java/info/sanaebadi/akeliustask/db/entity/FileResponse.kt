package info.sanaebadi.akeliustask.db.entity


import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FileResponse(
    @Json(name = "path")
    val path: String,
    @Json(name = "stats")
    val statsResponse: StatsResponse
)