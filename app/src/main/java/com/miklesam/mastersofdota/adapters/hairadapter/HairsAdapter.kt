package com.miklesam.mastersofdota.adapters.hairadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.miklesam.mastersofdota.R
import com.miklesam.mastersofdota.datamodels.HairView
import com.miklesam.mastersofdota.datamodels.StreetView
import com.miklesam.mastersofdota.datamodels.roommodels.HairViewBlocked
import com.miklesam.mastersofdota.datamodels.roommodels.StreetViewBlocked
import com.miklesam.mastersofdota.utils.PrefsHelper


class HairsAdapter(
    val heroListener: OnHairsListener
) : RecyclerView.Adapter<HairViewHolder>() {

    var dbSettings: List<HairViewBlocked>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HairViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.hair_view_item, parent, false)
        return HairViewHolder(
            itemView,
            heroListener
        )
    }

    override fun getItemCount(): Int {
        return HairView.values().size
    }

    override fun onBindViewHolder(holder: HairViewHolder, position: Int) {
        val currentView = PrefsHelper.read(PrefsHelper.HAIR_VIEW, "0")?.toInt()
        val streetView = HairView.values()[position]
        holder.streetView.setImageResource(streetView.headIma)

        dbSettings?.let {
            if (it[position].unblocked) {
                holder.chooseBttn.text = "Choose"
            } else {
                holder.chooseBttn.text = "Unblock\n${streetView.price}"
            }
        }
        if (currentView == position) {
            holder.chooseBttn.text = "Selected"
        }
        holder.chooseBttn.setOnClickListener {
            dbSettings?.let {
                if (it[position].unblocked) {
                    PrefsHelper.write(PrefsHelper.HAIR_VIEW, position.toString())
                    holder.chooseBttn.text = "Selected"
                    notifyDataSetChanged()
                } else {
                    heroListener.onHairClick(position)
                }
            }


        }

    }

    fun setDataFromDB(it: List<HairViewBlocked>) {
        dbSettings = it
        notifyDataSetChanged()
    }


}