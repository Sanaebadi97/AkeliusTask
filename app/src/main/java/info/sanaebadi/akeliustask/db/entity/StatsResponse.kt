package info.sanaebadi.akeliustask.db.entity


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class StatsResponse(
    @Json(name = "atime")
    val atime: String?,
    @Json(name = "atimeMs")
    val atimeMs: Long?,
    @Json(name = "birthtime")
    val birthtime: String?,
    @Json(name = "birthtimeMs")
    val birthtimeMs: Double?,
    @Json(name = "blksize")
    val blksize: Int?,
    @Json(name = "blocks")
    val blocks: Int?,
    @Json(name = "ctime")
    val ctime: String?,
    @Json(name = "ctimeMs")
    val ctimeMs: Double?,
    @Json(name = "dev")
    val dev: Int?,
    @Json(name = "gid")
    val gid: Int?,
    @Json(name = "ino")
    val ino: Int?,
    @Json(name = "mode")
    val mode: Int?,
    @Json(name = "mtime")
    val mtime: String?,
    @Json(name = "mtimeMs")
    val mtimeMs: Long?,
    @Json(name = "nlink")
    val nlink: Int?,
    @Json(name = "rdev")
    val rdev: Int?,
    @Json(name = "size")
    val size: Int?,
    @Json(name = "uid")
    val uid: Int?
){

}