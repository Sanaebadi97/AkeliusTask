package info.sanaebadi.akeliustask.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import info.sanaebadi.akeliustask.db.entity.FileEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AssetsDao {

    @Query("SELECT * FROM assets")
    fun files(): Flow<List<FileEntity>>

    @Query("SELECT * FROM assets")
   suspend fun getFiles(): List<FileEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFileAssets(files: List<FileEntity>)

    @Query("DELETE FROM assets WHERE path IN (:paths)")
    suspend fun deleteAssets(paths: List<String>)
}