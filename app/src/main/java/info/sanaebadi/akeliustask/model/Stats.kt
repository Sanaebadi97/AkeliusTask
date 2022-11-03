package info.sanaebadi.akeliustask.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Stats(
    @Json(name = "atime")
    val atime: String = "",
    @Json(name = "atimeMs")
    val atimeMs: Long = 0,
    @Json(name = "birthtime")
    val birthtime: String = "",
    @Json(name = "birthtimeMs")
    val birthtimeMs: Double = 0.0,
    @Json(name = "blksize")
    val blksize: Int = 0,
    @Json(name = "blocks")
    val blocks: Int = 0,
    @Json(name = "ctime")
    val ctime: String = "",
    @Json(name = "ctimeMs")
    val ctimeMs: Double = 0.0,
    @Json(name = "dev")
    val dev: Int = 0,
    @Json(name = "gid")
    val gid: Int = 0,
    @Json(name = "ino")
    val ino: Int = 0,
    @Json(name = "mode")
    val mode: Int = 0,
    @Json(name = "mtime")
    val mtime: String = "",
    @Json(name = "mtimeMs")
    val mtimeMs: Long = 0,
    @Json(name = "nlink")
    val nlink: Int = 0,
    @Json(name = "rdev")
    val rdev: Int = 0,
    @Json(name = "size")
    val size: Int = 0,
    @Json(name = "uid")
    val uid: Int = 0
)