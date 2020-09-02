package com.miklesam.mastersofdota.settingsview

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.miklesam.mastersofdota.datamodels.roommodels.HairViewBlocked
import com.miklesam.mastersofdota.datamodels.roommodels.StreetViewBlocked

class ViewSettingsViewModel(application: Application) : AndroidViewModel(application) {
    private var repository: ViewSettingsRepository = ViewSettingsRepository(application)
    private var repositoryHair: HairSettingsRepository = HairSettingsRepository(application)
    fun getStreetViews(): LiveData<List<StreetViewBlocked>> {
        return repository.getStreetView()
    }

    fun getHairViews(): LiveData<List<HairViewBlocked>> {
        return repositoryHair.getHairView()
    }

    fun nukeProgress() {
        repository.nukeProgress()
    }

    fun updateStreetView(street: StreetViewBlocked) {
        repository.updateStreetView(street)
    }

    fun updateHairView(hair: HairViewBlocked) {
        repositoryHair.updateHairView(hair)
    }

}