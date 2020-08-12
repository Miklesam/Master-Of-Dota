package com.miklesam.mastersofdota.adapters.abilityupdate

import androidx.recyclerview.widget.RecyclerView

interface OnAbilityListener {
    fun onAbilityClick(position: Int,holder:RecyclerView.ViewHolder)
}