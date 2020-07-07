package com.miklesam.masterofdota.newgame

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.miklesam.masterofdota.PrefsHelper
import com.miklesam.masterofdota.R
import com.miklesam.masterofdota.heroupdate.HeroUpdateViewModel
import com.miklesam.masterofdota.room.HeroProgressList
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
    private val updateViewModel: HeroUpdateViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val nickNameList: nickNameListener = activity as nickNameListener
        nextToNewGame.setOnClickListener {
            scope.launch {
                PrefsHelper.write(
                    PrefsHelper.MMR_COUNT,
                    "500"
                )
                updateViewModel.nukeProgress()
                updateViewModel.initNewProgress(HeroProgressList.AllHeroProgress)
                nickNameList.toNewGameClicked()
            }
        }
    }
}