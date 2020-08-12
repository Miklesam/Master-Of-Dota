package com.miklesam.mastersofdota.adapters.settingsadapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.street_view_item.view.*

class StreetViewHolder(itemView: View, var heroListener: OnSettingsListener) :
    RecyclerView.ViewHolder(itemView), View.OnClickListener {
    override fun onClick(p0: View?) {
        heroListener.onStreetClick(adapterPosition)
    }

    val streetView: ImageView
    val chooseBttn: TextView


    init {
        streetView = itemView.streetView
        chooseBttn = itemView.chooseBttn
        //heroLateGame.setOnClickListener(this)
    }
}