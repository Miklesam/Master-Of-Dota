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
        counters1.setImageResource(Heroes.values()[myHero.countretBy[0]].image_pick)
        counters2.setImageResource(Heroes.values()[myHero.countretBy[1]].image_pick)
        counters3.setImageResource(Heroes.values()[myHero.countretBy[2]].image_pick)
        counters4.setImageResource(Heroes.values()[myHero.countretBy[3]].image_pick)
        counters5.setImageResource(Heroes.values()[myHero.countretBy[4]].image_pick)

        goodPicks1.setImageResource(Heroes.values()[myHero.counters[0]].image_pick)
        goodPicks2.setImageResource(Heroes.values()[myHero.counters[1]].image_pick)
        goodPicks3.setImageResource(Heroes.values()[myHero.counters[2]].image_pick)
        goodPicks4.setImageResource(Heroes.values()[myHero.counters[3]].image_pick)
        goodPicks5.setImageResource(Heroes.values()[myHero.counters[4]].image_pick)
    }
}