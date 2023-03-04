package com.example.my_new_first_chat.utils

import android.content.Context
import android.content.SharedPreferences

object SharedPreferenceUtil {

    private lateinit var preferences: SharedPreferences
    private lateinit var proverka: SharedPreferences
    private lateinit var dataConfig: SharedPreferences

    fun units(context: Context) {
        preferences = context.getSharedPreferences("shared", Context.MODE_PRIVATE)
    }

    var isPreference: Boolean
        get() = preferences.getBoolean("preference", false)
        set(value) = preferences.edit().putBoolean("preference", value).apply()

    fun unitProver(context: Context) {
        proverka = context.getSharedPreferences("shared", Context.MODE_PRIVATE)
    }

    var isProver: Boolean
        get() = proverka.getBoolean("proverka", false)
        set(value) = proverka.edit().putBoolean("proverka", value).apply()

    fun unitsData(context: Context) {
        dataConfig = context.getSharedPreferences("shared", Context.MODE_PRIVATE)
    }

    var dataAdmin: String?
        get() = dataConfig.getString("dataAdmin", "")
        set(value) = dataConfig.edit().putString("dataAdmin" , value).apply()
}