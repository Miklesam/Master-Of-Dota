package com.miklesam.masterofdota.datamodels

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "heroes_progress_table")
data class HeroProgress(
    @ColumnInfo(name = "teamName")
    var id: Int,
    @ColumnInfo(name = "teamLogo")
    var name: String,
    @ColumnInfo(name = "teamDescription")
    var progress: Int
) {
    @PrimaryKey(autoGenerate = true)
    var id_key: Int = 0
}