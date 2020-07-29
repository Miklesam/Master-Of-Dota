package com.miklesam.masterofdota.settingsview

import android.app.Application
import androidx.lifecycle.LiveData
import com.miklesam.masterofdota.datamodels.StreetView
import com.miklesam.masterofdota.datamodels.roommodels.HeroProgress
import com.miklesam.masterofdota.datamodels.roommodels.StreetViewBlocked
import com.miklesam.masterofdota.room.hero.HeroProgressDao
import com.miklesam.masterofdota.room.hero.HeroProgressDatabase
import com.miklesam.masterofdota.room.streetblocked.StreetBlockedDao
import com.miklesam.masterofdota.room.streetblocked.StreetBlockedDatabase

class ViewSettingsRepository(application: Application) {
    private var streetDao: StreetBlockedDao
    private var allStreetBlocked: LiveData<List<StreetViewBlocked>>

    init {
        val database: StreetBlockedDatabase =
            StreetBlockedDatabase.getInstance(application.applicationContext)
        streetDao = database.noteDao()
        allStreetBlocked = streetDao.getAllStreetBlocked()
    }

    fun getStreetView(): LiveData<List<StreetViewBlocked>> {
        return allStreetBlocked
    }

    fun nukeProgress() {
        streetDao.nukeTable()
    }

    fun updateStreetView(streetView: StreetViewBlocked) {
        streetDao.updateStreetBlocked(streetView)
    }

}