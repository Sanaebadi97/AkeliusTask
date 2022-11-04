package info.sanaebadi.akeliustask.db.base

import androidx.room.TypeConverter
import com.google.gson.Gson
import info.sanaebadi.akeliustask.model.FileResponse
import info.sanaebadi.akeliustask.model.Stats

class DataConverter {
    @TypeConverter
    fun listToJsonString(value: List<FileResponse>?): String = Gson().toJson(value)

    @TypeConverter
    fun jsonStringToList(value: String) = Gson().fromJson(value, Array<FileResponse>::class.java).toList()

    @TypeConverter
    fun modelToString(app: Stats): String = Gson().toJson(app)

    @TypeConverter
    fun stringToModel(string: String): Stats = Gson().fromJson(string, Stats::class.java)

}