package com.miklesam.masterofdota.heroupdate

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.miklesam.masterofdota.Heroes
import com.miklesam.masterofdota.datamodels.HeroProgress
import kotlinx.android.synthetic.main.fragment_pick_stage.*
import kotlinx.coroutines.*

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