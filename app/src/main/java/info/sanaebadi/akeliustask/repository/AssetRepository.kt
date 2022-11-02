package info.sanaebadi.akeliustask.repository

import androidx.room.withTransaction
import info.sanaebadi.akeliustask.db.base.AppDatabase
import info.sanaebadi.akeliustask.db.dao.AssetsDao
import info.sanaebadi.akeliustask.network.service.AssetsRetrofitServices
import info.sanaebadi.akeliustask.util.networkBoundResource
import kotlinx.coroutines.delay
import javax.inject.Inject


class AssetRepository @Inject constructor(
    private val assetsDao: AssetsDao,
    private val appDatabase: AppDatabase,
    private val assetsRetrofitServices: AssetsRetrofitServices
) {

    fun getAsset() = networkBoundResource(
        query = {
            assetsDao.getAllAssets()
        },
        fetch = {
            delay(2000)
            assetsRetrofitServices.getAssets()
        },
        saveFetchResult = { assets ->
            appDatabase.withTransaction {
                assetsDao.deleteAllAssets()
                assetsDao.insertAssets(assets)
            }
        }
    )

}