package com.miklesam.mastersofdota.adapters.counters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.miklesam.mastersofdota.datamodels.Heroes
import com.miklesam.mastersofdota.R
import com.miklesam.mastersofdota.adapters.heroupdate.HeroHolder
import com.miklesam.mastersofdota.adapters.heroupdate.OnHeroListener
import com.miklesam.mastersofdota.datamodels.roommodels.HeroProgress


class CountersAdapter(
    val heroListener: OnCounterListener
) : RecyclerView.Adapter<CounterHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CounterHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.counter_item, parent, false)
        return CounterHolder(
            itemView,
            heroListener
        )
    }

    override fun getItemCount(): Int {
        return Heroes.values().size
    }

    override fun onBindViewHolder(holder: CounterHolder, position: Int) {
        val hero = Heroes.values()[position]
        holder.heroName.text = hero.heroName
        holder.heroIcon.setImageResource(hero.image_pick)
    }

}