package com.miklesam.masterofdota.datamodels

import com.miklesam.masterofdota.R

enum class StreetView(val id: Int, val streetName: String, val streetImage: Int) {
    MSU(0, "msu", R.drawable.msu_view),
    CHINA(1, "china", R.drawable.china_view),
    ASIA(2, "asia", R.drawable.asia_view),
    LONDON(3, "london", R.drawable.london_view),
    TI(4, "TI view", R.drawable.ti_view),
    ITALY(5, "Italy", R.drawable.italy_view)

}