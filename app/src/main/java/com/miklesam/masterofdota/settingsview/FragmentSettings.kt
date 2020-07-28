package com.miklesam.masterofdota.settingsview

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.miklesam.masterofdota.R
import com.miklesam.masterofdota.adapters.heroupdate.OnHeroListener
import com.miklesam.masterofdota.adapters.settingsadapter.OnSettingsListener
import com.miklesam.masterofdota.adapters.settingsadapter.SettingsAdapter
import com.miklesam.masterofdota.game.EndMatchDialog
import com.miklesam.masterofdota.game.TwoOptionDialog
import kotlinx.android.synthetic.main.fragment_settings.*

class FragmentSettings : Fragment(R.layout.fragment_settings), OnSettingsListener,
    TwoOptionDialog.toLobbyInterface {

    private val settingsViewModel: ViewSettingsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerStreetView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerStreetView?.setHasFixedSize(true)
        val adapter =
            SettingsAdapter(this)
        recyclerStreetView?.adapter = adapter

        settingsViewModel.getViews().observe(viewLifecycleOwner, Observer {
            if (!it.isNullOrEmpty()) {
                val currentState = it
                val yu = currentState
                adapter.setDataFromDB(it)
            }

        })


    }

    override fun onStreetClick(position: Int) {
        val dialog = TwoOptionDialog(this)
        activity?.supportFragmentManager?.let {
            dialog.show(it, "CreateEndMatchDialogDialog")

        }
    }

    override fun goToLobbyClick(points: Int) {
        Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
    }

}