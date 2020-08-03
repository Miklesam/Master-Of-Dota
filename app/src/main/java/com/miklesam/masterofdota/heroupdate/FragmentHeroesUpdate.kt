package com.miklesam.masterofdota.heroupdate

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.miklesam.masterofdota.R
import com.miklesam.masterofdota.adapters.heroupdate.HeroesAdapter
import com.miklesam.masterofdota.adapters.heroupdate.OnHeroListener
import com.miklesam.masterofdota.datamodels.roommodels.HeroProgress
import com.miklesam.masterofdota.utils.PrefsHelper
import com.miklesam.masterofdota.utils.showCustomToast
import kotlinx.android.synthetic.main.fragment_heroes_update.*
import kotlinx.coroutines.*

class FragmentHeroesUpdate : Fragment(R.layout.fragment_heroes_update),
    OnHeroListener {

    private val updateViewModel: HeroUpdateViewModel by viewModels()
    private lateinit var updateHeroesList: List<HeroProgress>
    val scope = CoroutineScope(Dispatchers.IO + SupervisorJob())
    private var currentXP = 0
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerHeroes.layoutManager = LinearLayoutManager(context)
        recyclerHeroes?.setHasFixedSize(true)
        val adapter =
            HeroesAdapter(this)
        recyclerHeroes?.adapter = adapter
        updateXP()


        updateViewModel.getHeroes().observe(viewLifecycleOwner, Observer {
            if (!it.isNullOrEmpty()) {
                updateHeroesList = it
                adapter.setProgressList(updateHeroesList)
                adapter.notifyDataSetChanged()
            }
        })
    }


    private fun updateXP() {
        currentXP = PrefsHelper.read(
            PrefsHelper.XP, "0"
        )?.toInt() ?: 0
        val xpString = "XP: $currentXP"
        xp_update.text = xpString
    }

    override fun onHeroClick(position: Int, holder: RecyclerView.ViewHolder) {
        Log.w("HeroUpdate", "plus")
        if (currentXP > 0) {
            scope.launch {
                if (updateHeroesList[position].progress < 100) {
                    val hero = updateHeroesList[position]
                    hero.progress++
                    updateViewModel.updateHeroProgress(hero)
                    withContext(Dispatchers.Main) {
                        PrefsHelper.write(PrefsHelper.XP, (currentXP - 1).toString())
                        updateXP()
                    }
                } else {
                    withContext(Dispatchers.Main) {
                        showCustomToast("Hero progress is max", Toast.LENGTH_SHORT)
                    }

                }
            }
        } else {
            showCustomToast("Not enough XP", Toast.LENGTH_SHORT)
        }

    }
}