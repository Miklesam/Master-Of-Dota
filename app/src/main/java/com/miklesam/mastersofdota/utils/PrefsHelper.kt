package com.miklesam.mastersofdota.utils

import android.content.Context
import android.content.SharedPreferences

object PrefsHelper {

    private lateinit var prefs: SharedPreferences

    private const val PREFS_NAME = "params"
    const val MMR_COUNT = "mmr_count"
    const val NICK_NAME = "nick_name"
    const val STREET_VIEW = "street_view"
    const val HAIR_VIEW = "hair_view"
    const val ENERGY = "energy"
    const val FANS = "fans"
    const val MONEY = "money"
    const val XP = "xp"
    const val DAYS = "days"
    const val MONTH = "month"
    const val YEARS = "years"
    const val YOUR_TEAM_ID = "your_team_id"
    const val CONTINUE_VISIBLE = "continiue_visible"

    fun init(context: Context) {
        prefs = context.getSharedPreferences(
            PREFS_NAME, Context.MODE_PRIVATE
        )
    }

    fun read(key: String, value: String): String? {
        return prefs.getString(key, value)
    }

    fun read(key: String, value: Long): Long? {
        return prefs.getLong(key, value)
    }

    fun write(key: String, value: String) {
        val prefsEditor: SharedPreferences.Editor = prefs.edit()
        with(prefsEditor) {
            putString(key, value)
            commit()
        }
    }

    fun write(key: String, value: Long) {
        val prefsEditor: SharedPreferences.Editor = prefs.edit()
        with(prefsEditor) {
            putLong(key, value)
            commit()
        }
    }
}