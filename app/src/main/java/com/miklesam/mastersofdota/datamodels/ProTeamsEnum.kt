package com.miklesam.mastersofdota.datamodels

import com.miklesam.mastersofdota.R

enum class ProTeamsEnum(
    val id: Int,
    val teamName: String,
    val teamLogo: Int,
    val requires: ArrayList<Pair<PersonalAbility, Int>>
) {
    OPTIC_GAMING(
        0,
        "OpTic Gaming",
        R.drawable.optic_gaming,
        arrayListOf(
            Pair(PersonalAbility.MACRO_CONTROL, 15),
            Pair(PersonalAbility.MICRO_CONTROL, 25),
            Pair(PersonalAbility.TACTICS, 25),
            Pair(PersonalAbility.CONCENTRATION, 25),
            Pair(PersonalAbility.CREATIVITY, 25),
            Pair(PersonalAbility.EARLY_GAME, 25),
            Pair(PersonalAbility.FARM, 25),
            Pair(PersonalAbility.FIGHTING, 25),
            Pair(PersonalAbility.GANK, 25),
            Pair(PersonalAbility.MORAL, 25),
            Pair(PersonalAbility.MOTIVATION, 25),
            Pair(PersonalAbility.PRODUCTIVITY, 25),
            Pair(PersonalAbility.REACTION, 25),
            Pair(PersonalAbility.SKILL, 25),
            Pair(PersonalAbility.TEAMWORK, 25)
        )
    ),
    POTM_BOTTOM(
        1,
        "PotM Bottom",
        R.drawable.potmbottomlogo,
        arrayListOf(Pair(PersonalAbility.MACRO_CONTROL, 15))
    ),
    FLYING_PENGUINS(
        2,
        "Flying Penguins",
        R.drawable.flying_penguins_logo,
        arrayListOf(Pair(PersonalAbility.MACRO_CONTROL, 15))
    ),
    TEAM_DIGNITAS(
        3,
        "Team Dignitas",
        R.drawable.team_dignitas,
        arrayListOf(Pair(PersonalAbility.MACRO_CONTROL, 15))
    ),
    TEAM_ANVORGESA(
        4,
        "Team Anvorgesa",
        R.drawable.team_anvorgesa_logo,
        arrayListOf(Pair(PersonalAbility.MACRO_CONTROL, 15))
    ),
    MAD_KINGS(
        5,
        "Mad Kings",
        R.drawable.mad_kings,
        arrayListOf(Pair(PersonalAbility.MACRO_CONTROL, 15))
    ),
    NO_PING(
        6,
        "NoPing e-sports",
        R.drawable.no_ping_e_sportslogo,
        arrayListOf(Pair(PersonalAbility.MACRO_CONTROL, 15))
    ),
    DEMOLITION_BOYS(
        7,
        "Demolition Boys",
        R.drawable.demolition_boys,
        arrayListOf(Pair(PersonalAbility.MACRO_CONTROL, 15))
    ),
    KAIPI(
        8,
        "Kaipi",
        R.drawable.kaipi_logo,
        arrayListOf(Pair(PersonalAbility.MACRO_CONTROL, 15))
    ),
    SIGMA(
        9,
        "Sigma",
        R.drawable.sigma_logo,
        arrayListOf(Pair(PersonalAbility.MACRO_CONTROL, 15))
    ),
    QUANTIC_GAMING(
        10,
        "Quantic Gaming",
        R.drawable.quantic_logo,
        arrayListOf(Pair(PersonalAbility.MACRO_CONTROL, 15))
    ),
    NO_TIDEHUNTER(
        11,
        "No Tidehunter",
        R.drawable.no_tidehunter,
        arrayListOf(Pair(PersonalAbility.MACRO_CONTROL, 15))
    ),
    CLOVER4_LEPRICON(
        12,
        "4 Clover & Lepricon",
        R.drawable.clover4_and_lepricon,
        arrayListOf(Pair(PersonalAbility.MACRO_CONTROL, 15))
    ),
    ANCHORS4_SEA_CAPTAIN(
        13,
        "4 Anchors + Sea Captain",
        R.drawable.asc4_logo,
        arrayListOf(Pair(PersonalAbility.MACRO_CONTROL, 15))
    ),
    ROX_KIS(
        14,
        "RoX.KIS",
        R.drawable.rox_kis,
        arrayListOf(Pair(PersonalAbility.MACRO_CONTROL, 15))
    ),
    SCARY_FACEZ(
        15,
        "ScaryFaceZ",
        R.drawable.sfz_logo,
        arrayListOf(Pair(PersonalAbility.MACRO_CONTROL, 15))
    ),
    FRIENDS(
        16,
        "F.R.I.E.N.D.S.",
        R.drawable.logo_friends_dota2,
        arrayListOf(Pair(PersonalAbility.MACRO_CONTROL, 15))
    ),
    POLARITY(
        17,
        "Polarity",
        R.drawable.polarity_logo,
        arrayListOf(Pair(PersonalAbility.MACRO_CONTROL, 15))
    ),
    OLD_BUT_GOLD(
        18,
        "Old but Gold",
        R.drawable.old_but_gold_logo,
        arrayListOf(Pair(PersonalAbility.MACRO_CONTROL, 15))
    ),
    FANTASTIC_FIVE(
        19,
        "Fantastic Five",
        R.drawable.fantastic_five_logo,
        arrayListOf(Pair(PersonalAbility.MACRO_CONTROL, 15))
    ),
    CIS_REJECT(
        20,
        "CIS Rejects",
        R.drawable.cis_rejects_logo,
        arrayListOf(Pair(PersonalAbility.MACRO_CONTROL, 15))
    )

}