package com.miklesam.mastersofdota.settingsview

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.miklesam.mastersofdota.R
import com.miklesam.mastersofdota.adapters.hairadapter.HairsAdapter
import com.miklesam.mastersofdota.adapters.hairadapter.OnHairsListener
import com.miklesam.mastersofdota.adapters.settingsadapter.OnSettingsListener
import com.miklesam.mastersofdota.adapters.settingsadapter.SettingsAdapter
import com.miklesam.mastersofdota.datamodels.HairView
import com.miklesam.mastersofdota.datamodels.StreetView
import com.miklesam.mastersofdota.datamodels.roommodels.HairViewBlocked
import com.miklesam.mastersofdota.datamodels.roommodels.StreetViewBlocked
import com.miklesam.mastersofdota.game.TwoOptionDialog
import com.miklesam.mastersofdota.utils.PrefsHelper
import com.miklesam.mastersofdota.utils.SettingsType
import com.miklesam.mastersofdota.utils.showCustomToast
import kotlinx.android.synthetic.main.fragment_settings.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class FragmentSettings : Fragment(R.layout.fragment_settings), OnSettingsListener,
    TwoOptionDialog.toLobbyInterface, OnHairsListener {

    private val settingsViewModel: ViewSettingsViewModel by viewModels()
    val scope = CoroutineScope(Dispatchers.IO + SupervisorJob())
    private lateinit var streetList: List<StreetViewBlocked>
    private lateinit var hairList: List<HairViewBlocked>
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerStreetView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerStreetView?.setHasFixedSize(true)

        recyclerColorHair.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerColorHair?.setHasFixedSize(true)
        val adapter =
            SettingsAdapter(this)
        val hairAdapter =
            HairsAdapter(this)

        recyclerStreetView?.adapter = adapter
        recyclerColorHair?.adapter = hairAdapter
        settingsViewModel.getStreetViews().observe(viewLifecycleOwner, Observer {
            if (!it.isNullOrEmpty()) {
                streetList = it
                adapter.setDataFromDB(it)
            }
        })

        settingsViewModel.getHairViews().observe(viewLifecycleOwner, Observer {
            if (!it.isNullOrEmpty()) {
                hairList = it
                hairAdapter.setDataFromDB(it)
            }
        })


    }

    override fun onStreetClick(position: Int) {
        val dialog = TwoOptionDialog(this, position, SettingsType.Street)
        activity?.supportFragmentManager?.let {
            dialog.show(it, null)
        }
    }

    override fun updateStreetClick(position: Int) {
        val currentMoney = PrefsHelper.read(PrefsHelper.MONEY, "0")?.toInt() ?: 0
        if ((currentMoney - StreetView.values()[position].price) >= 0) {
            scope.launch {
                val street = streetList[position]
                street.unblocked = true
                settingsViewModel.updateStreetView(street)
                PrefsHelper.write(
                    PrefsHelper.MONEY,
                    (currentMoney - StreetView.values()[position].price).toString()
                )
            }
        } else {
            showCustomToast("Not Enough Money", Toast.LENGTH_SHORT)
        }
    }

    override fun updateHairClick(position: Int) {
        val currentMoney = PrefsHelper.read(PrefsHelper.MONEY, "0")?.toInt() ?: 0
        if ((currentMoney - HairView.values()[position].price) >= 0) {
            scope.launch {
                val hair = hairList[position]
                hair.unblocked = true
                settingsViewModel.updateHairView(hair)
                PrefsHelper.write(
                    PrefsHelper.MONEY,
                    (currentMoney - HairView.values()[position].price).toString()
                )
            }
        } else {
            showCustomToast("Not Enough Money", Toast.LENGTH_SHORT)
        }
    }

    override fun onHairClick(position: Int) {
        val dialog = TwoOptionDialog(this, position, SettingsType.Hair)
        activity?.supportFragmentManager?.let {
            dialog.show(it, null)
        }
    }

}