package com.miklesam.mastersofdota.adapters.herostats

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.hero_stats_item.view.*

class HeroStatsHolder(itemView: View, var heroListener: OnHeroStatsListener) :
    RecyclerView.ViewHolder(itemView), View.OnClickListener {
    override fun onClick(p0: View?) {
        heroListener.onHeroClick((adapterPosition), this)
    }

    val heroIcon: ImageView
    val heroName: TextView

    val heroLaining: TextView
    val heroFighting: TextView
    val heroLateGame: TextView

    init {
        heroIcon = itemView.heroIcon
        heroName = itemView.heroName
        heroLaining = itemView.heroLaining
        heroFighting = itemView.heroFighting
        heroLateGame = itemView.heroLateGame

        itemView.setOnClickListener(this)
    }
}