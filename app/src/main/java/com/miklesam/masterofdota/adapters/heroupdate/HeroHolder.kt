package com.miklesam.masterofdota.adapters.heroupdate

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.daimajia.numberprogressbar.NumberProgressBar
import com.miklesam.masterofdota.adapters.heroupdate.OnHeroListener
import kotlinx.android.synthetic.main.hero_item.view.*

class HeroHolder(itemView: View, var heroListener: OnHeroListener) :
    RecyclerView.ViewHolder(itemView), View.OnClickListener {
    override fun onClick(p0: View?) {
        heroListener.onHeroClick((adapterPosition), this)
    }

    val heroIcon: ImageView
    val heroName: TextView

    val heroProgress: NumberProgressBar
    val heroLateGame: TextView

    init {
        heroIcon = itemView.heroIcon
        heroName = itemView.heroName
        heroProgress = itemView.progress_hero
        heroLateGame = itemView.heroLateGame

        heroLateGame.setOnClickListener(this)
    }
}