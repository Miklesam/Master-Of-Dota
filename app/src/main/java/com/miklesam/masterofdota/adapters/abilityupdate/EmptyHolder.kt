package com.miklesam.masterofdota.adapters.abilityupdate

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.empty_item.view.*

class EmptyHolder(itemView: View) :
    RecyclerView.ViewHolder(itemView) {
    val abilityTitle: TextView

    init {
        abilityTitle = itemView.emptyText
    }

}