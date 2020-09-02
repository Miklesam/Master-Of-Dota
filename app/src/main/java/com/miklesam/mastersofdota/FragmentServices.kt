package com.miklesam.mastersofdota

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.miklesam.mastersofdota.utils.PrefsHelper
import kotlinx.android.synthetic.main.fragment_menu.*
import kotlinx.android.synthetic.main.fragment_services.*


class FragmentServices : Fragment(R.layout.fragment_services) {

    interface ServicesListener {
        fun achivmentsClicked()
        fun leaderBoardClicked()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val menuListener = activity as ServicesListener
        achivments.setOnClickListener { menuListener.achivmentsClicked() }
        leaderboard.setOnClickListener { menuListener.leaderBoardClicked() }
    }
}