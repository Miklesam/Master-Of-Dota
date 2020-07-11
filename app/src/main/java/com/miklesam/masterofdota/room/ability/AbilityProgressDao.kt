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

    @Query("SELECT * FROM heroes_progress_table ")
    fun getAllHeroes(): LiveData<List<AbilityProgress>>

    @Update
    fun updateHeroProgress(heroProgress: AbilityProgress)

    @Query("DELETE FROM heroes_progress_table")
    fun nukeTable()

}