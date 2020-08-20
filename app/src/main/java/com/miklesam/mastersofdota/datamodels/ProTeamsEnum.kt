package com.miklesam.mastersofdota.datamodels

import com.miklesam.mastersofdota.R

enum class ProTeamsEnum(
    val id: Int,
    val teamName: String,
    val teamLogo: Int,
    val requires: ArrayList<Pair<PersonalAbility, Int>>,
    val salary: Int
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
        ,500
    ),
    POTM_BOTTOM(
        1,
        "PotM Bottom",
        R.drawable.potmbottomlogo,
        arrayListOf(Pair(PersonalAbility.MACRO_CONTROL, 15))
        ,500
    ),
    FLYING_PENGUINS(
        2,
        "Flying Penguins",
        R.drawable.flying_penguins_logo,
        arrayListOf(Pair(PersonalAbility.MACRO_CONTROL, 15))
        ,500
    ),
    TEAM_DIGNITAS(
        3,
        "Team Dignitas",
        R.drawable.team_dignitas,
        arrayListOf(Pair(PersonalAbility.MACRO_CONTROL, 15))
        ,750000
    ),
    TEAM_ANVORGESA(
        4,
        "Team Anvorgesa",
        R.drawable.team_anvorgesa_logo,
        arrayListOf(Pair(PersonalAbility.MACRO_CONTROL, 15))
        ,500
    ),
    MAD_KINGS(
        5,
        "Mad Kings",
        R.drawable.mad_kings,
        arrayListOf(Pair(PersonalAbility.MACRO_CONTROL, 15))
        ,500
    ),
    NO_PING(
        6,
        "NoPing e-sports",
        R.drawable.no_ping_e_sportslogo,
        arrayListOf(Pair(PersonalAbility.MACRO_CONTROL, 15))
        ,500
    ),
    DEMOLITION_BOYS(
        7,
        "Demolition Boys",
        R.drawable.demolition_boys,
        arrayListOf(Pair(PersonalAbility.MACRO_CONTROL, 15))
        ,500
    ),
    KAIPI(
        8,
        "Kaipi",
        R.drawable.kaipi_logo,
        arrayListOf(Pair(PersonalAbility.MACRO_CONTROL, 15))
        ,500
    ),
    SIGMA(
        9,
        "Sigma",
        R.drawable.sigma_logo,
        arrayListOf(Pair(PersonalAbility.MACRO_CONTROL, 15))
        ,500
    ),
    QUANTIC_GAMING(
        10,
        "Quantic Gaming",
        R.drawable.quantic_logo,
        arrayListOf(Pair(PersonalAbility.MACRO_CONTROL, 15))
        ,500
    ),
    NO_TIDEHUNTER(
        11,
        "No Tidehunter",
        R.drawable.no_tidehunter,
        arrayListOf(Pair(PersonalAbility.MACRO_CONTROL, 15))
        ,500
    ),
    CLOVER4_LEPRICON(
        12,
        "4 Clover & Lepricon",
        R.drawable.clover4_and_lepricon,
        arrayListOf(Pair(PersonalAbility.MACRO_CONTROL, 15))
        ,500
    ),
    ANCHORS4_SEA_CAPTAIN(
        13,
        "4 Anchors + Sea Captain",
        R.drawable.asc4_logo,
        arrayListOf(Pair(PersonalAbility.MACRO_CONTROL, 15))
        ,500
    ),
    ROX_KIS(
        14,
        "RoX.KIS",
        R.drawable.rox_kis,
        arrayListOf(Pair(PersonalAbility.MACRO_CONTROL, 15))
        ,500
    ),
    SCARY_FACEZ(
        15,
        "ScaryFaceZ",
        R.drawable.sfz_logo,
        arrayListOf(Pair(PersonalAbility.MACRO_CONTROL, 15))
        ,500
    ),
    FRIENDS(
        16,
        "F.R.I.E.N.D.S.",
        R.drawable.logo_friends_dota2,
        arrayListOf(Pair(PersonalAbility.MACRO_CONTROL, 15))
        ,500
    ),
    POLARITY(
        17,
        "Polarity",
        R.drawable.polarity_logo,
        arrayListOf(Pair(PersonalAbility.MACRO_CONTROL, 15))
        ,500
    ),
    OLD_BUT_GOLD(
        18,
        "Old but Gold",
        R.drawable.old_but_gold_logo,
        arrayListOf(Pair(PersonalAbility.MACRO_CONTROL, 15))
        ,500
    ),
    FANTASTIC_FIVE(
        19,
        "Fantastic Five",
        R.drawable.fantastic_five_logo,
        arrayListOf(Pair(PersonalAbility.MACRO_CONTROL, 15))
        ,500
    ),
    CIS_REJECT(
        20,
        "CIS Rejects",
        R.drawable.cis_rejects_logo,
        arrayListOf(Pair(PersonalAbility.MACRO_CONTROL, 15))
        ,500
    ),
    BIG_GOD(
        21,
        "Big God",
        R.drawable.big_god_logo,
        arrayListOf(Pair(PersonalAbility.MACRO_CONTROL, 15))
        ,500
    ),
    TEAM_DK(
        22,
        "Team DK",
        R.drawable.team_dk,
        arrayListOf(Pair(PersonalAbility.MACRO_CONTROL, 15))
        ,500
    ),
    TEAM_RANDOM(
        23,
        "Team Random",
        R.drawable.team_random,
        arrayListOf(Pair(PersonalAbility.MACRO_CONTROL, 15))
        ,500
    ),
    TEAM_SERENITY(
        24,
        "Team Serenity",
        R.drawable.team_serenity,
        arrayListOf(Pair(PersonalAbility.MACRO_CONTROL, 15))
        ,500
    ),
    TONG_FU(
        25,
        "TongFu",
        R.drawable.tong_fu,
        arrayListOf(Pair(PersonalAbility.MACRO_CONTROL, 15))
        ,500
    ),
    WINGS_GAMING(
        26,
        "Wings Gaming",
        R.drawable.wings_gaming,
        arrayListOf(Pair(PersonalAbility.MACRO_CONTROL, 15))
        ,500
    ),
    ALPHA_RED(
        27,
        "ALPHA Red",
        R.drawable.alpha_red_logo,
        arrayListOf(Pair(PersonalAbility.MACRO_CONTROL, 15))
        ,500
    ),
    ORANGE_ESPORTS(
        28,
        "Orange Esports",
        R.drawable.orange_logo,
        arrayListOf(Pair(PersonalAbility.MACRO_CONTROL, 15))
        ,500
    ),
    TEAM_FACELESS(
        29,
        "Team Faceless",
        R.drawable.team_faceless_logo,
        arrayListOf(Pair(PersonalAbility.MACRO_CONTROL, 15))
        ,500
    ),
    TIGERS(
        30,
        "Tigers",
        R.drawable.tigers_logo,
        arrayListOf(Pair(PersonalAbility.MACRO_CONTROL, 15))
        ,500
    ),
    TITAN(
        31,
        "Titan",
        R.drawable.titan_logo,
        arrayListOf(Pair(PersonalAbility.MACRO_CONTROL, 15))
        ,500
    ),
    WARRIORS_GAMING_UNITY(
        32,
        "WarriorsGaming.Unity",
        R.drawable.warriors_gaming_unity,
        arrayListOf(Pair(PersonalAbility.MACRO_CONTROL, 15))
        ,500
    )

}