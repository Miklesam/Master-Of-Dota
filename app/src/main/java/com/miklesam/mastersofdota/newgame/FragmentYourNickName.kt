package com.miklesam.mastersofdota.newgame

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.miklesam.mastersofdota.utils.PrefsHelper
import com.miklesam.mastersofdota.R
import com.miklesam.mastersofdota.room.hero.HeroProgressList
import com.miklesam.mastersofdota.room.ability.AbilityProgressList
import kotlinx.android.synthetic.main.fragment_your_nickname.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch


class FragmentYourNickName : Fragment(R.layout.fragment_your_nickname) {

    interface nickNameListener {
        fun toNewGameClicked()
    }

    val scope = CoroutineScope(Dispatchers.IO + SupervisorJob())
    private val updateViewModel: NewGameViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val nickNameList: nickNameListener = activity as nickNameListener
        nextToNewGame.setOnClickListener {
            scope.launch {
                PrefsHelper.write(
                    PrefsHelper.MMR_COUNT,
                    "500"
                )
                PrefsHelper.write(
                    PrefsHelper.FANS,
                    "0"
                )
                PrefsHelper.write(
                    PrefsHelper.MONEY,
                    "100"
                )
                PrefsHelper.write(
                    PrefsHelper.DAYS,
                    "0"
                )
                PrefsHelper.write(
                    PrefsHelper.ENERGY,
                    "100"
                )
                PrefsHelper.write(
                    PrefsHelper.XP,
                    "0"
                )
                PrefsHelper.write(
                    PrefsHelper.MONTH,
                    "0"
                )
                PrefsHelper.write(
                    PrefsHelper.YEARS,
                    "0"
                )
                PrefsHelper.write(
                    PrefsHelper.NICK_NAME,
                    nickNameEdit.text.toString()
                )
                PrefsHelper.write(
                    PrefsHelper.YOUR_TEAM_ID,
                    "3000"
                )
                PrefsHelper.write(
                    PrefsHelper.CONTINUE_VISIBLE,
                    "1"
                )
                updateViewModel.nukeHeroesProgress()
                updateViewModel.nukeAbilityProgress()
                updateViewModel.initNewHeroesProgress(HeroProgressList.AllHeroProgress)
                updateViewModel.initNewAbilityProgress(AbilityProgressList.AllAbilityProgress)

                nickNameList.toNewGameClicked()
            }
        }
    }
}