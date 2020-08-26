package com.miklesam.mastersofdota.adapters.counters

import androidx.recyclerview.widget.RecyclerView

interface OnCounterListener {
    fun onCounterClick(position: Int)
}