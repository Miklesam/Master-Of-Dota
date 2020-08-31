package com.miklesam.mastersofdota.datamodels

import com.miklesam.mastersofdota.R

enum class HairView(val id: Int, val hairName: String, val hairImage: Int, val price: Int) {
    BLUE(0, "blue", R.drawable.hair, 0),
    YELLOW(1, "yellow", R.drawable.hair_yellow, 10)

}