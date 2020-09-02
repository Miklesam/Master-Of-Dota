package com.miklesam.mastersofdota.room.hairblocked

import com.miklesam.mastersofdota.datamodels.HairView
import com.miklesam.mastersofdota.datamodels.StreetView
import com.miklesam.mastersofdota.datamodels.roommodels.HairViewBlocked
import com.miklesam.mastersofdota.datamodels.roommodels.StreetViewBlocked

class HairViewList {
    companion object {
        val AllHairView =
            getStartedHairViewList()


        private fun getStartedHairViewList(): List<HairViewBlocked> {
            val listOfView = ArrayList<HairViewBlocked>()
            for (hairView in HairView.values()) {
                listOfView.add(
                    HairViewBlocked(
                        hairView.id,
                        hairView.hairName,
                        (hairView.id == 0)
                    )
                )
            }
            return listOfView
        }


    }
}