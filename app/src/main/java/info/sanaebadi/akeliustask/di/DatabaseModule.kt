package info.sanaebadi.akeliustask.di

import android.app.Application
import androidx.room.Room.databaseBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import info.sanaebadi.akeliustask.BuildConfig
import info.sanaebadi.akeliustask.db.base.AppDatabase
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {
    @Provides
    @Singleton
    fun provideAppDatabase(application: Application?): AppDatabase {
        return databaseBuilder(
            application!!,
            AppDatabase::class.java,
            BuildConfig.DATABASE_NAME
        ).allowMainThreadQueries()
            .addMigrations()
            .build()
    }

}