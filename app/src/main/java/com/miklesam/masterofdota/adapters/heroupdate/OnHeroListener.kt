package com.miklesam.masterofdota.adapters.heroupdate

import androidx.recyclerview.widget.RecyclerView

interface OnHeroListener {
    fun onHeroClick(position: Int,holder:RecyclerView.ViewHolder)
}