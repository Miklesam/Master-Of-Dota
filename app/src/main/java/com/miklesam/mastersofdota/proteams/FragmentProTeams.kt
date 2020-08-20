package com.miklesam.mastersofdota.proteams

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.miklesam.mastersofdota.teamsrequires.FragmentTeamRequirement
import com.miklesam.mastersofdota.R
import com.miklesam.mastersofdota.adapters.proteams.OnProTeamsListener
import com.miklesam.mastersofdota.adapters.proteams.ProTeamsAdapter
import com.miklesam.mastersofdota.utils.showCustomToast
import kotlinx.android.synthetic.main.fragment_proteams.*

class FragmentProTeams : Fragment(R.layout.fragment_proteams), OnProTeamsListener {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        teamsRecycler.layoutManager = LinearLayoutManager(context)
        teamsRecycler?.setHasFixedSize(true)
        val adapter =
            ProTeamsAdapter(this)
        teamsRecycler?.adapter = adapter
    }

    override fun onHeroClick(position: Int) {
        showCustomToast("position $position", Toast.LENGTH_SHORT)


        val transaction = parentFragmentManager.beginTransaction()
        val fragment =
            FragmentTeamRequirement()
        transaction.setCustomAnimations(
            R.animator.scaley_enter,
            R.animator.scaley_exit,
            R.animator.stack_left_in,
            R.animator.stack_right_out

        )
        val bundle = Bundle()
        bundle.putInt("position", position)
        fragment.arguments = bundle
        transaction.replace(R.id.fragment_holder, fragment)
            .addToBackStack(null)
        transaction.commit()
    }
}