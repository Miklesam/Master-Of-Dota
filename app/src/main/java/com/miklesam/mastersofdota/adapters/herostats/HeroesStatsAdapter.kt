package com.miklesam.mastersofdota.adapters.herostats

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.miklesam.mastersofdota.R
import com.miklesam.mastersofdota.datamodels.Heroes


class HeroesStatsAdapter(val heroListener: OnHeroStatsListener) : RecyclerView.Adapter<HeroStatsHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroStatsHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.hero_stats_item, parent, false)
        return HeroStatsHolder(
            itemView,
            heroListener
        )
    }

    override fun getItemCount(): Int {
        return Heroes.values().size
    }

    override fun onBindViewHolder(holder: HeroStatsHolder, position: Int) {
        val hero = Heroes.values()[position]
        holder.heroName.text = hero.heroName
        holder.heroIcon.setImageResource(hero.image_pick)

        holder.heroLaining.text = hero.laining.toString()
        holder.heroFighting.text = hero.fighting.toString()
        holder.heroLateGame.text = hero.lateGame.toString()
    }

}