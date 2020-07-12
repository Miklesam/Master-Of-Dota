package com.miklesam.masterofdota.playerupdate

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.miklesam.masterofdota.datamodels.roommodels.AbilityProgress
import com.miklesam.masterofdota.datamodels.roommodels.HeroProgress

class AbilityUpdateViewModel(application: Application) : AndroidViewModel(application) {
    private var repository: AbilityUpdateRepository = AbilityUpdateRepository(application)
    fun getAbilities(): LiveData<List<AbilityProgress>> {
        return repository.getAbilities()
    }

    fun updateAbilityProgress(abilityProgress: AbilityProgress) {
        repository.updateProgress(abilityProgress)
    }

    fun nukeProgress() {
        repository.nukeProgress()
    }

    fun initNewProgress(abilities:List<AbilityProgress>) {
        repository.insertAbilities(abilities)
    }
}