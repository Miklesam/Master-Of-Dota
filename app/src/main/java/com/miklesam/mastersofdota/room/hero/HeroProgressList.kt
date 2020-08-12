package com.miklesam.mastersofdota.room.hero

import com.miklesam.mastersofdota.datamodels.Heroes
import com.miklesam.mastersofdota.datamodels.roommodels.HeroProgress

class HeroProgressList {
    companion object {
        val AllHeroProgress =
            getAllBlankHeroProgress()


        private fun getAllBlankHeroProgress(): List<HeroProgress> {
            val listOfHeroes = ArrayList<HeroProgress>()
            for (hero in Heroes.values()) {
                listOfHeroes.add(
                    HeroProgress(
                        hero.id,
                        hero.heroName,
                        0
                    )
                )
            }
            return listOfHeroes
        }


    }
}