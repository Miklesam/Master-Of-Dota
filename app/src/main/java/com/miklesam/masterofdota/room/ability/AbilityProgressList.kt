package com.miklesam.masterofdota.room.ability

import com.miklesam.masterofdota.datamodels.PersonalAbility
import com.miklesam.masterofdota.datamodels.roommodels.AbilityProgress

class AbilityProgressList {
    companion object {
        val AllAbilityProgress =
            getAllBlankAbilityProgress()


        private fun getAllBlankAbilityProgress(): List<AbilityProgress> {
            val listOfHeroes = ArrayList<AbilityProgress>()
            for (ability in PersonalAbility.values()) {
                listOfHeroes.add(
                    AbilityProgress(
                        ability.id,
                        ability.nameAbility,
                        0
                    )
                )
            }
            return listOfHeroes
        }


    }
}