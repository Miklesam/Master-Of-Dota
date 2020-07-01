package com.miklesam.masterofdota

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.miklesam.masterofdota.adapters.HeroesAdapter
import com.miklesam.masterofdota.adapters.OnHeroListener
import kotlinx.android.synthetic.main.fragment_heroes_update.*

class FragmentHeroesUpdate :Fragment(R.layout.fragment_heroes_update), OnHeroListener {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerHeroes.layoutManager = LinearLayoutManager(context)
        recyclerHeroes?.setHasFixedSize(true)
        val adapter =
            HeroesAdapter(this)
        recyclerHeroes?.adapter = adapter
    }

    override fun onHeroClick(position: Int, holder: RecyclerView.ViewHolder) {
        //
    }
}