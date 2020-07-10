package com.miklesam.masterofdota.adapters.abilityupdate

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.miklesam.masterofdota.PersonalAbility
import com.miklesam.masterofdota.R
import com.miklesam.masterofdota.datamodels.HeroProgress


class AbilityAdapter(
    val abilityListener: OnAbilityListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var progressHeroesList: List<HeroProgress>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            ITEM_HEADER -> {
                val itemView = LayoutInflater.from(parent.context)
                    .inflate(R.layout.empty_item, parent, false)
                return EmptyHolder(
                    itemView
                )
            }
            else -> {
                val itemView = LayoutInflater.from(parent.context)
                    .inflate(R.layout.ability_item, parent, false)
                return AbilityHolder(
                    itemView,
                    abilityListener
                )
            }
        }

    }

    override fun getItemCount(): Int {
        return PersonalAbility.values().size
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> ITEM_HEADER
            else -> ITEM_DEFAULT
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when (holder) {
            is AbilityHolder -> {
                val ability = PersonalAbility.values()[position]
                holder.abilityName.text = ability.nameAbility
                //holder.abilityIcon.setImageResource(ability.image_pick)
                holder.abilityProgress.progress = progressHeroesList?.get(position)?.progress ?: 0
                //holder.heroLateGame.text = hero.lateGame.toString()
            }
        }

    }

    fun setProgressList(heroes: List<HeroProgress>) {
        progressHeroesList = heroes
    }

    companion object {
        const val ITEM_HEADER = 0
        const val ITEM_DEFAULT = 1
    }

}