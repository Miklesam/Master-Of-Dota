package com.miklesam.masterofdota.heroupdate

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.miklesam.masterofdota.R
import com.miklesam.masterofdota.adapters.heroupdate.HeroesAdapter
import com.miklesam.masterofdota.adapters.heroupdate.OnHeroListener
import com.miklesam.masterofdota.datamodels.HeroProgress
import kotlinx.android.synthetic.main.fragment_heroes_update.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class FragmentHeroesUpdate : Fragment(R.layout.fragment_heroes_update),
    OnHeroListener {

    private val updateViewModel: HeroUpdateViewModel by viewModels()
    private lateinit var updateHeroesList: List<HeroProgress>
    val scope = CoroutineScope(Dispatchers.IO + SupervisorJob())
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerHeroes.layoutManager = LinearLayoutManager(context)
        recyclerHeroes?.setHasFixedSize(true)
        val adapter =
            HeroesAdapter(this)
        recyclerHeroes?.adapter = adapter


        updateViewModel.getHeroes().observe(viewLifecycleOwner, Observer {
            if (!it.isNullOrEmpty()) {
                updateHeroesList = it
                adapter.setProgressList(updateHeroesList)
                adapter.notifyDataSetChanged()
            }
        })
    }

    override fun onHeroClick(position: Int, holder: RecyclerView.ViewHolder) {
        Log.w("HeroUpdate", "plus")
        scope.launch {
            val hero = updateHeroesList[position]
            hero.progress++
            updateViewModel.updateHeroProgress(hero)
        }
    }
}