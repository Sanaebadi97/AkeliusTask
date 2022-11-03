package info.sanaebadi.akeliustask.db.entity


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import info.sanaebadi.akeliustask.model.Stats

@JsonClass(generateAdapter = true)
@Entity(tableName = "assets")
data class FileEntity(
    @PrimaryKey
    @Json(name = "path")
    var path: String,
    @Json(name = "stats")
    val stats: Stats
)