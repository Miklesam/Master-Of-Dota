package com.miklesam.masterofdota.room

import com.miklesam.masterofdota.Heroes
import com.miklesam.masterofdota.datamodels.HeroProgress

class HeroProgressList {
    companion object {
        const val CATEGORY_IMAGE_DIR = "android.resource://com.miklesam.dotamanager/drawable/"
        val AllHeroProgress =
            getAllBlankHeroProgress()


        private fun getAllBlankHeroProgress(): List<HeroProgress> {
            val listOfHeroes = ArrayList<HeroProgress>()
            for (hero in Heroes.values()) {
                listOfHeroes.add(HeroProgress(hero.id, hero.heroName, 0))
            }
            return listOfHeroes
        }


    }
}