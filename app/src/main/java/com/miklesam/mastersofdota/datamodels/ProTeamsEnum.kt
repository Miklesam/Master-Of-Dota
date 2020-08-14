package com.miklesam.mastersofdota.datamodels

import com.miklesam.mastersofdota.R

enum class ProTeamsEnum(
    val id: Int,
    val teamName: String,
    val teamLogo: Int,
    val requires: ArrayList<Pair<PersonalAbility, Int>>
) {
    VIRTUSPRO(
        0,
        "Virtus Pro",
        R.drawable.vp,
        arrayListOf(
            Pair(PersonalAbility.MACRO_CONTROL, 15),
            Pair(PersonalAbility.MICRO_CONTROL, 25)
        )
    ),
    NAVI(1, "Navi", R.drawable.navi, arrayListOf(Pair(PersonalAbility.MACRO_CONTROL, 15))),
    GAMBIT(
        2,
        "Gambit",
        R.drawable.gambit_esports,
        arrayListOf(Pair(PersonalAbility.MACRO_CONTROL, 15))
    ),
    HELLRAISERS(
        3,
        "Hell Raisers",
        R.drawable.vp,
        arrayListOf(Pair(PersonalAbility.MACRO_CONTROL, 15))
    ),
    CYBERLEGACY(
        4,
        "CyberLegacy",
        R.drawable.navi,
        arrayListOf(Pair(PersonalAbility.MACRO_CONTROL, 15))
    ),
    EMPIRE(
        5,
        "Empire",
        R.drawable.gambit_esports,
        arrayListOf(Pair(PersonalAbility.MACRO_CONTROL, 15))
    )

}