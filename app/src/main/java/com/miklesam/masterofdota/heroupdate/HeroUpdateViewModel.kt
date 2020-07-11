package com.miklesam.masterofdota.heroupdate

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.miklesam.masterofdota.datamodels.roommodels.HeroProgress

class HeroUpdateViewModel(application: Application) : AndroidViewModel(application) {
    private var repository: HeroesUpdateRepository = HeroesUpdateRepository(application)
    fun getHeroes(): LiveData<List<HeroProgress>> {
        return repository.getHeroes()
    }

    fun updateHeroProgress(heroProgress: HeroProgress) {
        repository.updateProgress(heroProgress)
    }

    fun nukeProgress() {
        repository.nukeProgress()
    }

    fun initNewProgress(heroes:List<HeroProgress>) {
        repository.insertHeroes(heroes)
    }
}