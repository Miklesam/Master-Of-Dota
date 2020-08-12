package com.miklesam.mastersofdota.playerupdate

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.miklesam.mastersofdota.datamodels.roommodels.AbilityProgress

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