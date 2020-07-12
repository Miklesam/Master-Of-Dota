package com.miklesam.masterofdota.room.ability

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.miklesam.masterofdota.datamodels.roommodels.AbilityProgress

@Dao
interface AbilityProgressDao {

    @Insert
    fun insertAbilityProgress(data: List<AbilityProgress>)

    @Query("SELECT * FROM ability_progress_table ")
    fun getAllAbilities(): LiveData<List<AbilityProgress>>

    @Update
    fun updateAbilityProgress(heroProgress: AbilityProgress)

    @Query("DELETE FROM ability_progress_table")
    fun nukeTable()

}