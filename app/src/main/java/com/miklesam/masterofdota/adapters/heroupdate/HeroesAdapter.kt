package com.miklesam.masterofdota.adapters.heroupdate

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.miklesam.masterofdota.Heroes
import com.miklesam.masterofdota.R
import com.miklesam.masterofdota.datamodels.HeroProgress


class HeroesAdapter(
    val heroListener: OnHeroListener
) : RecyclerView.Adapter<HeroHolder>() {

    var progressHeroesList: List<HeroProgress>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.hero_item, parent, false)
        return HeroHolder(
            itemView,
            heroListener
        )
    }

    override fun getItemCount(): Int {
        return Heroes.values().size
    }

    override fun onBindViewHolder(holder: HeroHolder, position: Int) {
        val hero = Heroes.values()[position]
        holder.heroName.text = hero.heroName
        holder.heroIcon.setImageResource(hero.image_pick)
        holder.heroProgress.progress = progressHeroesList?.get(position)?.progress ?: 0
        //holder.heroLateGame.text = hero.lateGame.toString()
    }

    fun setProgressList(heroes: List<HeroProgress>) {
        progressHeroesList = heroes
    }

}