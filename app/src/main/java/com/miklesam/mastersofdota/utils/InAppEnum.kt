package com.miklesam.mastersofdota.utils

import com.miklesam.mastersofdota.R

enum class InAppEnum(
    val productId: String,
    val plusMoney: Int
) {
    BOX_OF_MONEY(
        "purchase_small_money",
        1000
    ),
    BIG_BOX_OF_MONEY(
        "purchase_big_money",
        3000
    )


}