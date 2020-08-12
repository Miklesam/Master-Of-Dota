package com.miklesam.mastersofdota.datamodels.roommodels

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ability_progress_table")
data class AbilityProgress(
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