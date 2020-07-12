package com.miklesam.masterofdota.adapters.abilityupdate

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.miklesam.masterofdota.datamodels.PersonalAbility
import com.miklesam.masterofdota.R
import com.miklesam.masterofdota.datamodels.roommodels.AbilityProgress
import com.miklesam.masterofdota.datamodels.roommodels.HeroProgress


class AbilityAdapter(
    val abilityListener: OnAbilityListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var progressHeroesList: List<AbilityProgress>? = null

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
        return PersonalAbility.values().size + 3
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0, 6, 13 -> ITEM_HEADER
            else -> ITEM_DEFAULT
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when (holder) {
            is AbilityHolder -> {
                val ability = if (position > 13) {
                    holder.abilityProgress.progress =
                        progressHeroesList?.get(position - 3)?.progress ?: 0
                    PersonalAbility.values()[position - 3]
                } else if (position > 6) {
                    holder.abilityProgress.progress =
                        progressHeroesList?.get(position - 2)?.progress ?: 0
                    PersonalAbility.values()[position - 2]
                } else {
                    holder.abilityProgress.progress =
                        progressHeroesList?.get(position - 1)?.progress ?: 0
                    PersonalAbility.values()[position - 1]
                }

                holder.abilityName.text = ability.nameAbility
                //holder.abilityIcon.setImageResource(ability.image_pick)
                //holder.heroLateGame.text = hero.lateGame.toString()
            }
            is EmptyHolder -> {
                when (position) {
                    0 -> {
                        holder.abilityTitle.text = "Technical characteristics"
                    }
                    6 -> {
                        holder.abilityTitle.text = "Moral characteristics"
                    }
                    13 -> {
                        holder.abilityTitle.text = "Game characteristics"
                    }
                }

            }
        }

    }

    fun setProgressList(abilities: List<AbilityProgress>) {
        progressHeroesList = abilities
    }

    companion object {
        const val ITEM_HEADER = 0
        const val ITEM_DEFAULT = 1
    }

}