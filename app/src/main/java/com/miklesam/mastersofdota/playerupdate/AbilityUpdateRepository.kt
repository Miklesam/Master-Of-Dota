package com.miklesam.mastersofdota.playerupdate

import android.app.Application
import androidx.lifecycle.LiveData
import com.miklesam.mastersofdota.datamodels.roommodels.AbilityProgress
import com.miklesam.mastersofdota.room.ability.AbilityProgressDao
import com.miklesam.mastersofdota.room.ability.AbilityProgressDatabase

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