package com.miklesam.masterofdota.playerupdate

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.miklesam.masterofdota.R
import com.miklesam.masterofdota.adapters.HeroesAdapter
import com.miklesam.masterofdota.adapters.OnHeroListener
import com.miklesam.masterofdota.datamodels.HeroProgress
import kotlinx.android.synthetic.main.fragment_heroes_update.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class FragmentPlayerUpdate : Fragment(R.layout.fragment_player_update) {

    //private val updateViewModel: HeroUpdateViewModel by viewModels()
    private lateinit var updateHeroesList: List<HeroProgress>
    val scope = CoroutineScope(Dispatchers.IO + SupervisorJob())
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }


}