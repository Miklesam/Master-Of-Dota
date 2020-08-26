package com.miklesam.mastersofdota

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.miklesam.mastersofdota.adapters.counters.CountersAdapter
import com.miklesam.mastersofdota.adapters.counters.OnCounterListener
import kotlinx.android.synthetic.main.fragment_heroes_update.*

class FragmentCounters : Fragment(R.layout.fragment_heroes_counters), OnCounterListener {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerHeroes.layoutManager = LinearLayoutManager(context)
        recyclerHeroes?.setHasFixedSize(true)
        val adapter =
            CountersAdapter(this)
        recyclerHeroes?.adapter = adapter
    }

    override fun onCounterClick(position: Int) {
        val tr = parentFragmentManager.beginTransaction()
        val fragment = FragmentCountersViews()
        tr.setCustomAnimations(
            R.animator.scaley_enter,
            R.animator.scaley_exit,
            R.animator.scaley_enter,
            R.animator.scaley_exit
        )
        val bundle = Bundle()
        bundle.putInt("position", position)
        fragment.arguments = bundle
        tr.replace(R.id.fragment_holder, fragment)
            .addToBackStack(null)
        tr.commit()
    }
}