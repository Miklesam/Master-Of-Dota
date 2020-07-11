package com.miklesam.masterofdota.datamodels.roommodels

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "heroes_progress_table")
data class HeroProgress(
    @ColumnInfo(name = "id")
    var id: Int,
    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "progress")
    var progress: Int
) {
    @PrimaryKey(autoGenerate = true)
    var id_key: Int = 0
}