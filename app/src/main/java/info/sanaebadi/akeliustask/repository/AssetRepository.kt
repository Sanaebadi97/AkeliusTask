package info.sanaebadi.akeliustask.repository

import android.util.Log
import androidx.room.withTransaction
import info.sanaebadi.akeliustask.db.base.AppDatabase
import info.sanaebadi.akeliustask.db.dao.AssetsDao
import info.sanaebadi.akeliustask.db.entity.FileEntity
import info.sanaebadi.akeliustask.model.FileResponse
import info.sanaebadi.akeliustask.model.Stats
import info.sanaebadi.akeliustask.network.service.AssetsRetrofitServices
import info.sanaebadi.akeliustask.util.networkBoundResource
import kotlinx.coroutines.delay
import javax.inject.Inject


class AssetRepository @Inject constructor(
    private val assetsDao: AssetsDao,
    private val appDatabase: AppDatabase,
    private val assetsRetrofitServices: AssetsRetrofitServices
) {

    private fun List<FileResponse>.toFileEntity(): List<FileEntity> {
        return this.map { response: FileResponse ->
            FileEntity(
                path = response.path, stats = Stats(
                    atime = response.stats.atime,
                    atimeMs = response.stats.atimeMs,
                    birthtime = response.stats.birthtime,
                    birthtimeMs = response.stats.birthtimeMs,
                    blksize = response.stats.blksize,
                    blocks = response.stats.blocks,
                    ctime = response.stats.ctime,
                    ctimeMs = response.stats.ctimeMs,
                    dev = response.stats.dev,
                    gid = response.stats.gid,
                    ino = response.stats.ino,
                    mode = response.stats.mode,
                    mtime = response.stats.mtime,
                    mtimeMs = response.stats.mtimeMs,
                    nlink = response.stats.nlink,
                    rdev = response.stats.rdev,
                    size = response.stats.size,
                    uid = response.stats.uid,
                )
            )
        }
    }

    fun getAsset() = networkBoundResource(query = {
        assetsDao.files()
    }, fetch = {
        delay(2000)
        assetsRetrofitServices.getAssets()
    }, saveFetchResult = { assets ->
        appDatabase.withTransaction {
            assetsDao.insertFileAssets(assets.fileResponses.toFileEntity())
        }
    })

    suspend fun sync() {
        val localFiles = assetsDao.getFiles()
        val test = assetsRetrofitServices.getAssets().fileResponses.toFileEntity()
        val remoteFiles = test + test.first().copy(stats = test.first().stats.copy(mtime = "2023-01-01"))

        //1-what is added remotely and missing locally
        if (localFiles.isEmpty()) {
            assetsDao.insertFileAssets(remoteFiles)
        } else {
            //2-what is removed remotely and present locally
            val newAddedFiles = remoteFiles.filter { remoteFile ->
                localFiles.find { (it.path == remoteFile.path) } == null
            }
            //3-what is the same file, but different stats (file size, modification time, ...)
            val modifiedFiles = mutableListOf<FileEntity>()
            val deletedFiles = mutableListOf<FileEntity>()
            localFiles.forEach { localFile ->
                val remoteFile = remoteFiles.find { it.path == localFile.path }
                if (remoteFile != null && (localFile.stats.mtime != remoteFile.stats.mtime || remoteFile.stats.size != localFile.stats.size)) {
                    modifiedFiles.add(remoteFile)
                }
                if (remoteFile == null) {
                    deletedFiles.add(localFile)
                }
            }
            val updatedFile = newAddedFiles + modifiedFiles
            //transaction, delete the deletedFile and add the updatedFile
            appDatabase.withTransaction {
                assetsDao.deleteAssets(deletedFiles.map {
                    it.path
                })
                assetsDao.insertFileAssets(updatedFile)
            }

        }
    }
}