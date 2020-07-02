package com.miklesam.masterofdota

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_menu.*
import kotlinx.android.synthetic.main.fragment_your_nickname.*


class FragmentYourNickName :Fragment(R.layout.fragment_your_nickname){

    interface nickNameListener {
        fun toNewGameClicked()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val nickNameList:nickNameListener = activity as nickNameListener
        nextToNewGame.setOnClickListener {
            PrefsHelper.write(PrefsHelper.MMR_COUNT,"500")
            nickNameList.toNewGameClicked()
        }
    }
}