package com.miklesam.mastersofdota.room.hairblocked

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.miklesam.mastersofdota.datamodels.roommodels.HairViewBlocked
import com.miklesam.mastersofdota.datamodels.roommodels.StreetViewBlocked

@Dao
interface HairBlockedDao {

    @Insert
    fun insertHairBlocked(data: List<HairViewBlocked>)

    @Query("SELECT * FROM hair_view_table ")
    fun getAllHairBlocked(): LiveData<List<HairViewBlocked>>

    @Update
    fun updateHairBlocked(streetBlocked: HairViewBlocked)

    @Query("DELETE FROM hair_view_table")
    fun nukeTable()

}