package com.miklesam.mastersofdota.room.ability

import com.miklesam.mastersofdota.datamodels.PersonalAbility
import com.miklesam.mastersofdota.datamodels.roommodels.AbilityProgress

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