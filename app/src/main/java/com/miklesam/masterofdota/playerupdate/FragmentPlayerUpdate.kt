package com.miklesam.masterofdota.playerupdate

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.miklesam.masterofdota.R
import com.miklesam.masterofdota.adapters.abilityupdate.AbilityAdapter
import com.miklesam.masterofdota.adapters.abilityupdate.OnAbilityListener
import com.miklesam.masterofdota.datamodels.PersonalAbility
import com.miklesam.masterofdota.datamodels.roommodels.AbilityProgress
import com.miklesam.masterofdota.datamodels.roommodels.HeroProgress
import com.miklesam.masterofdota.heroupdate.HeroUpdateViewModel
import com.miklesam.masterofdota.utils.PrefsHelper
import com.miklesam.masterofdota.utils.showCustomToast
import kotlinx.android.synthetic.main.fragment_heroes_update.*
import kotlinx.android.synthetic.main.fragment_player_update.*
import kotlinx.android.synthetic.main.fragment_player_update.xp_update
import kotlinx.coroutines.*

class FragmentPlayerUpdate : Fragment(R.layout.fragment_player_update), OnAbilityListener {

    private val updateViewModel: AbilityUpdateViewModel by viewModels()
    private lateinit var updateAbilitiesList: List<AbilityProgress>
    val scope = CoroutineScope(Dispatchers.IO + SupervisorJob())
    private var currentXP = 0
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerAbility.layoutManager = LinearLayoutManager(context)
        recyclerAbility?.setHasFixedSize(true)
        val adapter =
            AbilityAdapter(this)
        recyclerAbility?.adapter = adapter

        updateXP()

        updateViewModel.getAbilities().observe(viewLifecycleOwner, Observer {
            if (!it.isNullOrEmpty()) {
                updateAbilitiesList = it
                adapter.setProgressList(updateAbilitiesList)
                adapter.notifyDataSetChanged()
            }
        })


    }

    override fun onAbilityClick(position: Int, holder: RecyclerView.ViewHolder) {

        if (currentXP > 0) {
            val posUpdate = if (position > 13) {
                position - 3
            } else if (position > 6) {
                position - 2
            } else {
                position - 1
            }
            scope.launch {
                if (updateAbilitiesList[posUpdate].progress < 100) {
                    val ability = updateAbilitiesList[posUpdate]
                    ability.progress++
                    updateViewModel.updateAbilityProgress(ability)
                    withContext(Dispatchers.Main) {
                        PrefsHelper.write(PrefsHelper.XP, (currentXP - 1).toString())
                        updateXP()
                    }
                } else {
                    withContext(Dispatchers.Main) {
                        showCustomToast("Ability progress is max", Toast.LENGTH_SHORT)
                    }
                }

            }
        } else {
            showCustomToast("Not enough XP", Toast.LENGTH_SHORT)
        }

    }

    private fun updateXP() {
        currentXP = PrefsHelper.read(
            PrefsHelper.XP, "0"
        )?.toInt() ?: 0
        val xpString = "XP: $currentXP"
        xp_update.text = xpString
    }


}