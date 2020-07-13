package com.miklesam.masterofdota.adapters.settingsadapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.daimajia.numberprogressbar.NumberProgressBar
import com.miklesam.masterofdota.adapters.heroupdate.OnHeroListener
import kotlinx.android.synthetic.main.hero_item.view.*
import kotlinx.android.synthetic.main.street_view_item.view.*

class StreetViewHolder(itemView: View, var heroListener: OnHeroListener) :
    RecyclerView.ViewHolder(itemView), View.OnClickListener {
    override fun onClick(p0: View?) {
        heroListener.onHeroClick((adapterPosition), this)
    }

    val streetView: ImageView
    val chooseBttn: TextView


    init {
        streetView = itemView.streetView
        chooseBttn=itemView.chooseBttn
        //heroLateGame.setOnClickListener(this)
    }
}