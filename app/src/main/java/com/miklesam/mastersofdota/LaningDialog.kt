package com.miklesam.mastersofdota

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatDialogFragment
import com.miklesam.mastersofdota.datamodels.Heroes

class LaningDialog() : AppCompatDialogFragment() {
    constructor(myListener: NoticeDialogListener, heroes: ArrayList<Int>?) : this() {
        mListener = myListener
        heroesList = heroes
    }

    private var lock = true
    private var mListener: NoticeDialogListener? = null
    private var heroesList: ArrayList<Int>? = null
    private lateinit var lane1: RadioGroup
    private lateinit var lane2: RadioGroup
    private lateinit var lane3: RadioGroup
    private lateinit var lane4: RadioGroup
    private lateinit var lane5: RadioGroup

    override fun onDestroyView() {
        super.onDestroyView()
        mListener = null
        heroesList = null
    }

    interface NoticeDialogListener {
        fun onDialogPositiveClick(position: Array<Int>)
        fun onHide()
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireContext())
        val inflater = requireActivity().layoutInflater
        val mycustomview = inflater.inflate(R.layout.layout_dialog, null)
        lane1 = mycustomview.findViewById(R.id.firstGroup)
        lane2 = mycustomview.findViewById(R.id.secondGroup)
        lane3 = mycustomview.findViewById(R.id.thirdGroup)
        lane4 = mycustomview.findViewById(R.id.fourthGroup)
        lane5 = mycustomview.findViewById(R.id.fifthGroup)


        //AllHeroes.clear()
        //HeroInit()

        builder.setView(mycustomview)
        builder.setTitle("Assign heroes along the lines ")
        builder.setPositiveButton("Assign") { _, _ ->
            mListener?.onDialogPositiveClick(
                arrayOf(
                    getIndexOfChild(lane1),
                    getIndexOfChild(lane2),
                    getIndexOfChild(lane3),
                    getIndexOfChild(lane4),
                    getIndexOfChild(lane5)
                )
            )
            lock = false

        }
        builder.setNegativeButton(R.string.hide){_,_->
            mListener?.onHide()
            dismiss()
        }

        val imaopl = mycustomview.findViewById<ImageView>(R.id.ima1)
        val imaop2 = mycustomview.findViewById<ImageView>(R.id.ima2)
        val imaop3 = mycustomview.findViewById<ImageView>(R.id.ima3)
        val imaop4 = mycustomview.findViewById<ImageView>(R.id.ima4)
        val imaop5 = mycustomview.findViewById<ImageView>(R.id.ima5)
        imaopl.setImageResource(Heroes.values().find { it.id == heroesList?.get(0) ?: 0 }!!.mipmap)
        imaop2.setImageResource(Heroes.values().find { it.id == heroesList?.get(1) ?: 0 }!!.mipmap)
        imaop3.setImageResource(Heroes.values().find { it.id == heroesList?.get(2) ?: 0 }!!.mipmap)
        imaop4.setImageResource(Heroes.values().find { it.id == heroesList?.get(3) ?: 0 }!!.mipmap)
        imaop5.setImageResource(Heroes.values().find { it.id == heroesList?.get(4) ?: 0 }!!.mipmap)
        val dialog = builder.create()
        dialog.setCanceledOnTouchOutside(false)
        return dialog
    }


    private fun getIndexOfChild(radioGroup: RadioGroup): Int {
        val radioButtonID: Int = radioGroup.getCheckedRadioButtonId()
        val radioButton: View = radioGroup.findViewById(radioButtonID)
        val idx: Int = radioGroup.indexOfChild(radioButton)
        return idx
    }
}