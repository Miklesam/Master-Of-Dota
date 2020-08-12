package com.miklesam.mastersofdota.newgame

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.miklesam.mastersofdota.datamodels.roommodels.AbilityProgress
import com.miklesam.mastersofdota.datamodels.roommodels.HeroProgress
import com.miklesam.mastersofdota.heroupdate.HeroesUpdateRepository
import com.miklesam.mastersofdota.playerupdate.AbilityUpdateRepository

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