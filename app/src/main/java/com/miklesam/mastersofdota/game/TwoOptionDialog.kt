package com.miklesam.mastersofdota.game

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatDialogFragment
import com.miklesam.mastersofdota.R
import com.miklesam.mastersofdota.datamodels.StreetView
import kotlinx.android.synthetic.main.layout_two_option_dialog.view.*

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
        val view_price = mycustomview.findViewById<TextView>(R.id.match_result_text)
        val priceString = "Price ${StreetView.values()[positionView].price}"
        view_price.text = priceString
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
            dialog.dismiss()
        }

        mycustomview.no_dialog.setOnClickListener {
            Lock = false
            dialog.dismiss()
        }


        return dialog
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    override fun onDestroyView() {
        super.onDestroyView()
        mListener = null
    }
}