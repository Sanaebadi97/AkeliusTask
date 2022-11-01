package info.sanaebadi.akeliustask.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "akelius_assets")
data class AssetsList(
    @PrimaryKey val make_and_model: String,
)