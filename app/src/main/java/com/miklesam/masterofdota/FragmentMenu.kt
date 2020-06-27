package com.miklesam.masterofdota

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_menu.*


class FragmentMenu :Fragment(R.layout.fragment_menu){

    interface MenuListener {
        fun gameClicked()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val menuListener = activity as MenuListener
        game_bttn.setOnClickListener { menuListener.gameClicked() }
        //number_progress_bar.progress=75
        //number_progress_bar.reachedBarColor=ContextCompat.getColor(requireContext(),R.color.colorPrimary)
    }
}