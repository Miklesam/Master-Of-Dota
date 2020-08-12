package com.miklesam.mastersofdota.pickstage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.miklesam.mastersofdota.datamodels.Heroes
import kotlinx.coroutines.*

class PickStageViewModel : ViewModel() {
    private val allBans = MutableLiveData<ArrayList<Heroes>>()
    private val allPicks = MutableLiveData<ArrayList<Heroes>>()
    private val playerBan = MutableLiveData<Int>()
    private val playerPick = MutableLiveData<Int>()
    private val pickNow = MutableLiveData<Boolean>()
    private val pickEnded = MutableLiveData<Boolean>()
    fun getBansArray(): LiveData<ArrayList<Heroes>> = allBans
    fun getPicksArray(): LiveData<ArrayList<Heroes>> = allPicks
    fun getPlayerBan(): LiveData<Int> = playerBan
    fun getPlayerPick(): LiveData<Int> = playerPick
    fun getPickStage(): LiveData<Boolean> = pickNow
    fun getPickEnd(): LiveData<Boolean> = pickEnded
    val scope = CoroutineScope(Dispatchers.IO + SupervisorJob())
    val arrayHero = Heroes.values().toMutableList()
    var generateBansEnded = false
    var yourBanEnded = false
    var generatePicksEnded = false
    var yourPickEnded = false

    init {
        pickNow.value = false
        generateBotBans()
    }

    private fun generateBotBans() {
        scope.launch {
            for (i in 0 until 11) {
                val rnds = (0 until arrayHero.size).random()
                val what = arrayHero[rnds]
                var currentList = allBans.value
                if (currentList == null) {
                    currentList = ArrayList<Heroes>()
                }
                currentList.add(what)
                allBans.postValue(currentList)
                arrayHero.remove(what)
                delay(500)
            }
            generateBansEnded = true
            withContext(Dispatchers.Main) {
                checkStage()
            }
        }
    }

    private fun generateBotPicks() {
        scope.launch {
            for (i in 0 until 9) {
                val rnds = (0 until arrayHero.size).random()
                val what = arrayHero[rnds]
                var currentList = allPicks.value
                if (currentList == null) {
                    currentList = ArrayList<Heroes>()
                }
                currentList.add(what)
                allPicks.postValue(currentList)
                arrayHero.remove(what)
                delay(500)
            }
            generatePicksEnded = true
            withContext(Dispatchers.Main) {
                checkPickEnded()
            }
        }
    }


    fun myChoose(heroId: Int, callback: PickCallback) {
        val pickStage = pickNow.value ?: false
        if (pickStage && !yourPickEnded) {
            if (arrayHero.contains(Heroes.values().find { it.id == heroId })) {
                val chooseHero = Heroes.values().find { it.id == heroId }
                arrayHero.remove(chooseHero)
                playerPick.value = heroId
                yourPickEnded = true
                checkPickEnded()
            } else {
                callback.onError()
            }
        } else {
            if (!yourBanEnded) {
                if (arrayHero.contains(Heroes.values().find { it.id == heroId })) {
                    val chooseHero = Heroes.values().find { it.id == heroId }
                    arrayHero.remove(chooseHero)
                    playerBan.value = heroId
                    yourBanEnded = true
                    checkStage()
                } else {
                    callback.onError()
                }
            }
        }

    }

    private fun checkStage() {
        if (generateBansEnded && yourBanEnded) {
            pickNow.value = true
            generateBotPicks()
        }
    }

    private fun checkPickEnded() {
        if (generatePicksEnded && yourPickEnded) {
            pickEnded.value = true
        }
    }

    override fun onCleared() {
        scope.cancel()
        super.onCleared()
    }
}