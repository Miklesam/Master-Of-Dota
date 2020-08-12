package com.miklesam.mastersofdota.utils

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.miklesam.mastersofdota.R


fun Fragment.showCustomToast(message: String, long: Int) {
    val toast = Toast(this.context)
    toast.duration = Toast.LENGTH_LONG
    val inflater =
        context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    val view: View = inflater.inflate(R.layout.your_custom_layout, null)
    val customToastText = view.findViewById<TextView>(R.id.customToastText)
    toast.view = view
    customToastText.text = message
    toast.duration = long
    toast.show()
}


fun Fragment.plusDay() {
    val currentDay = PrefsHelper.read(
        PrefsHelper.DAYS, "0"
    )?.toInt() ?: 0

    val currentMonth = PrefsHelper.read(
        PrefsHelper.MONTH, "0"
    )?.toInt() ?: 0

    val currentYear = PrefsHelper.read(
        PrefsHelper.YEARS, "0"
    )?.toInt() ?: 0
    if (currentDay == 30) {
        PrefsHelper.write(PrefsHelper.DAYS, "0")

        if (currentMonth == 11) {
            PrefsHelper.write(PrefsHelper.MONTH, "0")
            PrefsHelper.write(PrefsHelper.YEARS, (currentYear + 1).toString())
        } else {
            PrefsHelper.write(PrefsHelper.MONTH, (currentMonth + 1).toString())
        }
    } else {
        PrefsHelper.write(PrefsHelper.DAYS, (currentDay + 1).toString())
    }

}


fun Fragment.hideKeyboard() {
    val view = this.activity?.currentFocus
    if (view != null) {
        val imm =
            this.activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}

fun View.Visible() {
    visibility = View.VISIBLE
}

fun View.InVisible() {
    visibility = View.INVISIBLE
}

fun View.Gone() {
    visibility = View.GONE
}

fun View.setVisibility(state: Boolean?) {
    visibility = when (state) {
        true -> View.VISIBLE
        false -> View.INVISIBLE
        null -> View.GONE
    }
}
