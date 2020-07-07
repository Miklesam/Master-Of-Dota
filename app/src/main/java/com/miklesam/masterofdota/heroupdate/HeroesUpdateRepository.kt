package com.miklesam.masterofdota.heroupdate

import android.app.Application
import androidx.lifecycle.LiveData
import com.miklesam.masterofdota.datamodels.HeroProgress
import com.miklesam.masterofdota.room.HeroProgressDao
import com.miklesam.masterofdota.room.HeroProgressDatabase

class HeroesUpdateRepository(application: Application) {
    private var heroesDao: HeroProgressDao
    private var allHeroesProgress: LiveData<List<HeroProgress>>

    init {
        val database: HeroProgressDatabase =
            HeroProgressDatabase.getInstance(application.applicationContext)
        heroesDao = database.noteDao()
        allHeroesProgress = heroesDao.getAllHeroes()
    }

    fun getHeroes(): LiveData<List<HeroProgress>> {
        return allHeroesProgress
    }

    fun updateProgress(heroProgress: HeroProgress) {
        heroesDao.updateHeroProgress(heroProgress)
    }

    fun nukeProgress(){
        heroesDao.nukeTable()
    }

    fun insertHeroes(heroes:List<HeroProgress>){
        heroesDao.insertHeroProgress(heroes)
    }

}