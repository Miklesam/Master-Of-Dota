package com.miklesam.masterofdota.newgame

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.miklesam.masterofdota.datamodels.roommodels.AbilityProgress
import com.miklesam.masterofdota.datamodels.roommodels.HeroProgress
import com.miklesam.masterofdota.heroupdate.HeroesUpdateRepository
import com.miklesam.masterofdota.playerupdate.AbilityUpdateRepository

class NewGameViewModel(application: Application) : AndroidViewModel(application) {
    private var repositoryHeroes = HeroesUpdateRepository(application)
    private var repositoryAbility = AbilityUpdateRepository(application)
    fun nukeHeroesProgress() {
        repositoryHeroes.nukeProgress()
    }

    fun initNewHeroesProgress(heroes: List<HeroProgress>) {
        repositoryHeroes.insertHeroes(heroes)
    }

    fun nukeAbilityProgress() {
        repositoryAbility.nukeProgress()
    }

    fun initNewAbilityProgress(abilities: List<AbilityProgress>) {
        repositoryAbility.insertAbilities(abilities)
    }

}