package com.miklesam.mastersofdota.teamsrequires

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.miklesam.mastersofdota.R
import com.miklesam.mastersofdota.datamodels.ProTeamsEnum
import com.miklesam.mastersofdota.datamodels.roommodels.AbilityProgress
import com.miklesam.mastersofdota.playerupdate.AbilityUpdateViewModel
import com.miklesam.mastersofdota.utils.PrefsHelper
import com.miklesam.mastersofdota.utils.showCustomToast
import kotlinx.android.synthetic.main.fragment_twitter.icon_logo
import kotlinx.android.synthetic.main.fragment_twitter.your_nickname
import kotlinx.android.synthetic.main.proteams_require.*


class FragmentTeamRequirement : Fragment(R.layout.proteams_require) {
    private val requiresViewModel: TeamRequireViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tt = arguments?.getInt("position") ?: 0

        icon_logo.setImageResource(ProTeamsEnum.values()[tt].teamLogo)
        your_nickname.text = ProTeamsEnum.values()[tt].teamName
        var requiersListText = ""
        val requires = ProTeamsEnum.values()[tt].requires
        ProTeamsEnum.values()[tt].requires.forEach {
            requiersListText += "${it.first.nameAbility} > ${it.second}\n"
        }

        requersList.text = requiersListText
        var updateAbilitiesList: List<AbilityProgress> = emptyList()
        requiresViewModel.getAbilities().observe(viewLifecycleOwner, Observer {
            if (!it.isNullOrEmpty()) updateAbilitiesList = it

        })



        try_to_join.setOnClickListener {
            var join = true
            for (req in requires) {
                if (updateAbilitiesList[req.first.id].progress <= req.second) {
                    showCustomToast(
                        "Progress ${req.first.nameAbility} is less then ${req.second + 1}",
                        Toast.LENGTH_SHORT
                    )
                    join = false
                    break
                }
            }
            if (join) {
                PrefsHelper.write(PrefsHelper.YOUR_TEAM_ID, tt.toString())
                showCustomToast(
                    "Join success",
                    Toast.LENGTH_SHORT
                )
            }
        }
    }
}