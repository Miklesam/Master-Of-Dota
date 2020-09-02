package com.miklesam.mastersofdota.settingsview

import android.app.Application
import androidx.lifecycle.LiveData
import com.miklesam.mastersofdota.datamodels.roommodels.HairViewBlocked
import com.miklesam.mastersofdota.datamodels.roommodels.StreetViewBlocked
import com.miklesam.mastersofdota.room.hairblocked.HairBlockedDao
import com.miklesam.mastersofdota.room.hairblocked.HairBlockedDatabase
import com.miklesam.mastersofdota.room.streetblocked.StreetBlockedDao
import com.miklesam.mastersofdota.room.streetblocked.StreetBlockedDatabase

class HairSettingsRepository(application: Application) {
    private var hairDao: HairBlockedDao
    private var allHairBlocked: LiveData<List<HairViewBlocked>>

    init {
        val database: HairBlockedDatabase =
            HairBlockedDatabase.getInstance(application.applicationContext)
        hairDao = database.noteDao()
        allHairBlocked = hairDao.getAllHairBlocked()
    }

    fun getHairView(): LiveData<List<HairViewBlocked>> {
        return allHairBlocked
    }

    fun nukeProgress() {
        hairDao.nukeTable()
    }

    fun updateHairView(streetView: HairViewBlocked) {
        hairDao.updateHairBlocked(streetView)
    }

}