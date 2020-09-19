package com.miklesam.mastersofdota.game

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatDialogFragment
import com.miklesam.mastersofdota.R
import com.miklesam.mastersofdota.datamodels.Heroes
import com.miklesam.mastersofdota.utils.PrefsHelper
import kotlin.math.sqrt

class PickInfoDialog() : AppCompatDialogFragment() {
    constructor(
        myListener: toGame,
        playerPick: Int,
        enemyList: ArrayList<Int>,
        heroProgress: Int
    ) : this() {
        mListener = myListener
        this.playerPick = playerPick
        this.enemyList = enemyList
        this.heroProgress = heroProgress
    }


    var Lock = true
    var mListener: toGame? = null
    var playerPick: Int = 0
    var heroProgress: Int = 0
    var enemyList = ArrayList<Int>()

    var tottalPicksPoint = 0

    interface toGame {
        fun goToGameClick(percentPointsToWin: Int)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireContext(), R.style.EndDialogTitle)
        val inflater = requireActivity().layoutInflater
        val mycustomview = inflater.inflate(R.layout.layout_pick_info_dialog, null)
        val heroImage = mycustomview.findViewById<ImageView>(R.id.heroImage)
        val enemyPick1 = mycustomview.findViewById<ImageView>(R.id.enemyPick1)
        val enemyPick2 = mycustomview.findViewById<ImageView>(R.id.enemyPick2)
        val enemyPick3 = mycustomview.findViewById<ImageView>(R.id.enemyPick3)
        val enemyPick4 = mycustomview.findViewById<ImageView>(R.id.enemyPick4)
        val enemyPick5 = mycustomview.findViewById<ImageView>(R.id.enemyPick5)

        val text1 = mycustomview.findViewById<TextView>(R.id.text1)
        val text2 = mycustomview.findViewById<TextView>(R.id.text2)
        val text3 = mycustomview.findViewById<TextView>(R.id.text3)
        val text4 = mycustomview.findViewById<TextView>(R.id.text4)
        val text5 = mycustomview.findViewById<TextView>(R.id.text5)

        val progressHero = mycustomview.findViewById<TextView>(R.id.progressHero)
        val percentToWin = mycustomview.findViewById<TextView>(R.id.percentToWin)


        val pts_view = mycustomview.findViewById<TextView>(R.id.pts_view)
        val currentMMR = PrefsHelper.read(PrefsHelper.MMR_COUNT, "0")
        heroImage.setImageResource(Heroes.values()[playerPick].image_pick)

        enemyPick1.setImageResource(Heroes.values()[enemyList[0]].image_pick)
        enemyPick2.setImageResource(Heroes.values()[enemyList[1]].image_pick)
        enemyPick3.setImageResource(Heroes.values()[enemyList[2]].image_pick)
        enemyPick4.setImageResource(Heroes.values()[enemyList[3]].image_pick)
        enemyPick5.setImageResource(Heroes.values()[enemyList[4]].image_pick)


        val y1 = getWithHero(enemyPick1, enemyList[0])
        text1.text = y1

        val y2 = getWithHero(enemyPick2, enemyList[1])
        text2.text = y2

        val y3 = getWithHero(enemyPick3, enemyList[2])
        text3.text = y3

        val y4 = getWithHero(enemyPick4, enemyList[3])
        text4.text = y4

        val y5 = getWithHero(enemyPick5, enemyList[4])
        text5.text = y5

        progressHero.text = "Progress Hero is $heroProgress"


        val percentPointsToWin = tottalPicksPoint + 2 * sqrt(heroProgress.toDouble()).toInt()

        percentToWin.text = "Extra points $percentPointsToWin"

        builder.setView(mycustomview)
        //builder.setTitle(getString(R.string.match_is_over))
        builder.setPositiveButton("Next") { _, _ ->
            mListener?.goToGameClick(percentPointsToWin)
            Lock = false
            dialog?.dismiss()
        }

        val dialog = builder.create()
        dialog.setCanceledOnTouchOutside(false)
        dialog.setCancelable(false)
        dialog.setOnKeyListener { _, keyCode, _ -> // Prevent dialog close on back press button
            keyCode == KeyEvent.KEYCODE_BACK
        }
        return dialog
    }


    fun getWithHero(enemy: ImageView, hero: Int): String {
        return when {
            Heroes.values()[playerPick].countretBy.contains(hero) -> {
                enemy.setBackgroundResource(R.drawable.frame_countered_by)
                tottalPicksPoint -= 10
                "-10"
            }
            Heroes.values()[playerPick].counters.contains(hero) -> {
                enemy.setBackgroundResource(R.drawable.frame_good_picks)
                tottalPicksPoint += 5
                "+5"
            }
            else -> {
                "="
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
}