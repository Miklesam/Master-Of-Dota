package com.miklesam.masterofdota

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager

class MainActivity : AppCompatActivity(), FragmentMenu.MenuListener, FragmentRoom.roomListener,
    FragmentPickStage.nextFromPick {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        if (savedInstanceState==null){
            showMenuFragment()
        }

    }



    override fun gameClicked() {
        showRoomFragment()
    }

    private fun showRoomFragment(){
        val transaction = supportFragmentManager.beginTransaction()
        val fragment = FragmentRoom()
        transaction.setCustomAnimations(
            R.animator.scaley_enter,
            R.animator.scaley_exit,
            R.animator.scaley_enter,
            R.animator.scaley_exit

        )
        transaction.replace(R.id.fragment_holder, fragment)
            .addToBackStack(null)
        transaction.commit()

    }

    private fun showMenuFragment(){
        val transaction = supportFragmentManager.beginTransaction()
        val fragment = FragmentMenu()
        transaction.replace(R.id.fragment_holder, fragment)
        transaction.commit()
    }

    override fun gamePlayClicked() {
        val transaction = supportFragmentManager.beginTransaction()
        val fragment = FragmentPickStage()
        transaction.setCustomAnimations(
            R.animator.card_flip_vertical_right_in,
            R.animator.card_flip_vertical_left_out,
            R.animator.card_flip_vertical_left_in,
            R.animator.card_flip_vertical_right_out
        )
        transaction.replace(R.id.fragment_holder, fragment)
            .addToBackStack(null)
        transaction.commit()
    }

    override fun pickEnded(radiant: ArrayList<Int>, direPicks: ArrayList<Int>) {
        TODO("Not yet implemented")
    }

}