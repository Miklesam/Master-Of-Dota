package com.miklesam.mastersofdota.adapters.herostats

import androidx.recyclerview.widget.RecyclerView

interface OnHeroStatsListener {
    fun onHeroClick(position: Int,holder:RecyclerView.ViewHolder)
}