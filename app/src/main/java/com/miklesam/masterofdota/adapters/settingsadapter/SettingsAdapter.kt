package com.miklesam.masterofdota.adapters.settingsadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.miklesam.masterofdota.datamodels.Heroes
import com.miklesam.masterofdota.R
import com.miklesam.masterofdota.adapters.heroupdate.OnHeroListener
import com.miklesam.masterofdota.datamodels.StreetView
import com.miklesam.masterofdota.datamodels.roommodels.HeroProgress
import com.miklesam.masterofdota.utils.PrefsHelper


class SettingsAdapter(
    val heroListener: OnHeroListener
) : RecyclerView.Adapter<StreetViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StreetViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.street_view_item, parent, false)
        return StreetViewHolder(
            itemView,
            heroListener
        )
    }

    override fun getItemCount(): Int {
        return StreetView.values().size
    }

    override fun onBindViewHolder(holder: StreetViewHolder, position: Int) {
        val currentView = PrefsHelper.read(PrefsHelper.STREET_VIEW, "0")?.toInt()
        val streetView = StreetView.values()[position]
        holder.streetView.setImageResource(streetView.streetImage)
        if (currentView == position) {
            holder.chooseBttn.text = "Выбрано"
        } else {
            holder.chooseBttn.text = "Выбрать"
        }
        holder.chooseBttn.setOnClickListener {
            PrefsHelper.write(PrefsHelper.STREET_VIEW, position.toString())
            holder.chooseBttn.text = "Выбрано"
            notifyDataSetChanged()
        }

    }


}