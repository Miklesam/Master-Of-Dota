package com.miklesam.mastersofdota.adapters.proteams

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.daimajia.numberprogressbar.NumberProgressBar
import kotlinx.android.synthetic.main.hero_item.view.*
import kotlinx.android.synthetic.main.hero_item.view.heroIcon
import kotlinx.android.synthetic.main.hero_item.view.heroName
import kotlinx.android.synthetic.main.proteam_item.view.*

class ProTeamsHolder(itemView: View, var heroListener: OnProTeamsListener) :
    RecyclerView.ViewHolder(itemView), View.OnClickListener {
    override fun onClick(p0: View?) {
        heroListener.onHeroClick(adapterPosition)
    }

    val heroIcon: ImageView
    val heroName: TextView
    val salaryCount : TextView
    val full : CardView

    init {
        heroIcon = itemView.heroIcon
        heroName = itemView.heroName
        salaryCount=itemView.salaryCount
        full=itemView.full
        full.setOnClickListener(this)
        //heroLateGame.setOnClickListener(this)
    }
}