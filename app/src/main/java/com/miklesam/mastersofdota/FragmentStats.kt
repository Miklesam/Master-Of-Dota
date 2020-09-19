package com.miklesam.mastersofdota

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.miklesam.mastersofdota.adapters.herostats.HeroesStatsAdapter
import com.miklesam.mastersofdota.adapters.herostats.OnHeroStatsListener
import kotlinx.android.synthetic.main.fragment_stats.*


class FragmentStats :Fragment(R.layout.fragment_stats),
    OnHeroStatsListener {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerHeroes.layoutManager = LinearLayoutManager(context)
        recyclerHeroes?.setHasFixedSize(true)
        val adapter =
            HeroesStatsAdapter(this)
        recyclerHeroes?.adapter = adapter
    }

    override fun onHeroClick(position: Int, holder: RecyclerView.ViewHolder) {
        //
    }
}