package info.sanaebadi.akeliustask.db.entity


import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
@Entity(tableName = "akelius_assets")
data class FileResponse(
    @PrimaryKey
    @Json(name = "path")
    val path: String,
    @Json(name = "stats")
    @Embedded
    val statsResponse: StatsResponse?
)