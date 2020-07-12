package com.miklesam.masterofdota

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.miklesam.masterofdota.adapters.heroupdate.HeroesAdapter
import com.miklesam.masterofdota.adapters.heroupdate.OnHeroListener
import com.miklesam.masterofdota.adapters.settingsadapter.SettingsAdapter
import kotlinx.android.synthetic.main.fragment_settings.*

class FragmentSettings : Fragment(R.layout.fragment_settings), OnHeroListener {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerStreetView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerStreetView?.setHasFixedSize(true)
        val adapter =
            SettingsAdapter(this)
        recyclerStreetView?.adapter = adapter

    }

    override fun onHeroClick(position: Int, holder: RecyclerView.ViewHolder) {
        TODO("Not yet implemented")
    }

}