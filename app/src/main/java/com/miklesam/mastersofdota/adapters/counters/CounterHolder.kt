package com.miklesam.mastersofdota.adapters.counters

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.daimajia.numberprogressbar.NumberProgressBar
import com.miklesam.mastersofdota.adapters.heroupdate.OnHeroListener
import kotlinx.android.synthetic.main.hero_item.view.*

class CounterHolder(itemView: View, var heroListener: OnCounterListener) :
    RecyclerView.ViewHolder(itemView), View.OnClickListener {
    override fun onClick(p0: View?) {
        heroListener.onCounterClick((adapterPosition))
    }

    val heroIcon: ImageView
    val heroName: TextView

    init {
        heroIcon = itemView.heroIcon
        heroName = itemView.heroName
        itemView.setOnClickListener(this)
    }
}