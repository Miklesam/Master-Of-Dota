package com.miklesam.mastersofdota.adapters.hairadapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.street_view_item.view.*

class HairViewHolder(itemView: View, var heroListener: OnHairsListener) :
    RecyclerView.ViewHolder(itemView), View.OnClickListener {
    override fun onClick(p0: View?) {
        heroListener.onHairClick(adapterPosition)
    }

    val streetView: ImageView
    val chooseBttn: TextView


    init {
        streetView = itemView.streetView
        chooseBttn = itemView.chooseBttn
        //heroLateGame.setOnClickListener(this)
    }
}