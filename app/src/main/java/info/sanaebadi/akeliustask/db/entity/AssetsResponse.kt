package info.sanaebadi.akeliustask.db.entity


import androidx.room.*
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import info.sanaebadi.akeliustask.db.base.DataConverter

@JsonClass(generateAdapter = true)
@Entity(tableName = "akelius_assets")
data class AssetsResponse(
    @PrimaryKey
    @Json(name = "status")
    val status: String,
    @Json(name = "files")
    val fileResponses: List<FileResponse>
)