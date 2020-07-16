package com.miklesam.masterofdota.room.streetblocked

import com.miklesam.masterofdota.datamodels.StreetView
import com.miklesam.masterofdota.datamodels.roommodels.HeroProgress
import com.miklesam.masterofdota.datamodels.roommodels.StreetViewBlocked

class StreetViewList {
    companion object {
        val AllStreetView =
            getStartedStreetViewList()


        private fun getStartedStreetViewList(): List<StreetViewBlocked> {
            val listOfView = ArrayList<StreetViewBlocked>()
            for (streetView in StreetView.values()) {
                listOfView.add(
                    StreetViewBlocked(
                        streetView.id,
                        streetView.streetName,
                        (streetView.id == 0)
                    )
                )
            }
            return listOfView
        }


    }
}