package com.miklesam.mastersofdota

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.miklesam.mastersofdota.utils.PrefsHelper
import kotlinx.android.synthetic.main.fragment_info.*
import kotlinx.android.synthetic.main.fragment_menu.*
import kotlinx.android.synthetic.main.fragment_services.*


class FragmentInfo : Fragment(R.layout.fragment_info) {

    interface InfoListener {
        fun countersClicked()
        fun statsClicked()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val menuListener = activity as InfoListener
        counters.setOnClickListener { menuListener.countersClicked() }
        stats.setOnClickListener { menuListener.statsClicked() }
    }
}