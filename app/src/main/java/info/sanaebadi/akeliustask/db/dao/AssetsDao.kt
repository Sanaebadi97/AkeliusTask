package info.sanaebadi.akeliustask.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import info.sanaebadi.akeliustask.db.entity.AssetsResponse
import info.sanaebadi.akeliustask.db.entity.FileResponse
import kotlinx.coroutines.flow.Flow

@Dao
interface AssetsDao {

    @Query("SELECT * FROM akelius_assets")
    fun getAllAssets(): Flow<List<FileResponse>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAssets(assetsResponse: AssetsResponse)

    @Query("DELETE FROM akelius_assets")
    suspend fun deleteAllAssets()
}