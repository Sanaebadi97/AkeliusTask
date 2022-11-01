package info.sanaebadi.akeliustask.db.base;

import androidx.room.Database
import androidx.room.RoomDatabase
import info.sanaebadi.akeliustask.BuildConfig


@Database(entities = [AssetsList::class], version = BuildConfig.VERSION_CODE)
abstract class AppDatabase : RoomDatabase() {
    abstract fun assetDao(): AssetsDao
}