package com.miklesam.mastersofdota

import android.app.Application
import com.miklesam.mastersofdota.utils.PrefsHelper
import values.TypefaceUtil


class ApplicationMasterOfDota :Application(){
    override fun onCreate() {
        super.onCreate()
        PrefsHelper.init(this)
        TypefaceUtil.overrideFont(applicationContext, "SANS_SERIF", "fonts/16606.ttf")
    }
}