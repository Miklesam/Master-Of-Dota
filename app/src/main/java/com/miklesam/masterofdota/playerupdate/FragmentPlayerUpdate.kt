package com.miklesam.masterofdota.playerupdate

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.miklesam.masterofdota.R
import com.miklesam.masterofdota.adapters.abilityupdate.AbilityAdapter
import com.miklesam.masterofdota.adapters.abilityupdate.OnAbilityListener
import com.miklesam.masterofdota.adapters.heroupdate.HeroesAdapter
import com.miklesam.masterofdota.datamodels.HeroProgress
import kotlinx.android.synthetic.main.fragment_heroes_update.*
import kotlinx.android.synthetic.main.fragment_player_update.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

class FragmentPlayerUpdate : Fragment(R.layout.fragment_player_update),OnAbilityListener {

    //private val updateViewModel: HeroUpdateViewModel by viewModels()
    private lateinit var updateHeroesList: List<HeroProgress>
    val scope = CoroutineScope(Dispatchers.IO + SupervisorJob())
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerAbility.layoutManager = LinearLayoutManager(context)
        recyclerAbility?.setHasFixedSize(true)
        val adapter =
            AbilityAdapter(this)
        recyclerAbility?.adapter = adapter


    }

    override fun onAbilityClick(position: Int, holder: RecyclerView.ViewHolder) {
        TODO("Not yet implemented")
    }


}