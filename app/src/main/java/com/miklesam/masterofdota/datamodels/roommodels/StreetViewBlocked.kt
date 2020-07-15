package com.miklesam.masterofdota.datamodels.roommodels

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "street_view_table")
data class StreetViewBlocked(
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