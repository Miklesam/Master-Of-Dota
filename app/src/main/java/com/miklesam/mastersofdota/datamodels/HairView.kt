package com.miklesam.mastersofdota.datamodels

import com.miklesam.mastersofdota.R

enum class HairView(
    val id: Int,
    val hairName: String,
    val hairImage: Int,
    val price: Int,
    val hairImageUp: Int,
    val headIma: Int
) {
    BLUE(0, "blue", R.drawable.hair, 0, R.drawable.hair_up,R.drawable.blue),
    YELLOW(1, "yellow", R.drawable.hair_yellow, 55, R.drawable.hair_yellow_up,R.drawable.yellow),
    GREEN(2, "green", R.drawable.hair_green, 150, R.drawable.hair_green_up,R.drawable.green),
    PURPLE(3, "purple", R.drawable.hair_purpal, 1400, R.drawable.hair_purpal_up,R.drawable.purple),
    COLD(4, "cold", R.drawable.hair_cold, 500, R.drawable.hair_cold_up,R.drawable.cold),
    PINK(5, "pink", R.drawable.hair_pink, 5000, R.drawable.hair_pink_up,R.drawable.pink),
    RED(6, "red", R.drawable.hair_red, 10000, R.drawable.hair_red_up,R.drawable.red),
    ORANGE(7, "orange", R.drawable.hair_orange, 50000, R.drawable.hair_orange_up,R.drawable.orange)
}