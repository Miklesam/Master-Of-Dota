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
            Pair(PersonalAbility.TEAMWORK, 87),
            Pair(PersonalAbility.MORAL, 87),
            Pair(PersonalAbility.TACTICS, 89),
            Pair(PersonalAbility.MICRO_CONTROL, 84),
            Pair(PersonalAbility.MACRO_CONTROL, 86),
            Pair(PersonalAbility.FARM, 83),
            Pair(PersonalAbility.EARLY_GAME, 82),
            Pair(PersonalAbility.GANK, 84),
            Pair(PersonalAbility.FIGHTING, 85),
            Pair(PersonalAbility.LATE_GAME, 87),
            Pair(PersonalAbility.CREATIVITY, 89),
            Pair(PersonalAbility.REACTION, 79)
        )
        , 3900
    ),
    POTM_BOTTOM(
        1,
        "PotM Bottom",
        R.drawable.potmbottomlogo,
        arrayListOf(
            Pair(PersonalAbility.CREATIVITY, 60),
            Pair(PersonalAbility.MACRO_CONTROL, 55),
            Pair(PersonalAbility.LATE_GAME, 55),
            Pair(PersonalAbility.MORAL, 65),
            Pair(PersonalAbility.TEAMWORK, 55)
        )
        , 700
    ),
    FLYING_PENGUINS(
        2,
        "Flying Penguins",
        R.drawable.flying_penguins_logo,
        arrayListOf(
            Pair(PersonalAbility.TEAMWORK, 68),
            Pair(PersonalAbility.MORAL, 71),
            Pair(PersonalAbility.MOTIVATION, 65),
            Pair(PersonalAbility.LATE_GAME, 68),
            Pair(PersonalAbility.FARM, 63)
        )
        , 900
    ),
    TEAM_DIGNITAS(
        3,
        "Team Dignitas",
        R.drawable.team_dignitas,
        arrayListOf(
            Pair(PersonalAbility.TEAMWORK, 84),
            Pair(PersonalAbility.SKILL, 82),
            Pair(PersonalAbility.MICRO_CONTROL, 79),
            Pair(PersonalAbility.MACRO_CONTROL, 83),
            Pair(PersonalAbility.FARM, 85),
            Pair(PersonalAbility.EARLY_GAME, 85),
            Pair(PersonalAbility.GANK, 84),
            Pair(PersonalAbility.FIGHTING, 83),
            Pair(PersonalAbility.LATE_GAME, 82)
        )
        , 2500
    ),
    TEAM_ANVORGESA(
        4,
        "Team Anvorgesa",
        R.drawable.team_anvorgesa_logo,
        arrayListOf(
            Pair(PersonalAbility.FIGHTING, 64),
            Pair(PersonalAbility.GANK, 70),
            Pair(PersonalAbility.MORAL, 75),
            Pair(PersonalAbility.MOTIVATION, 70),
            Pair(PersonalAbility.CREATIVITY, 68)
        )
        , 1100
    ),
    MAD_KINGS(
        5,
        "Mad Kings",
        R.drawable.mad_kings,
        arrayListOf(
            Pair(PersonalAbility.REACTION, 60),
            Pair(PersonalAbility.FIGHTING, 60),
            Pair(PersonalAbility.SKILL, 45),
            Pair(PersonalAbility.FARM, 62),
            Pair(PersonalAbility.GANK, 45)
        )
        , 800
    ),
    NO_PING(
        6,
        "NoPing e-sports",
        R.drawable.no_ping_e_sportslogo,
        arrayListOf(
            Pair(PersonalAbility.TACTICS, 35),
            Pair(PersonalAbility.MACRO_CONTROL, 39),
            Pair(PersonalAbility.SKILL, 49),
            Pair(PersonalAbility.TEAMWORK, 35)
        )
        , 300
    ),
    DEMOLITION_BOYS(
        7,
        "Demolition Boys",
        R.drawable.demolition_boys,
        arrayListOf(
            Pair(PersonalAbility.MOTIVATION, 70),
            Pair(PersonalAbility.FIGHTING, 55),
            Pair(PersonalAbility.EARLY_GAME, 65),
            Pair(PersonalAbility.GANK, 65)
        )
        , 600
    ),
    KAIPI(
        8,
        "Kaipi",
        R.drawable.kaipi_logo,
        arrayListOf(
            Pair(PersonalAbility.TEAMWORK, 75),
            Pair(PersonalAbility.MICRO_CONTROL, 74),
            Pair(PersonalAbility.SKILL, 79),
            Pair(PersonalAbility.FARM, 72),
            Pair(PersonalAbility.EARLY_GAME, 69),
            Pair(PersonalAbility.LATE_GAME, 74),
            Pair(PersonalAbility.FIGHTING, 80),
            Pair(PersonalAbility.MACRO_CONTROL, 76)
        )
        , 1800
    ),
    SIGMA(
        9,
        "Sigma",
        R.drawable.sigma_logo,
        arrayListOf(
            Pair(PersonalAbility.SKILL, 87),
            Pair(PersonalAbility.MICRO_CONTROL, 81),
            Pair(PersonalAbility.MACRO_CONTROL, 82),
            Pair(PersonalAbility.TACTICS, 79),
            Pair(PersonalAbility.MORAL, 83),
            Pair(PersonalAbility.EARLY_GAME, 80),
            Pair(PersonalAbility.FIGHTING, 82),
            Pair(PersonalAbility.LATE_GAME, 84)
        )
        , 2000
    ),
    QUANTIC_GAMING(
        10,
        "Quantic Gaming",
        R.drawable.quantic_logo,
        arrayListOf(
            Pair(PersonalAbility.EARLY_GAME, 59),
            Pair(PersonalAbility.TACTICS, 65),
            Pair(PersonalAbility.MICRO_CONTROL, 70),
            Pair(PersonalAbility.MACRO_CONTROL, 68),
            Pair(PersonalAbility.CONCENTRATION, 70)
        )
        , 1000
    ),
    NO_TIDEHUNTER(
        11,
        "No Tidehunter",
        R.drawable.no_tidehunter,
        arrayListOf(
            Pair(PersonalAbility.TEAMWORK, 87),
            Pair(PersonalAbility.SKILL, 81),
            Pair(PersonalAbility.MOTIVATION, 83),
            Pair(PersonalAbility.MICRO_CONTROL, 79),
            Pair(PersonalAbility.MACRO_CONTROL, 89),
            Pair(PersonalAbility.FARM, 84),
            Pair(PersonalAbility.EARLY_GAME, 83),
            Pair(PersonalAbility.GANK, 87),
            Pair(PersonalAbility.FIGHTING, 89),
            Pair(PersonalAbility.LATE_GAME, 87)
        )
        , 2500
    ),
    CLOVER4_LEPRICON(
        12,
        "4 Clover & Lepricon",
        R.drawable.clover4_and_lepricon,
        arrayListOf(
            Pair(PersonalAbility.MORAL, 81),
            Pair(PersonalAbility.MOTIVATION, 73),
            Pair(PersonalAbility.GANK, 69),
            Pair(PersonalAbility.CREATIVITY, 58),
            Pair(PersonalAbility.TACTICS, 78),
            Pair(PersonalAbility.LATE_GAME, 69),
            Pair(PersonalAbility.EARLY_GAME, 74)
        )
        , 1500
    ),
    ANCHORS4_SEA_CAPTAIN(
        13,
        "4 Anchors + Sea Captain",
        R.drawable.asc4_logo,
        arrayListOf(
            Pair(PersonalAbility.EARLY_GAME, 75),
            Pair(PersonalAbility.CONCENTRATION, 69),
            Pair(PersonalAbility.TACTICS, 70),
            Pair(PersonalAbility.MACRO_CONTROL, 69),
            Pair(PersonalAbility.FARM, 74),
            Pair(PersonalAbility.MOTIVATION, 69)
        )
        , 1200
    ),
    ROX_KIS(
        14,
        "RoX.KIS",
        R.drawable.rox_kis,
        arrayListOf(
            Pair(PersonalAbility.SKILL, 65),
            Pair(PersonalAbility.MICRO_CONTROL, 45),
            Pair(PersonalAbility.PRODUCTIVITY, 49),
            Pair(PersonalAbility.GANK, 65)
        )
        , 300
    ),
    SCARY_FACEZ(
        15,
        "ScaryFaceZ",
        R.drawable.sfz_logo,
        arrayListOf(
            Pair(PersonalAbility.TACTICS, 45),
            Pair(PersonalAbility.MACRO_CONTROL, 55),
            Pair(PersonalAbility.CONCENTRATION, 45),
            Pair(PersonalAbility.CREATIVITY, 35)
        )
        , 400
    ),
    FRIENDS(
        16,
        "F.R.I.E.N.D.S.",
        R.drawable.logo_friends_dota2,
        arrayListOf(
            Pair(PersonalAbility.PRODUCTIVITY, 10),
            Pair(PersonalAbility.MOTIVATION, 80),
            Pair(PersonalAbility.MORAL, 76),
            Pair(PersonalAbility.SKILL, 70),
            Pair(PersonalAbility.CREATIVITY, 75)
        )
        , 1100
    ),
    POLARITY(
        17,
        "Polarity",
        R.drawable.polarity_logo,
        arrayListOf(
            Pair(PersonalAbility.TEAMWORK, 73),
            Pair(PersonalAbility.MORAL, 59),
            Pair(PersonalAbility.MICRO_CONTROL, 79),
            Pair(PersonalAbility.SKILL, 75),
            Pair(PersonalAbility.MOTIVATION, 80),
            Pair(PersonalAbility.FIGHTING, 72)
        )
        , 1300
    ),
    OLD_BUT_GOLD(
        18,
        "Old but Gold",
        R.drawable.old_but_gold_logo,
        arrayListOf(
            Pair(PersonalAbility.SKILL, 75),
            Pair(PersonalAbility.MICRO_CONTROL, 74),
            Pair(PersonalAbility.GANK, 67),
            Pair(PersonalAbility.EARLY_GAME, 70),
            Pair(PersonalAbility.TACTICS, 69),
            Pair(PersonalAbility.CONCENTRATION, 74),
            Pair(PersonalAbility.FIGHTING, 67)
        )
        , 1500
    ),
    FANTASTIC_FIVE(
        19,
        "Fantastic Five",
        R.drawable.fantastic_five_logo,
        arrayListOf(
            Pair(PersonalAbility.SKILL, 70),
            Pair(PersonalAbility.MICRO_CONTROL, 65),
            Pair(PersonalAbility.PRODUCTIVITY, 70),
            Pair(PersonalAbility.EARLY_GAME, 65),
            Pair(PersonalAbility.FIGHTING, 59)
        )
        , 800
    ),
    CIS_REJECT(
        20,
        "CIS Rejects",
        R.drawable.cis_rejects_logo,
        arrayListOf(
            Pair(PersonalAbility.MICRO_CONTROL, 45),
            Pair(PersonalAbility.MOTIVATION, 55),
            Pair(PersonalAbility.SKILL, 25)
        )
        , 100
    ),
    BIG_GOD(
        21,
        "Big God",
        R.drawable.big_god_logo,
        arrayListOf(
            Pair(PersonalAbility.MICRO_CONTROL, 70),
            Pair(PersonalAbility.PRODUCTIVITY, 78),
            Pair(PersonalAbility.REACTION, 68),
            Pair(PersonalAbility.SKILL, 65),
            Pair(PersonalAbility.FARM, 69),
            Pair(PersonalAbility.LATE_GAME, 74)
        )
        , 1100
    ),
    TEAM_DK(
        22,
        "Team DK",
        R.drawable.team_dk,
        arrayListOf(
            Pair(PersonalAbility.TEAMWORK, 89),
            Pair(PersonalAbility.SKILL, 84),
            Pair(PersonalAbility.CONCENTRATION, 89),
            Pair(PersonalAbility.MICRO_CONTROL, 84),
            Pair(PersonalAbility.MACRO_CONTROL, 83),
            Pair(PersonalAbility.FARM, 88),
            Pair(PersonalAbility.EARLY_GAME, 85),
            Pair(PersonalAbility.GANK, 84),
            Pair(PersonalAbility.FIGHTING, 89),
            Pair(PersonalAbility.LATE_GAME, 84)
        )
        , 3500
    ),
    TEAM_RANDOM(
        23,
        "Team Random",
        R.drawable.team_random,
        arrayListOf(
            Pair(PersonalAbility.CREATIVITY, 85),
            Pair(PersonalAbility.TEAMWORK, 71),
            Pair(PersonalAbility.MACRO_CONTROL, 75),
            Pair(PersonalAbility.SKILL, 82),
            Pair(PersonalAbility.MICRO_CONTROL, 74),
            Pair(PersonalAbility.FIGHTING, 75),
            Pair(PersonalAbility.EARLY_GAME, 77)
        )
        , 1400
    ),
    TEAM_SERENITY(
        24,
        "Team Serenity",
        R.drawable.team_serenity,
        arrayListOf(
            Pair(PersonalAbility.TEAMWORK, 89),
            Pair(PersonalAbility.MORAL, 89),
            Pair(PersonalAbility.TACTICS, 92),
            Pair(PersonalAbility.MICRO_CONTROL, 91),
            Pair(PersonalAbility.MACRO_CONTROL, 89),
            Pair(PersonalAbility.FARM, 87),
            Pair(PersonalAbility.EARLY_GAME, 83),
            Pair(PersonalAbility.GANK, 85),
            Pair(PersonalAbility.FIGHTING, 82),
            Pair(PersonalAbility.LATE_GAME, 83),
            Pair(PersonalAbility.CREATIVITY, 94),
            Pair(PersonalAbility.REACTION, 90),
            Pair(PersonalAbility.PRODUCTIVITY, 92)
        )
        , 4500
    ),
    TONG_FU(
        25,
        "TongFu",
        R.drawable.tong_fu,
        arrayListOf(
            Pair(PersonalAbility.TEAMWORK, 95),
            Pair(PersonalAbility.MORAL, 87),
            Pair(PersonalAbility.TACTICS, 96),
            Pair(PersonalAbility.MICRO_CONTROL, 92),
            Pair(PersonalAbility.MACRO_CONTROL, 91),
            Pair(PersonalAbility.FARM, 93),
            Pair(PersonalAbility.EARLY_GAME, 91),
            Pair(PersonalAbility.GANK, 87),
            Pair(PersonalAbility.FIGHTING, 88),
            Pair(PersonalAbility.LATE_GAME, 87),
            Pair(PersonalAbility.CREATIVITY, 82),
            Pair(PersonalAbility.REACTION, 96),
            Pair(PersonalAbility.PRODUCTIVITY, 91),
            Pair(PersonalAbility.SKILL, 94),
            Pair(PersonalAbility.CONCENTRATION, 97)
        )
        , 5800
    ),
    WINGS_GAMING(
        26,
        "Wings Gaming",
        R.drawable.wings_gaming,
        arrayListOf(
            Pair(PersonalAbility.TEAMWORK, 96),
            Pair(PersonalAbility.MORAL, 92),
            Pair(PersonalAbility.TACTICS, 94),
            Pair(PersonalAbility.MICRO_CONTROL, 92),
            Pair(PersonalAbility.MACRO_CONTROL, 91),
            Pair(PersonalAbility.FARM, 95),
            Pair(PersonalAbility.EARLY_GAME, 91),
            Pair(PersonalAbility.GANK, 92),
            Pair(PersonalAbility.FIGHTING, 94),
            Pair(PersonalAbility.LATE_GAME, 95),
            Pair(PersonalAbility.CREATIVITY, 99),
            Pair(PersonalAbility.REACTION, 90),
            Pair(PersonalAbility.PRODUCTIVITY, 95),
            Pair(PersonalAbility.SKILL, 97),
            Pair(PersonalAbility.CONCENTRATION, 97),
            Pair(PersonalAbility.MOTIVATION, 98)
        )
        , 7500
    ),
    ALPHA_RED(
        27,
        "ALPHA Red",
        R.drawable.alpha_red_logo,
        arrayListOf(
            Pair(PersonalAbility.TEAMWORK, 75),
            Pair(PersonalAbility.PRODUCTIVITY, 74),
            Pair(PersonalAbility.SKILL, 67),
            Pair(PersonalAbility.FARM, 70),
            Pair(PersonalAbility.EARLY_GAME, 69),
            Pair(PersonalAbility.LATE_GAME, 74),
            Pair(PersonalAbility.FIGHTING, 67)
        )
        , 1500
    ),
    ORANGE_ESPORTS(
        28,
        "Orange Esports",
        R.drawable.orange_logo,
        arrayListOf(
            Pair(PersonalAbility.TEAMWORK, 84),
            Pair(PersonalAbility.MORAL, 87),
            Pair(PersonalAbility.PRODUCTIVITY, 85),
            Pair(PersonalAbility.MICRO_CONTROL, 81),
            Pair(PersonalAbility.MACRO_CONTROL, 81),
            Pair(PersonalAbility.FARM, 82),
            Pair(PersonalAbility.EARLY_GAME, 81),
            Pair(PersonalAbility.GANK, 82),
            Pair(PersonalAbility.FIGHTING, 81),
            Pair(PersonalAbility.LATE_GAME, 82),
            Pair(PersonalAbility.CREATIVITY, 86)
        )
        , 3700
    ),
    TEAM_FACELESS(
        29,
        "Team Faceless",
        R.drawable.team_faceless_logo,
        arrayListOf(
            Pair(PersonalAbility.PRODUCTIVITY, 79),
            Pair(PersonalAbility.CONCENTRATION, 77),
            Pair(PersonalAbility.MICRO_CONTROL, 76),
            Pair(PersonalAbility.SKILL, 78),
            Pair(PersonalAbility.FARM, 81),
            Pair(PersonalAbility.EARLY_GAME, 76),
            Pair(PersonalAbility.REACTION, 79),
            Pair(PersonalAbility.LATE_GAME, 81)
        )
        , 2300
    ),
    TIGERS(
        30,
        "Tigers",
        R.drawable.tigers_logo,
        arrayListOf(
            Pair(PersonalAbility.TEAMWORK, 77),
            Pair(PersonalAbility.PRODUCTIVITY, 79),
            Pair(PersonalAbility.MORAL, 82),
            Pair(PersonalAbility.TACTICS, 73),
            Pair(PersonalAbility.MOTIVATION, 75),
            Pair(PersonalAbility.CONCENTRATION, 77),
            Pair(PersonalAbility.SKILL, 59),
            Pair(PersonalAbility.CREATIVITY, 79)
        )
        , 1900
    ),
    TITAN(
        31,
        "Titan",
        R.drawable.titan_logo,
        arrayListOf(
            Pair(PersonalAbility.TEAMWORK, 91),
            Pair(PersonalAbility.MORAL, 84),
            Pair(PersonalAbility.TACTICS, 93),
            Pair(PersonalAbility.MICRO_CONTROL, 85),
            Pair(PersonalAbility.MACRO_CONTROL, 90),
            Pair(PersonalAbility.FARM, 84),
            Pair(PersonalAbility.EARLY_GAME, 85),
            Pair(PersonalAbility.GANK, 86),
            Pair(PersonalAbility.FIGHTING, 87),
            Pair(PersonalAbility.LATE_GAME, 92),
            Pair(PersonalAbility.CREATIVITY, 85),
            Pair(PersonalAbility.REACTION, 92),
            Pair(PersonalAbility.PRODUCTIVITY, 87),
            Pair(PersonalAbility.SKILL, 93)
        )
        , 5300
    ),
    WARRIORS_GAMING_UNITY(
        32,
        "WarriorsGaming.Unity",
        R.drawable.warriors_gaming_unity,
        arrayListOf(
            Pair(PersonalAbility.CREATIVITY, 69),
            Pair(PersonalAbility.MICRO_CONTROL, 71),
            Pair(PersonalAbility.TACTICS, 72),
            Pair(PersonalAbility.GANK, 68),
            Pair(PersonalAbility.FARM, 73),
            Pair(PersonalAbility.EARLY_GAME, 63),
            Pair(PersonalAbility.FIGHTING, 74),
            Pair(PersonalAbility.LATE_GAME, 70)
        )
        , 2100
    )

}