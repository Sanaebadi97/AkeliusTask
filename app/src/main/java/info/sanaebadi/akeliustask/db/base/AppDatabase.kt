package info.sanaebadi.akeliustask.db.base

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import info.sanaebadi.akeliustask.BuildConfig
import info.sanaebadi.akeliustask.db.dao.AssetsDao
import info.sanaebadi.akeliustask.db.entity.AssetsResponse
import info.sanaebadi.akeliustask.db.entity.FileResponse


@Database(entities = [FileResponse::class], version = BuildConfig.VERSION_CODE, exportSchema = false)
@TypeConverters(NormalConverters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun assetDao(): AssetsDao
}