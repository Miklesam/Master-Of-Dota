package com.miklesam.masterofdota.playerupdate

import android.app.Application
import androidx.lifecycle.LiveData
import com.miklesam.masterofdota.datamodels.roommodels.AbilityProgress
import com.miklesam.masterofdota.datamodels.roommodels.HeroProgress
import com.miklesam.masterofdota.room.hero.HeroProgressDao
import com.miklesam.masterofdota.room.HeroProgressDatabase
import com.miklesam.masterofdota.room.ability.AbilityProgressDao
import com.miklesam.masterofdota.room.ability.AbilityProgressDatabase

class AbilityUpdateRepository(application: Application) {
    private var abilityDao: AbilityProgressDao
    private var allAbilityProgress: LiveData<List<AbilityProgress>>

    init {
        val database: AbilityProgressDatabase =
            AbilityProgressDatabase.getInstance(application.applicationContext)
        abilityDao = database.noteDao()
        allAbilityProgress = abilityDao.getAllAbilities()
    }

    fun getAbilities(): LiveData<List<AbilityProgress>> {
        return allAbilityProgress
    }

    fun updateProgress(abilityProgress: AbilityProgress) {
        abilityDao.updateAbilityProgress(abilityProgress)
    }

    fun nukeProgress() {
        abilityDao.nukeTable()
    }

    fun insertAbilities(abilities: List<AbilityProgress>) {
        abilityDao.insertAbilityProgress(abilities)
    }

}