package com.miklesam.mastersofdota.settingsview

import android.app.Application
import androidx.lifecycle.LiveData
import com.miklesam.mastersofdota.datamodels.roommodels.StreetViewBlocked
import com.miklesam.mastersofdota.room.streetblocked.StreetBlockedDao
import com.miklesam.mastersofdota.room.streetblocked.StreetBlockedDatabase

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