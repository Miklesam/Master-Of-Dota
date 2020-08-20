package com.miklesam.mastersofdota.adapters.inapp

import android.view.View

interface InnAppProductListener : View.OnClickListener {
    fun onProductClickListener(view: View, position: Int)
}