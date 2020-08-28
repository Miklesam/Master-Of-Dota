package com.miklesam.mastersofdota

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.miklesam.mastersofdota.utils.ScreenState

class MainActivityViewModel : ViewModel() {

    val state = MutableLiveData<ScreenState>()

    init {
        state.value = ScreenState.MainScreenState
    }

    fun setState(newState: ScreenState) {
        state.value = newState
    }

    fun getCurrentState(): ScreenState {
        return state.value ?: ScreenState.MainScreenState
    }

}