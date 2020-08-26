package com.miklesam.mastersofdota.datamodels

import com.miklesam.mastersofdota.R

enum class StreetView(val id: Int, val streetName: String, val streetImage: Int, val price: Int) {
    MSU(0, "msu", R.drawable.msu_view, 0),
    CHINA(1, "china", R.drawable.china_view, 0),
    ASIA(2, "asia", R.drawable.asia_view, 1000),
    LONDON(3, "london", R.drawable.london_view, 5000),
    TI(4, "TI view", R.drawable.ti_view, 50000),
    ITALY(5, "Italy", R.drawable.italy_view, 10000)

}