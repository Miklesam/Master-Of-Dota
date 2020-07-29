package com.miklesam.masterofdota.game

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.core.content.ContextCompat
import com.miklesam.masterofdota.R
import com.miklesam.masterofdota.utils.PrefsHelper
import kotlinx.android.synthetic.main.layout_two_option_dialog.view.*
import java.text.FieldPosition

class TwoOptionDialog() : AppCompatDialogFragment() {
    constructor(myListener: toLobbyInterface, position: Int) : this() {
        mListener = myListener
        positionView = position
    }


    var Lock = true
    var positionView = 0
    var mListener: toLobbyInterface? = null

    interface toLobbyInterface {
        fun goToLobbyClick(position: Int)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireContext(), R.style.EndDialogTitle)
        val inflater = requireActivity().layoutInflater
        val mycustomview = inflater.inflate(R.layout.layout_two_option_dialog, null)
        val match_result_text = mycustomview.findViewById<TextView>(R.id.match_result_text)
        val pts_view = mycustomview.findViewById<TextView>(R.id.pts_view)
        val currentMMR = PrefsHelper.read(PrefsHelper.MMR_COUNT, "0")


        builder.setView(mycustomview)

        val dialog = builder.create()
        dialog.setCanceledOnTouchOutside(false)
        dialog.setCancelable(false)
        dialog.setOnKeyListener { _, keyCode, _ -> // Prevent dialog close on back press button
            keyCode == KeyEvent.KEYCODE_BACK
        }

        mycustomview.yes_dialog.setOnClickListener {
            mListener?.goToLobbyClick(positionView)
            Lock = false
            dialog.hide()
        }


        return dialog
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
}