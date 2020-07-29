package com.miklesam.masterofdota.settingsview

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.miklesam.masterofdota.datamodels.roommodels.HeroProgress
import com.miklesam.masterofdota.datamodels.roommodels.StreetViewBlocked

class ViewSettingsViewModel(application: Application) : AndroidViewModel(application) {
    private var repository: ViewSettingsRepository = ViewSettingsRepository(application)
    fun getViews(): LiveData<List<StreetViewBlocked>> {
        return repository.getStreetView()
    }

    fun nukeProgress() {
        repository.nukeProgress()
    }

    fun updateStreetView(street: StreetViewBlocked) {
        repository.updateStreetView(street)
    }

}