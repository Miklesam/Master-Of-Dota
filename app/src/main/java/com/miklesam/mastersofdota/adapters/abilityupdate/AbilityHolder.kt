package com.miklesam.mastersofdota.adapters.abilityupdate

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.daimajia.numberprogressbar.NumberProgressBar
import kotlinx.android.synthetic.main.ability_item.view.*

class AbilityHolder(itemView: View, var abilityListener: OnAbilityListener) :
    RecyclerView.ViewHolder(itemView), View.OnClickListener {
    override fun onClick(p0: View?) {
        abilityListener.onAbilityClick((adapterPosition), this)
    }

    val abilityIcon: ImageView
    val abilityName: TextView

    val abilityProgress: NumberProgressBar
    val abilityPlus: TextView

    init {
        abilityIcon = itemView.abilityIcon
        abilityName = itemView.abilityName
        abilityProgress = itemView.progress_ability
        abilityPlus = itemView.ability_plus

        abilityPlus.setOnClickListener(this)
    }
}