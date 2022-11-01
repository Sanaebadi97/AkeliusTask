package info.sanaebadi.akeliustask.db.base

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class NormalConverters {
    @TypeConverter
    fun stringFromList(value: List<String?>?): String? {
        if (value == null) {
            return null
        }
        val gson = Gson()
        val type = object :
            TypeToken<List<String?>?>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun ListFromString(value: String?): List<String>? {
        if (value == null) {
            return null
        }
        val gson = Gson()
        val type = object :
            TypeToken<List<String?>?>() {}.type
        return gson.fromJson(value, type)
    }

    companion object {
        @TypeConverter
        fun arrayFromString(value: String?): Array<String> {
            val arrayType = object : TypeToken<Array<String?>?>() {}.type
            return Gson().fromJson(value, arrayType)
        }

        @TypeConverter
        fun stringFromArray(value: Array<String?>?): String {
            return Gson().toJson(value)
        }
    }
}