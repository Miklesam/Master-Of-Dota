package com.miklesam.mastersofdota

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.miklesam.mastersofdota.datamodels.Heroes
import kotlinx.android.synthetic.main.fragment_counters.*

class FragmentCountersViews : Fragment(R.layout.fragment_counters) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tt = arguments?.getInt("position") ?: 0
        val myHero = Heroes.values()[tt]
        nameee.text = myHero.heroName
        icon.setImageResource(myHero.image_pick)

    }
}