package com.miklesam.masterofdota.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.miklesam.masterofdota.datamodels.HeroProgress

@Dao
interface HeroProgressDao {

    @Insert
    fun insertHeroProgress(data: List<HeroProgress>)

    @Query("SELECT * FROM heroes_progress_table ")
    fun getAllHeroes(): LiveData<List<HeroProgress>>

    @Update
    fun updateHeroProgress(heroProgress: HeroProgress)

    @Query("DELETE FROM heroes_progress_table")
    fun nukeTable()

}