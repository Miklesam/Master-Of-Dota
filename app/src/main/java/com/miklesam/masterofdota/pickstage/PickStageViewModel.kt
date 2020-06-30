package com.miklesam.masterofdota.pickstage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.miklesam.masterofdota.Heroes
import kotlinx.android.synthetic.main.fragment_pick_stage.*
import kotlinx.coroutines.*

class PickStageViewModel : ViewModel() {
    private val allBans = MutableLiveData<ArrayList<Heroes>>()
    fun getBansArray(): LiveData<ArrayList<Heroes>> = allBans
    val scope = CoroutineScope(Dispatchers.IO + SupervisorJob())
    val arrayHero = Heroes.values().toMutableList()

    init {
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
                //Heros_icon[what.id]?.setImageResource(what!!.largeBan)
                //Ban_stage[pick_state]?.setImageResource(what!!.minBan)
                arrayHero.remove(what)
                //pick_state++
                delay(500)
            }
        }
    }

    fun myChoose(heroId: Int, callback: PickCallback) {
        callback.onError()
    }

}