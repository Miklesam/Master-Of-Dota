package com.miklesam.mastersofdota.settingsview

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.miklesam.mastersofdota.R
import com.miklesam.mastersofdota.adapters.settingsadapter.OnSettingsListener
import com.miklesam.mastersofdota.adapters.settingsadapter.SettingsAdapter
import com.miklesam.mastersofdota.datamodels.roommodels.StreetViewBlocked
import com.miklesam.mastersofdota.game.TwoOptionDialog
import kotlinx.android.synthetic.main.fragment_settings.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class FragmentSettings : Fragment(R.layout.fragment_settings), OnSettingsListener,
    TwoOptionDialog.toLobbyInterface {

    private val settingsViewModel: ViewSettingsViewModel by viewModels()
    val scope = CoroutineScope(Dispatchers.IO + SupervisorJob())
    private lateinit var streetList: List<StreetViewBlocked>
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
                streetList = it
                adapter.setDataFromDB(it)
            }

        })


    }

    override fun onStreetClick(position: Int) {
        val dialog = TwoOptionDialog(this, position)
        activity?.supportFragmentManager?.let {
            dialog.show(it, "CreateEndMatchDialogDialog")

        }
    }

    override fun goToLobbyClick(position: Int) {
        scope.launch {
            val street = streetList[position]
            street.unblocked = true
            settingsViewModel.updateStreetView(street)
        }
    }

}