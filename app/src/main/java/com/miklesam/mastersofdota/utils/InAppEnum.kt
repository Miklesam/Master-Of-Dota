package com.miklesam.mastersofdota.utils

import com.miklesam.mastersofdota.R

enum class InAppEnum(
    val productId: String,
    val plusMoney: Int,
    val image: Int,
    val id: Int
) {
    BAG_OF_COINS(
        "1_bag_of_coins",
        1000,
        R.drawable.coin_01d,
        0
    ),
    BIG_BAG_OF_COINS(
        "2_big_bag_of_coins",
        3000,
        R.drawable.coin_02d,
        1
    ),
    SMALL_BOX_OF_MONEY(
        "3_small_box_of_money",
        10000,
        R.drawable.coin_03d,
        2
    ),
    MIDDLE_BOX_OF_MONEY(
        "4_middle_box_of_money",
        25000,
        R.drawable.coin_04d,
        3
    ),
    BIG_BOX_OF_MONEY(
        "5_big_box_of_money",
        50000,
        R.drawable.coin_05d,
        4
    ),
    TREASURE(
        "6_treasure",
        100000,
        R.drawable.ingot_01d,
        5
    ),
    GREAT_TREASURE(
        "7_great_treasure",
        500000,
        R.drawable.gold_big,
        6
    )
}