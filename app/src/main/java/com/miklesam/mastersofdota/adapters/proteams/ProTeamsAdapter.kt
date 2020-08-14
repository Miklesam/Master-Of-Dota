package com.miklesam.mastersofdota.adapters.proteams

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.miklesam.mastersofdota.datamodels.Heroes
import com.miklesam.mastersofdota.R
import com.miklesam.mastersofdota.datamodels.ProTeamsEnum
import com.miklesam.mastersofdota.datamodels.roommodels.HeroProgress


class ProTeamsAdapter(
    val heroListener: OnProTeamsListener
) : RecyclerView.Adapter<ProTeamsHolder>() {

    var progressHeroesList: List<HeroProgress>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProTeamsHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.proteam_item, parent, false)
        return ProTeamsHolder(
            itemView,
            heroListener
        )
    }

    override fun getItemCount(): Int {
        return ProTeamsEnum.values().size
    }

    override fun onBindViewHolder(holder: ProTeamsHolder, position: Int) {
        val team = ProTeamsEnum.values()[position]
        holder.heroName.text = team.teamName
        holder.heroIcon.setImageResource(team.teamLogo)
        //holder.heroProgress.progress = progressHeroesList?.get(position)?.progress ?: 0
        //holder.heroLateGame.text = hero.lateGame.toString()
    }

    fun setProgressList(heroes: List<HeroProgress>) {
        progressHeroesList = heroes
    }

}