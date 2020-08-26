package com.miklesam.mastersofdota

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.miklesam.mastersofdota.utils.PrefsHelper
import kotlinx.android.synthetic.main.fragment_menu.*


class FragmentMenu : Fragment(R.layout.fragment_menu) {

    interface MenuListener {
        fun continueClicked()
        fun newGameClicked()
        fun achivmentsClicked()
        fun leaderBoardClicked()
        fun marketClicked()
        fun countersClicked()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val menuListener = activity as MenuListener
        continue_game.setOnClickListener { menuListener.continueClicked() }
        new_game_bttn.setOnClickListener { menuListener.newGameClicked() }
        achivments.setOnClickListener { menuListener.achivmentsClicked() }
        leaderboard.setOnClickListener { menuListener.leaderBoardClicked() }
        market.setOnClickListener { menuListener.marketClicked() }
        counters.setOnClickListener { menuListener.countersClicked() }

        val continueVisible = PrefsHelper.read(
            PrefsHelper.CONTINUE_VISIBLE, "0"
        )?.toInt() ?: 0
        if (continueVisible == 1) {
            continue_game.visibility = View.VISIBLE
        } else {
            continue_game.visibility = View.GONE
        }
    }
}