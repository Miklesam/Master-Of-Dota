package com.miklesam.mastersofdota.datamodels.roommodels

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "hair_view_table")
data class HairViewBlocked(
    @ColumnInfo(name = "id")
    var id: Int,
    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "unblocked")
    var unblocked: Boolean
) {
    @PrimaryKey(autoGenerate = true)
    var id_key: Int = 0
}