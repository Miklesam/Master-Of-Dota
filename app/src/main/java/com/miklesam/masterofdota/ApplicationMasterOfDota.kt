package com.miklesam.masterofdota

import android.app.Application
import values.TypefaceUtil


class ApplicationMasterOfDota :Application(){
    override fun onCreate() {
        super.onCreate()
        PrefsHelper.init(this)
        TypefaceUtil.overrideFont(applicationContext, "SANS_SERIF", "fonts/16606.ttf")
    }
}