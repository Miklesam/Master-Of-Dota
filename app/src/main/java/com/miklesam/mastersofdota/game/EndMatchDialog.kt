package com.miklesam.mastersofdota.game

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.core.content.ContextCompat
import com.miklesam.mastersofdota.R
import com.miklesam.mastersofdota.utils.PrefsHelper

class EndMatchDialog() : AppCompatDialogFragment() {
    constructor(myListener: toLobbyInterface, side: Int) : this() {
        mListener = myListener
        sude = side
    }


    var Lock = true
    var sude = 0
    var mListener: toLobbyInterface? = null

    interface toLobbyInterface {
        fun goToLobbyClick(points: Int)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireContext(),R.style.EndDialogTitle)
        val inflater = requireActivity().layoutInflater
        val mycustomview = inflater.inflate(R.layout.layout_end_match_dialog, null)
        val match_result_text = mycustomview.findViewById<TextView>(R.id.match_result_text)
        val pts_view = mycustomview.findViewById<TextView>(R.id.pts_view)
        val currentMMR = PrefsHelper.read(PrefsHelper.MMR_COUNT, "0")
        when (sude) {
            1 -> {
                match_result_text.text = getString(R.string.you_win)
                match_result_text.setTextColor(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.win
                    )
                )
                pts_view.text = "MMR: $currentMMR +30"
                pts_view.setTextColor(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.win
                    )
                )

            }
            2 -> {
                match_result_text.text = getString(R.string.you_lose)
                match_result_text.setTextColor(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.lose
                    )
                )
                pts_view.text = "MMR: $currentMMR -30"
                pts_view.setTextColor(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.lose
                    )
                )
            }
            3 -> {
                match_result_text.text = getString(R.string.draw)
                match_result_text.setTextColor(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.draw
                    )
                )
                pts_view.text = "MMR: $currentMMR +0"
                pts_view.setTextColor(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.draw
                    )
                )
            }
        }




        builder.setView(mycustomview)
        //builder.setTitle(getString(R.string.match_is_over))
        builder.setPositiveButton(getString(R.string.quit)) { _, _ ->
            mListener?.goToLobbyClick(sude)
            Lock = false
        }

        val dialog = builder.create()
        dialog.setCanceledOnTouchOutside(false)
        dialog.setCancelable(false)
        dialog.setOnKeyListener { _, keyCode, _ -> // Prevent dialog close on back press button
            keyCode == KeyEvent.KEYCODE_BACK
        }
        return dialog
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
}