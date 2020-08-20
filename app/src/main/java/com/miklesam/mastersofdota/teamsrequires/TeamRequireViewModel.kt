package com.miklesam.mastersofdota.teamsrequires

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.miklesam.mastersofdota.datamodels.roommodels.AbilityProgress
import com.miklesam.mastersofdota.playerupdate.AbilityUpdateRepository

class TeamRequireViewModel(application: Application) : AndroidViewModel(application) {
    private var repository: AbilityUpdateRepository = AbilityUpdateRepository(application)
    fun getAbilities(): LiveData<List<AbilityProgress>> {
        return repository.getAbilities()
    }
}