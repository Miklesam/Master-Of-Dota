package com.miklesam.masterofdota.room.hero

import com.miklesam.masterofdota.datamodels.Heroes
import com.miklesam.masterofdota.datamodels.roommodels.HeroProgress

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