package info.sanaebadi.akeliustask.db.entity


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
@Entity(tableName = "akelius_assets")
data class AssetsResponse(
    @Json(name = "status")
    @PrimaryKey val status: String?,
    @Json(name = "files")
    val files: List<File?>?
)