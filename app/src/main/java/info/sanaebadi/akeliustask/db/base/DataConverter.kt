package info.sanaebadi.akeliustask.db.base

import androidx.room.TypeConverter
import com.google.gson.Gson
import info.sanaebadi.akeliustask.db.entity.FileResponse

class DataConverter {
    @TypeConverter
    fun listToJsonString(value: List<FileResponse>?): String = Gson().toJson(value)

    @TypeConverter
    fun jsonStringToList(value: String) = Gson().fromJson(value, Array<FileResponse>::class.java).toList()
}