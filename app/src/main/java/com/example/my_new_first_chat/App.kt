package com.example.my_new_first_chat

import android.app.Application
import com.example.my_new_first_chat.utils.SharedPreferenceUtil

class App : Application(){

    override fun onCreate() {
        super.onCreate()
        SharedPreferenceUtil.unitProver(this)
        SharedPreferenceUtil.units(this)
        SharedPreferenceUtil.unitsData(this)
    }
}