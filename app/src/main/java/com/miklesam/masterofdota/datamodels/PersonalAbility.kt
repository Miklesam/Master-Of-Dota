package com.miklesam.masterofdota.datamodels

enum class PersonalAbility(val id: Int, val nameAbility: String) {
    //Technical characteristics
    SKILL(0, "Skill"),
    CREATIVITY(1, "Creativity"),
    MICRO_CONTROL(2, "Micro control"),
    MACRO_CONTROL(3, "Macro control"),
    TACTICS(4, "Tactics"),

    //Moral characteristics
    TEAMWORK(5, "Teamwork"),
    PRODUCTIVITY(6, "Productivity"),
    MORAL(7, "Moral"),
    MOTIVATION(8, "Motivation"),
    REACTION(9, "Reaction"),
    CONCENTRATION(10, "Concentration"),

    // Game characteristics
    FARM(11, "Farm"),
    EARLY_GAME(12, "Early Game"),
    GANK(13, "Gank"),
    FIGHTING(14, "Fighting"),
    LATE_GAME(15, "Late Game")
}