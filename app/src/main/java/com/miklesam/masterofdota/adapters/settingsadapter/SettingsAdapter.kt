package com.miklesam.masterofdota.adapters.settingsadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.miklesam.masterofdota.datamodels.Heroes
import com.miklesam.masterofdota.R
import com.miklesam.masterofdota.adapters.heroupdate.OnHeroListener
import com.miklesam.masterofdota.datamodels.StreetView
import com.miklesam.masterofdota.datamodels.roommodels.HeroProgress


class SettingsAdapter(
    val heroListener: OnHeroListener
) : RecyclerView.Adapter<StreetViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StreetViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.street_view_item, parent, false)
        return StreetViewHolder(
            itemView,
            heroListener
        )
    }

    override fun getItemCount(): Int {
        return StreetView.values().size
    }

    override fun onBindViewHolder(holder: StreetViewHolder, position: Int) {
        val streetView = StreetView.values()[position]
        //holder.heroName.text = hero.heroName
        //holder.heroIcon.setImageResource(hero.image_pick)
        //holder.heroProgress.progress = progressHeroesList?.get(position)?.progress ?: 0
        //holder.heroLateGame.text = hero.lateGame.toString()
        holder.streetView.setImageResource(streetView.streetImage)
    }


}