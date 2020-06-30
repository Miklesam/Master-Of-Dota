package com.miklesam.masterofdota

enum class Heroes(
    val id: Int,
    val heroName: String,
    val image_pick: Int,
    val icon: Int,
    val largeBan: Int,
    val minBan: Int,
    val mipmap: Int,
    val laining: Int,
    val fighting: Int,
    val lateGame: Int
) {
    ABADON(
        0, "Abadon",
        R.drawable.abadon_picked,
        R.drawable.abadon_icon,
        R.drawable.abadon_large_ban,
        R.drawable.abadon_min_ban,
        R.drawable.abadon_mipmap, 85, 70, 55
    ),
    ALCHEMIC(
        1, "Alchemist",
        R.drawable.alcemic_picked,
        R.drawable.alchemic_icon,
        R.drawable.alcemic_large_ban,
        R.drawable.alcemic_min_ban,
        R.drawable.alcemic_mipmap, 70, 85, 70
    ),
    AXE(
        2, "Axe",
        R.drawable.axe_picked,
        R.drawable.axe_icon,
        R.drawable.axe_large_ban,
        R.drawable.axe_min_ban,
        R.drawable.axe_mipmap, 85, 80, 70
    ),
    BEASTMASTER(
        3, "Beastmaster",
        R.drawable.beastmaster_picked,
        R.drawable.beastmater_icon,
        R.drawable.beastmaster_large_ban,
        R.drawable.beastmaster_min_ban,
        R.drawable.beastmaster_mipmap, 90, 65, 65
    ),
    BREWMASTER(
        4, "Brewmaster",
        R.drawable.brewmaster_picked,
        R.drawable.brewmaster_icon,
        R.drawable.brewmaster_ban,
        R.drawable.brewmaster_min_ban,
        R.drawable.brewmaster_mipmap, 70, 75, 70
    ),
    BRISTLEBACK(
        5, "Bristleback",
        R.drawable.bristleback_picked,
        R.drawable.bristleback_icon,
        R.drawable.bristleback_ban,
        R.drawable.bristleback_min_ban,
        R.drawable.bristleback_mipmap, 85, 70, 70
    ),
    CENTAUR(
        6, "Centaur",
        R.drawable.centaur_picked,
        R.drawable.centaur_icon,
        R.drawable.centaur_large_ban,
        R.drawable.centaur_min_ban,
        R.drawable.centaur_mipmap, 80, 80, 70
    ),
    CHAOS(
        7, "Chaos",
        R.drawable.chaos_picked,
        R.drawable.chaos_icon,
        R.drawable.chaos_large_ban,
        R.drawable.chaos_min_ban,
        R.drawable.chaos_mipmap, 85, 70, 80
    ),
    CLOCKWERK(
        8, "Clockwerk",
        R.drawable.clockwerk_picked,
        R.drawable.clockwerk_icon,
        R.drawable.clockwerk_large_ban,
        R.drawable.clockwerk_min_ban,
        R.drawable.clockwerk_mipmap, 85, 85, 60
    ),
    DOOM(
        9, "Doom",
        R.drawable.doom_picked,
        R.drawable.doom_icon,
        R.drawable.doom_large_ban,
        R.drawable.doom_min_ban,
        R.drawable.doom_mipmap, 70, 65, 65
    ),
    DK(
        10, "Dragon Knight",
        R.drawable.dk_picked,
        R.drawable.dk_icon,
        R.drawable.dk_large_ban,
        R.drawable.dk_min_ban,
        R.drawable.dragonknight_mipmap, 85, 70, 80
    ),
    EARTH_SPIRIT(
        11, "Earth Spirit",
        R.drawable.earthspirit_picked,
        R.drawable.earth_spirit_icon,
        R.drawable.earthspirit_large_ban,
        R.drawable.earthspirit_min_ban,
        R.drawable.earthspirit_mipmap, 80, 85, 70
    ),
    EARTH_SHAKER(
        12, "Earthshaker",
        R.drawable.shaker_picked,
        R.drawable.eartshaker_icon,
        R.drawable.shaker_large_ban,
        R.drawable.shaker_min_ban,
        R.drawable.earthshaker_mipmap, 60, 90, 70
    ),
    ELDER_TITAN(
        13, "Elder Titan",
        R.drawable.eldertitan_picked,
        R.drawable.eldertitan_icon,
        R.drawable.eldertitan_large_ban,
        R.drawable.eldertitan_min_ban,
        R.drawable.eldertitan_mipmap, 70, 75, 80
    ),
    HUSKAR(
        14, "Huskar",
        R.drawable.huskar_picked,
        R.drawable.huskar_icon,
        R.drawable.huskar_large_ban,
        R.drawable.huskar_min_ban,
        R.drawable.huskar_mipmap, 90, 90, 60
    ),
    IO(
        15, "IO",
        R.drawable.io_picked,
        R.drawable.io_icon,
        R.drawable.io_large_ban,
        R.drawable.io_min_ban,
        R.drawable.wisp_mipmap, 80, 80, 80
    ),
    KUNNKA(
        16, "Kunnka",
        R.drawable.kunnka_picked,
        R.drawable.kunnka_icon,
        R.drawable.kunnka_large_ban,
        R.drawable.kunnka_min_ban,
        R.drawable.kunnka_mipmap, 85, 85, 80
    ),
    LC(
        17, "Legion Commander",
        R.drawable.lc_picked,
        R.drawable.lc_icon,
        R.drawable.lc_large_ban,
        R.drawable.lc_min_ban,
        R.drawable.lc_mipmap, 75, 70, 80
    ),
    LIFESTEALER(
        18, "Lifestealer",
        R.drawable.lifestealer_picked,
        R.drawable.lifestealer_icon,
        R.drawable.lifestealer_large_ban,
        R.drawable.lifestealer_min_ban,
        R.drawable.lifestealer_mipmap, 85, 90, 75
    ),
    LYCAN(
        19, "Lycan",
        R.drawable.lycan_picked,
        R.drawable.lycan_icon,
        R.drawable.lycan_large_ban,
        R.drawable.lycan_min_ban,
        R.drawable.lycan_mipmap, 95, 85, 75
    ),
    MAGNUS(
        20, "Magnus",
        R.drawable.magnus_picked,
        R.drawable.magnus_icon,
        R.drawable.magnus_large_ban,
        R.drawable.magnus_min_ban,
        R.drawable.magnus_mipmap, 65, 95, 80
    ),
    MARS(
        21, "Mars",
        R.drawable.mars_picked,
        R.drawable.mars_icon,
        R.drawable.mars_large_ban,
        R.drawable.mars_min_ban,
        R.drawable.mars_mipmap, 80, 85, 75
    ),
    NS(
        22, "Night Stalker",
        R.drawable.ns_picked,
        R.drawable.night_stalker_icon,
        R.drawable.ns_large_ban,
        R.drawable.ns_min_ban,
        R.drawable.ns_mipmap, 75, 70, 70
    ),
    OMNIKNIGHT(
        23, "Omniknight",
        R.drawable.omnik_picked,
        R.drawable.omniknight_icon,
        R.drawable.omnik_large_ban,
        R.drawable.omnik_min_ban,
        R.drawable.omnik_mipmap, 70, 80, 80
    ),
    PHOENIX(
        24, "Phoenix",
        R.drawable.phoenix_picked,
        R.drawable.phoenix_icon,
        R.drawable.phoenix_large_ban,
        R.drawable.phoenix_min_ban,
        R.drawable.phoenix_mipmap, 80, 85, 75
    ),
    PUDGE(
        25, "Pudge",
        R.drawable.pudge_picked,
        R.drawable.pudge_icon,
        R.drawable.pudge_large_ban,
        R.drawable.pudge_min_ban,
        R.drawable.pudge_mipmap, 60, 70, 75
    ),
    SAND_KING(
        26, "Sand King",
        R.drawable.sandking_picked,
        R.drawable.sand_king_icon,
        R.drawable.sandking_large_ban,
        R.drawable.sandking_min_ban,
        R.drawable.sandking_mipmap, 85, 85, 65
    ),
    SLARDAR(
        27, "Slardar",
        R.drawable.slardar_picked,
        R.drawable.slardar_icon,
        R.drawable.slardar_large_ban,
        R.drawable.slardar_min_ban,
        R.drawable.slardar_mipmap, 70, 75, 80
    ),
    SPIRIT_BREAKER(
        28, "Spirit Breaker",
        R.drawable.spiritbreaker_picked,
        R.drawable.spirit_breaker_icon,
        R.drawable.spiritbraker_large_ban,
        R.drawable.spiritbreaker_min_ban,
        R.drawable.spiritbreaker_mipmap, 75, 75, 65
    ),
    SVEN(
        29, "Sven",
        R.drawable.sven_picked,
        R.drawable.sven_icon,
        R.drawable.sven_large_ban,
        R.drawable.sven_min_ban,
        R.drawable.sven_mipmap, 85, 85, 75
    ),
    TIDEHUNTER(
        30, "Tidehunter",
        R.drawable.tidehunter_picked,
        R.drawable.tidehunter_icon,
        R.drawable.tidehunter_large_ban,
        R.drawable.tidehunter_min_ban,
        R.drawable.tidehunter_mipmap, 85, 85, 75
    ),
    TIMBERSAW(
        31, "Timbersaw",
        R.drawable.timber_picked,
        R.drawable.timbersaw_icon,
        R.drawable.timbersaw_large_ban,
        R.drawable.timbersaw_min_ban,
        R.drawable.timbersaw_mipmap, 85, 85, 70
    ),
    TINY(
        32, "Tiny",
        R.drawable.tiny_picked,
        R.drawable.tiny_icon,
        R.drawable.tiny_large_ban,
        R.drawable.tiny_min_ban,
        R.drawable.tiny_mipmap, 75, 80, 85
    ),
    TREANT(
        33, "Treant Protector",
        R.drawable.treant_picked,
        R.drawable.treant_icon,
        R.drawable.treant_large_ban,
        R.drawable.treant_min_ban,
        R.drawable.treant_mipmap, 85, 80, 60
    ),
    TUSK(
        34, "Tusk",
        R.drawable.tusk_picked,
        R.drawable.tusk_icon,
        R.drawable.tusk_large_ban,
        R.drawable.tusk_min_ban,
        R.drawable.tusk_mipmap, 75, 80, 75
    ),
    UNDERLORD(
        35, "Underlord",
        R.drawable.underlord_picked,
        R.drawable.underlord_icon,
        R.drawable.underlord_large_ban,
        R.drawable.underlord_min_ban,
        R.drawable.underlord_mipmap, 85, 80, 65
    ),
    UNDYING(
        36, "Undying",
        R.drawable.undying_picked,
        R.drawable.undying_icon,
        R.drawable.undying_large_ban,
        R.drawable.undying_min_ban,
        R.drawable.undying_mipmap, 85, 80, 55
    ),
    WK(
        37, "Wraith King",
        R.drawable.wk_picked,
        R.drawable.wk_icon,
        R.drawable.wk_large_ban,
        R.drawable.wk_min_ban,
        R.drawable.wk_mipmap, 80, 80, 90
    ),

    //Agility
    ANTIMAGE(
        38, "Anti-Mage",
        R.drawable.anti_mage_picked,
        R.drawable.anti_mage_icon,
        R.drawable.antimag_large_ban,
        R.drawable.antimag_min_ban,
        R.drawable.antimag_mip_map, 55, 70, 90
    ),
    ARC_WARDEN(
        39, "Arc Warden",
        R.drawable.arcwarden_picked,
        R.drawable.arc_warden_icon,
        R.drawable.arcwarden_large_ban,
        R.drawable.arcwarden_min_ban,
        R.drawable.arcwarden_mipmap, 80, 75, 90
    ),
    BLOODSEEKER(
        40, "Bloodseeker",
        R.drawable.bloodseeker_picked,
        R.drawable.bloodseeker_icon,
        R.drawable.bloodweeker_large_ban,
        R.drawable.bloodseeker_min_ban,
        R.drawable.bloodseeker_mipmap, 80, 75, 70
    ),
    BOUNTY(
        41, "Bounty Hunter",
        R.drawable.bountyhunter_picked,
        R.drawable.bounty_hunter_icon,
        R.drawable.bounty_large_ban,
        R.drawable.bounty_min_ban,
        R.drawable.bounty_mipmap, 75, 60, 70
    ),
    BROODMOTHER(
        42, "Broodmother",
        R.drawable.broodmother_picked,
        R.drawable.broodmother_icon,
        R.drawable.broodmother_large_ban,
        R.drawable.broodmother_min_ban,
        R.drawable.broodmother_mipmap, 95, 70, 80
    ),
    CLINKZ(
        43, "Clinkz",
        R.drawable.clinkz_picked,
        R.drawable.clinkz_icon,
        R.drawable.clinkz_large_ban,
        R.drawable.clinkz_min_ban,
        R.drawable.clinkz_mipmap, 85, 75, 80
    ),
    DROW(
        44, "Drow Ranger",
        R.drawable.drow_picked,
        R.drawable.drow_icon,
        R.drawable.drow_large_ban,
        R.drawable.drow_min_ban,
        R.drawable.drow_mipmap, 70, 80, 85
    ),
    EMBER(
        45, "Ember Spirit",
        R.drawable.ember_picked,
        R.drawable.ember_icon,
        R.drawable.ember_large_ban,
        R.drawable.ember_min_ban,
        R.drawable.emberspirit_mipmap, 70, 85, 90
    ),
    FACELESS_VOID(
        46, "Faceless Void",
        R.drawable.faceless_picked,
        R.drawable.facelessvoid_icon,
        R.drawable.faceless_large_ban,
        R.drawable.faceless_min_ban,
        R.drawable.facelessvoid_mipmap, 70, 85, 90
    ),
    GYROCOPTER(
        47, "Gyrocopter",
        R.drawable.gyrocopter_picked,
        R.drawable.gyrocopter_icon,
        R.drawable.gyrocopter_large_ban,
        R.drawable.gyrocopter_min_ban,
        R.drawable.gyrocopter_mipmap, 75, 75, 80
    ),
    JUGGERNAUT(
        48, "Juggernaut",
        R.drawable.jagernaut_picked,
        R.drawable.jaggernaut_icon,
        R.drawable.juggernaut_large_ban,
        R.drawable.jugernaut_min_ban,
        R.drawable.jaggernaut_mipmap, 80, 80, 80
    ),
    LONE_DRUID(
        49, "Lone Druid",
        R.drawable.lonedruid_picked,
        R.drawable.lonedruid_icon,
        R.drawable.lonedruid_large_ban,
        R.drawable.lonedruid_min_ban,
        R.drawable.lonedruid_mipmap, 85, 75, 85
    ),
    LUNA(
        50, "Luna",
        R.drawable.luna_picked,
        R.drawable.luna_icon,
        R.drawable.luna_large_ban,
        R.drawable.luna_min_ban,
        R.drawable.luna_mipmap, 70, 80, 90
    ),
    MEDUSA(
        51, "Medusa",
        R.drawable.medusa_picked,
        R.drawable.medusa_icon,
        R.drawable.medusa_large_ban,
        R.drawable.medusa_min_ban,
        R.drawable.medusa_mipmap, 65, 80, 90
    ),
    MEEPO(
        52, "Meepo",
        R.drawable.meepo_picked,
        R.drawable.meepo_icon,
        R.drawable.meepo_large_ban,
        R.drawable.meepo_min_ban,
        R.drawable.meepo_mipmap, 85, 90, 75
    ),
    MIRANA(
        53, "Mirana",
        R.drawable.mirana_picked,
        R.drawable.mirana_icon,
        R.drawable.mirana_large_ban,
        R.drawable.mirana_min_ban,
        R.drawable.mirana_mipmap, 70, 75, 80
    ),
    MONKEY_KING(
        54, "Monkey King",
        R.drawable.mk_picked,
        R.drawable.monkey_king_icon,
        R.drawable.monkeyking_large_ban,
        R.drawable.monkeyking_min_ban,
        R.drawable.monkeyking_mipmap, 85, 80, 80
    ),
    MORPHLING(
        55, "Morphling",
        R.drawable.morphling_picked,
        R.drawable.morpling_icon,
        R.drawable.morphling_large_ban,
        R.drawable.morpling_min_ban,
        R.drawable.morphling_mipmap, 70, 85, 95
    ),
    NAGA(
        56, "Naga Siren",
        R.drawable.naga_picked,
        R.drawable.naga_icon,
        R.drawable.naga_large_ban,
        R.drawable.naga_min_ban,
        R.drawable.naga_mipmap, 70, 80, 90
    ),
    NYX(
        57, "Nyx Assassin",
        R.drawable.nyx_picked,
        R.drawable.nyx_icon,
        R.drawable.nyx_large_ban,
        R.drawable.nyx_min_ban,
        R.drawable.nyx_mipmap, 70, 85, 70
    ),
    PANGOLIER(
        58, "Pangolier",
        R.drawable.pango_picked,
        R.drawable.pangolier,
        R.drawable.pango_large_ban,
        R.drawable.pango_min_ban,
        R.drawable.pango_mipmap, 80, 85, 80
    ),
    PA(
        59, "Phantom Assassin",
        R.drawable.pa_picked,
        R.drawable.phantom_assasin_icon,
        R.drawable.pa_large_ban,
        R.drawable.pa_min_ban,
        R.drawable.pa_mipmap, 75, 85, 75
    ),
    PHANTOM_LANCER(
        60, "Phantom Lancer",
        R.drawable.pl_picked,
        R.drawable.phantom_lancer_icon,
        R.drawable.pl_large_ban,
        R.drawable.pl_min_ban,
        R.drawable.pl_mipmap, 70, 80, 90
    ),
    RAZOR(
        61, "Razor",
        R.drawable.razor_picked,
        R.drawable.razor_icon,
        R.drawable.razor_large_ban,
        R.drawable.razor_min_ban,
        R.drawable.razor_mipmap, 85, 80, 70
    ),
    RIKI(
        62, "Riki",
        R.drawable.riki_picked,
        R.drawable.riki_icon,
        R.drawable.riki_large_ban,
        R.drawable.riki_min_ban,
        R.drawable.riki_mipmap, 75, 85, 85
    ),
    SHADOW_FIEND(
        63, "Shadow Fiend",
        R.drawable.sf_picked,
        R.drawable.shadow_fiend_icon,
        R.drawable.sf_large_ban,
        R.drawable.sf_min_ban,
        R.drawable.sf_mipmap, 80, 85, 80
    ),
    SLARK(
        64, "Slark",
        R.drawable.slark_picked,
        R.drawable.slark_icon,
        R.drawable.slark_large_ban,
        R.drawable.slark_min_ban,
        R.drawable.slark_mipmap, 70, 75, 90
    ),
    SNIPER(
        65, "Sniper",
        R.drawable.sniper_picked,
        R.drawable.sniper_icon,
        R.drawable.sniper_large_ban,
        R.drawable.sniper_min_ban,
        R.drawable.sniper_mipmap, 65, 70, 90
    ),
    SPECTRE(
        66, "Spectre",
        R.drawable.spectre_picked,
        R.drawable.spectre_icon,
        R.drawable.spectre_large_ban,
        R.drawable.spectre_min_ban,
        R.drawable.spectre_mipmap, 55, 80, 95
    ),
    TEMPLAR_ASSASIN(
        67, "Templar Assasin",
        R.drawable.ta_picked,
        R.drawable.templarassasin_icon,
        R.drawable.ta_large_ban,
        R.drawable.ta_min_ban,
        R.drawable.ta_mipmap, 85, 80, 80
    ),
    TERROBLADE(
        68, "Terroblade",
        R.drawable.tb_picked,
        R.drawable.teroblade_icon,
        R.drawable.tb_large_ban,
        R.drawable.tb_min_ban,
        R.drawable.tb_mipmap, 70, 80, 95
    ),
    TROLL_WARLORD(
        69, "Troll Warlord",
        R.drawable.trollwarlord_picked,
        R.drawable.troll_warlord_icon,
        R.drawable.trollwarlord_large_ban,
        R.drawable.trollwarlord_min_ban,
        R.drawable.trollwarlord_mipmap, 70, 90, 85
    ),
    URSA(
        70, "Ursa",
        R.drawable.ursa_picked,
        R.drawable.ursa_icon,
        R.drawable.ursa_large_ban,
        R.drawable.ursa_min_ban,
        R.drawable.ursa_mipmap, 85, 85, 70
    ),
    VENOMANCER(
        71, "Venomancer",
        R.drawable.venomancer_picked,
        R.drawable.venomancer_icon,
        R.drawable.venomancer_large_ban,
        R.drawable.venomancer_min_ban,
        R.drawable.venomancer_mipmap, 85, 90, 60
    ),
    VENGEFUL(
        72, "Vengeful Spirit",
        R.drawable.vengeful_picked,
        R.drawable.vengespirit_icon,
        R.drawable.vengeful_large_ban,
        R.drawable.vengeful_min_ban,
        R.drawable.vengeful_mipmap, 75, 75, 75
    ),
    VIPER(
        73, "Viper",
        R.drawable.viper_picked,
        R.drawable.viper_icon,
        R.drawable.viper_large_ban,
        R.drawable.viper_min_ban,
        R.drawable.viper_mipmap, 85, 85, 75
    ),
    WIVER(
        74, "Weaver",
        R.drawable.wiver_picked,
        R.drawable.wiver_icon,
        R.drawable.wiver_large_ban,
        R.drawable.wiver_min_ban,
        R.drawable.wiver_mipmap, 75, 80, 80
    ),

    //Intelegent
    AA(
        75, "Ancient Apparition",
        R.drawable.aa_picked,
        R.drawable.aa_icon,
        R.drawable.aa_large_ban,
        R.drawable.aa_min_ban,
        R.drawable.aa_mipmap, 75, 75, 75
    ),
    BANE(
        76, "Bane",
        R.drawable.bane_picked,
        R.drawable.bane_icon,
        R.drawable.bane_large_ban,
        R.drawable.bane_min_ban,
        R.drawable.bane_mipmap, 95, 80, 75
    ),
    BATHRIDER(
        77, "Batrider",
        R.drawable.batrider_picked,
        R.drawable.batrider_icon,
        R.drawable.batrider_large_ban,
        R.drawable.batrider_min_ban,
        R.drawable.bathrider_mipmap, 90, 80, 75
    ),
    CHEN(
        78, "Chen",
        R.drawable.chen_picked,
        R.drawable.chen_icon,
        R.drawable.chen_large_ban,
        R.drawable.chen_min_ban,
        R.drawable.chen_mipmap, 85, 85, 45
    ),
    CM(
        79, "Crystal Maiden",
        R.drawable.cm_picked,
        R.drawable.crystal_maden_icon,
        R.drawable.cm_large_ban,
        R.drawable.cm_min_ban,
        R.drawable.crystalmaden_mipmap, 75, 90, 60
    ),
    DARKSEER(
        80, "Dark Seer",
        R.drawable.darkseer_picked,
        R.drawable.dark_seer_icon,
        R.drawable.darkseer_large_ban,
        R.drawable.darkseer_min_ban,
        R.drawable.darkseer_mipmap, 80, 85, 75
    ),
    DARK_WILLOW(
        81, "Dark Willow",
        R.drawable.darkwillow_picked,
        R.drawable.dark_willow_icon,
        R.drawable.darkwillow_large_ban,
        R.drawable.darkwillow_min_ban,
        R.drawable.darkwillow_mipmap, 80, 85, 75
    ),
    DAZZLE(
        82, "Dazzle",
        R.drawable.dazzle_picked,
        R.drawable.duzzle_icon,
        R.drawable.dazzle_large_ban,
        R.drawable.dazzle_min_ban,
        R.drawable.dazzle_mipmap, 80, 90, 75
    ),
    DEATH_PROPHET(
        83, "Death Prophet",
        R.drawable.dp_picked,
        R.drawable.death_prophet_icon,
        R.drawable.dp_large_ban,
        R.drawable.dp_min_ban,
        R.drawable.death_prophet_mipmap, 80, 90, 85
    ),
    DISRUPTOR(
        84, "Disruptor",
        R.drawable.disruptor_picked,
        R.drawable.disruptor_icon,
        R.drawable.distruptor_large_ban,
        R.drawable.disruptor_min_ban,
        R.drawable.disruptor_mipmap, 80, 90, 60
    ),
    ENCHANTRESS(
        85, "Enchantress",
        R.drawable.enchauntress_picked,
        R.drawable.enchantress_icon,
        R.drawable.enchantress_large_ban,
        R.drawable.enchantress_min_ban,
        R.drawable.enchauntress_mipmap, 80, 75, 80
    ),
    ENIGMA(
        86, "Enigma",
        R.drawable.enigma_picked,
        R.drawable.enigma_icon,
        R.drawable.enigma_large_ban,
        R.drawable.enigma_min_ban,
        R.drawable.enigma_mipmap, 60, 90, 90
    ),
    GRIMSTROKE(
        87, "Grimstroke",
        R.drawable.grimstroke_picked,
        R.drawable.grimstroke_icon,
        R.drawable.grimstroke_large_ban,
        R.drawable.grimstroke_min_ban,
        R.drawable.grimstroke_mipmap, 75, 80, 70
    ),
    INVOKER(
        88, "Invoker",
        R.drawable.invoker_picked,
        R.drawable.invoker_icon,
        R.drawable.invoker_large_ban,
        R.drawable.invoker_min_ban,
        R.drawable.invoker_mipmap, 70, 95, 75
    ),
    JAKIRO(
        89, "Jakiro",
        R.drawable.jakiro_picked,
        R.drawable.jakiro_icon,
        R.drawable.jakiro_large_ban,
        R.drawable.jakiro_min_ban,
        R.drawable.jakiro_mipmap, 85, 85, 60
    ),
    KEEPER_OF_THE_LIGHT(
        90, "Keeper of the Light",
        R.drawable.kottl_picked,
        R.drawable.keeper_of_the_light_icon,
        R.drawable.kotl_large_ban,
        R.drawable.kotl_min_ban,
        R.drawable.kotl_mipmap, 70, 95, 60
    ),
    LESHRAC(
        91, "Leshrac",
        R.drawable.lechrac_picked,
        R.drawable.lechrak_icon,
        R.drawable.lechrac_large_ban,
        R.drawable.lechrac_min_ban,
        R.drawable.leshrac_mipmap, 80, 90, 75
    ),
    LICH(
        92, "Lich",
        R.drawable.lich_picked,
        R.drawable.lich_icon,
        R.drawable.lich_large_ban,
        R.drawable.lich_min_ban,
        R.drawable.lich_mipmap, 75, 90, 60
    ),
    LINA(
        93, "Lina",
        R.drawable.lina_picked,
        R.drawable.lina_icon,
        R.drawable.lina_large_ban,
        R.drawable.lina_min_ban,
        R.drawable.lina_mipmap, 85, 80, 80
    ),
    LION(
        94, "Lion",
        R.drawable.lion_picked,
        R.drawable.lion_icon,
        R.drawable.lion_large_ban,
        R.drawable.lion_min_ban,
        R.drawable.lion_mipmap, 75, 75, 85
    ),
    NATURES_PROPHET(
        95, "Nature's Prophet",
        R.drawable.naturesprophet_picked,
        R.drawable.natures_prophet_icon,
        R.drawable.naturesprophet_large_ban,
        R.drawable.naturesprophet_min_ban,
        R.drawable.naturesphrophet_mipmap, 80, 75, 80
    ),
    NECROPHOS(
        96, "Necrophos",
        R.drawable.necrophos_picked,
        R.drawable.necrophos_icon,
        R.drawable.necrophos_large_ban,
        R.drawable.necrophos_min_ban,
        R.drawable.necrophos_mipmap, 80, 80, 70
    ),
    OGREMAGI(
        97, "Ogre Magi",
        R.drawable.ogremagi_picked,
        R.drawable.ogre_magi_icon,
        R.drawable.ogremagi_large_ban,
        R.drawable.ogremagi_min_ban,
        R.drawable.ogremagi_mipmap, 75, 80, 65
    ),
    ORACLE(
        98, "Oracle",
        R.drawable.oracle_picked,
        R.drawable.oracle_icon,
        R.drawable.oracle_large_ban,
        R.drawable.oracle_min_ban,
        R.drawable.oracle_mipmap, 80, 80, 70
    ),
    OD(
        99, "Outworld Devourer",
        R.drawable.od_picked,
        R.drawable.od_icon,
        R.drawable.od_large_ban,
        R.drawable.od_min_ban,
        R.drawable.od_mipmap, 75, 90, 80
    ),
    PUCK(
        100, "Puck",
        R.drawable.puck_picked,
        R.drawable.puck_icon,
        R.drawable.puck_large_ban,
        R.drawable.puck_min_ban,
        R.drawable.puck_mipmap, 75, 90, 75
    ),
    PUGNA(
        101, "Pugna",
        R.drawable.pugna_picked,
        R.drawable.pugna_icon,
        R.drawable.pugna_large_ban,
        R.drawable.pugna_min_ban,
        R.drawable.pugna_mipmap, 85, 85, 70
    ),
    QOP(
        102, "Queen of Pain",
        R.drawable.qop_picked,
        R.drawable.qop_icon,
        R.drawable.qop_large_ban,
        R.drawable.qop_min_ban,
        R.drawable.qop_mipmap, 85, 85, 75
    ),
    RUBICK(
        103, "Rubick",
        R.drawable.rubick_picked,
        R.drawable.rubick_icon,
        R.drawable.rubick_large_ban,
        R.drawable.rubick_min_ban,
        R.drawable.rubick_mipmap, 60, 80, 80
    ),
    SHADOW_DEMON(
        104, "Shadow Demon",
        R.drawable.shadowdemon_picked,
        R.drawable.shadow_demon_icon,
        R.drawable.shadowfemon_large_ban,
        R.drawable.shadow_demon_min_ban,
        R.drawable.shadowdemon_mipmap, 85, 75, 80
    ),
    SHADOW_SHAMAN(
        105, "Shadow Shaman",
        R.drawable.shadowshaman_picked,
        R.drawable.shadow_shaman_icon,
        R.drawable.shadowsjaman_large_ban,
        R.drawable.shadowshaman_min_ban,
        R.drawable.shadowshaman_mipmap, 80, 70, 70
    ),
    SILENCER(
        106, "Silencer",
        R.drawable.silencer_picked,
        R.drawable.silencer_icon,
        R.drawable.silencer_large_ban,
        R.drawable.silencer_min_ban,
        R.drawable.silencer_mipmap, 70, 85, 85
    ),
    SKY_MAG(
        107, "Skywrath Mage",
        R.drawable.skymag_picked,
        R.drawable.skymag_icon,
        R.drawable.skymag_large_ban,
        R.drawable.skymag_min_ban,
        R.drawable.skymag_mipmap, 95, 80, 85
    ),
    STORM_SPIRIT(
        108, "Storm Spirit",
        R.drawable.stormspirit_picked,
        R.drawable.stormspirit_icon,
        R.drawable.storm_spirit_large_ban,
        R.drawable.storm_spirit_min_ban,
        R.drawable.stormspirit_mipmap, 70, 90, 85
    ),
    TECHIES(
        109, "Techies",
        R.drawable.techies_picked,
        R.drawable.techies_willow_icon,
        R.drawable.techies_large_ban,
        R.drawable.techies_min_ban,
        R.drawable.techies_mipmap, 65, 50, 95
    ),
    TINKER(
        110, "Tinker",
        R.drawable.tinker_picked,
        R.drawable.tinker_icon,
        R.drawable.tinker_large_ban,
        R.drawable.tinker_min_ban,
        R.drawable.tinker_mipmap, 65, 80, 85
    ),
    VISAGE(
        111, "Visage",
        R.drawable.visage_picked,
        R.drawable.visage_icon,
        R.drawable.visage_large_ban,
        R.drawable.visage_min_ban,
        R.drawable.visage_mipmap, 80, 80, 75
    ),
    WARLOCK(
        112, "Warlock",
        R.drawable.warlock_picked,
        R.drawable.warlock_icon,
        R.drawable.warlock_large_ban,
        R.drawable.warlock_min_ban,
        R.drawable.warlock_mipmap, 80, 90, 75
    ),
    WINDRANGER(
        113, "Windranger",
        R.drawable.windranger_picked,
        R.drawable.windranger_icon,
        R.drawable.windranger_large_ban,
        R.drawable.windranger_min_ban,
        R.drawable.windranger_mipmap, 70, 70, 85
    ),
    WYNTER_WYWERN(
        114, "Winter Wyvern",
        R.drawable.ww_picked,
        R.drawable.ww_icon,
        R.drawable.ww_large_ban,
        R.drawable.ww_min_ban,
        R.drawable.winterwywern_mipmap, 75, 85, 75
    ),
    WITCH_DOCTOR(
        115, "Witch Doctor",
        R.drawable.witchdoctor_picked,
        R.drawable.witch_doctor_icon,
        R.drawable.witch_doctor_large_ban,
        R.drawable.witchdoctor_min_ban,
        R.drawable.witchdoctor_mipmap, 75, 75, 75
    ),
    ZEUS(
        116, "Zeus",
        R.drawable.zeus_picked,
        R.drawable.zeus_icon,
        R.drawable.zeus_large_ban,
        R.drawable.zeus_min_ban,
        R.drawable.zeus_mipmap, 70, 85, 85
    ),
    SNAPFIRE(
        117, "Snapfire",
        R.drawable.snapfire_picked,
        R.drawable.snapfire_icon,
        R.drawable.snapfire_large_ban,
        R.drawable.snapfire_min_ban,
        R.drawable.snapfire_minimap_icon, 75, 85, 70
    ),
    VOID_SPIRIT(
        118, "Void Spirit",
        R.drawable.void_spirit_picked,
        R.drawable.void_spirit_icon,
        R.drawable.void_spirit_large_ban,
        R.drawable.void_spirit_min_ban,
        R.drawable.void_spirit_minimap_icon, 80, 85, 80
    );

}
