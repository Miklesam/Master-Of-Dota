package com.miklesam.masterofdota.adapters

import androidx.recyclerview.widget.RecyclerView

interface OnHeroListener {
    fun onHeroClick(position: Int,holder:RecyclerView.ViewHolder)
}