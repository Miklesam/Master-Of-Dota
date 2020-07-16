package com.miklesam.masterofdota.room.streetblocked

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.miklesam.masterofdota.datamodels.roommodels.HeroProgress
import com.miklesam.masterofdota.datamodels.roommodels.StreetViewBlocked

@Dao
interface StreetBlockedDao {

    @Insert
    fun insertStreetBlocked(data: List<StreetViewBlocked>)

    @Query("SELECT * FROM street_view_table ")
    fun getAllStreetBlocked(): LiveData<List<StreetViewBlocked>>

    @Update
    fun updateStreetBlocked(streetBlocked: StreetViewBlocked)

    @Query("DELETE FROM street_view_table")
    fun nukeTable()

}