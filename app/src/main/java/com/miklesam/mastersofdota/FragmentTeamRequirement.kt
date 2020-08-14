package com.miklesam.mastersofdota

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.miklesam.mastersofdota.datamodels.ProTeamsEnum
import com.miklesam.mastersofdota.utils.PrefsHelper
import com.miklesam.mastersofdota.utils.showCustomToast
import kotlinx.android.synthetic.main.fragment_twitter.*
import kotlinx.android.synthetic.main.fragment_twitter.icon_logo
import kotlinx.android.synthetic.main.fragment_twitter.your_nickname
import kotlinx.android.synthetic.main.proteams_require.*
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.Main


class FragmentTeamRequirement : Fragment(R.layout.proteams_require) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        icon_logo.setImageResource(ProTeamsEnum.values()[0].teamLogo)
        your_nickname.text = ProTeamsEnum.values()[0].teamName
        var requiersListText = ""
        ProTeamsEnum.values()[0].requires.forEach {
            requiersListText += "${it.first.nameAbility} > ${it.second}\n"
        }

        requersList.text = requiersListText

    }
}