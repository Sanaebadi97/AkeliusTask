package info.sanaebadi.akeliustask.db.base;

import androidx.room.Database
import androidx.room.RoomDatabase
import info.sanaebadi.akeliustask.BuildConfig
import info.sanaebadi.akeliustask.db.dao.AssetsDao
import info.sanaebadi.akeliustask.db.entity.AssetsList


@Database(entities = [AssetsList::class], version = BuildConfig.VERSION_CODE)
abstract class AppDatabase : RoomDatabase() {
    abstract fun assetDao(): AssetsDao
}