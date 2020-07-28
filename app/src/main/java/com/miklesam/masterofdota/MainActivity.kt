package com.miklesam.masterofdota

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.miklesam.masterofdota.game.FragmentGame
import com.miklesam.masterofdota.heroupdate.FragmentHeroesUpdate
import com.miklesam.masterofdota.newgame.FragmentYourNickName
import com.miklesam.masterofdota.pickstage.FragmentPickStage
import com.miklesam.masterofdota.playerupdate.FragmentPlayerUpdate
import com.miklesam.masterofdota.settingsview.FragmentSettings

class MainActivity : AppCompatActivity(), FragmentMenu.MenuListener, FragmentRoom.roomListener,
    FragmentPickStage.nextFromPick, FragmentGame.backToLobby,
    FragmentYourNickName.nickNameListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        if (savedInstanceState == null) {
            showMenuFragment()
        }

    }


    override fun continueClicked() {
        showRoomFragment()
    }

    override fun newGameClicked() {
        val transaction = supportFragmentManager.beginTransaction()
        val fragment = FragmentYourNickName()
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

    private fun showRoomFragment() {
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

    private fun showMenuFragment() {
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

    override fun heroesUpdateClicked() {
        val transaction = supportFragmentManager.beginTransaction()
        val fragment =
            FragmentHeroesUpdate()
        transaction.setCustomAnimations(
            R.animator.scaley_enter,
            R.animator.scaley_exit,
            R.animator.stack_left_in,
            R.animator.stack_right_out

        )
        transaction.replace(R.id.fragment_holder, fragment)
            .addToBackStack(null)
        transaction.commit()
    }

    override fun playerUpdateClicked() {
        val transaction = supportFragmentManager.beginTransaction()
        val fragment =
            FragmentPlayerUpdate()
        transaction.setCustomAnimations(
            R.animator.scaley_enter,
            R.animator.scaley_exit,
            R.animator.stack_left_in,
            R.animator.stack_right_out

        )
        transaction.replace(R.id.fragment_holder, fragment)
            .addToBackStack(null)
        transaction.commit()
    }

    override fun settingsClicked() {
        val transaction = supportFragmentManager.beginTransaction()
        val fragment =
            FragmentSettings()
        transaction.setCustomAnimations(
            R.animator.scaley_enter,
            R.animator.scaley_exit,
            R.animator.stack_left_in,
            R.animator.stack_right_out

        )
        transaction.replace(R.id.fragment_holder, fragment)
            .addToBackStack(null)
        transaction.commit()
    }

    override fun pickEnded(radiant: ArrayList<Int>, direPicks: ArrayList<Int>) {
        val transaction = supportFragmentManager.beginTransaction()
        val fragment = FragmentGame()
        val bundle = Bundle()
        bundle.putIntegerArrayList("radiant", radiant)
        bundle.putIntegerArrayList("dire", direPicks)
        fragment.arguments = bundle
        transaction.replace(R.id.fragment_holder, fragment)
            .addToBackStack(null)
        transaction.commit()
    }

    override fun backToLobbyCLicked() {
        supportFragmentManager.popBackStack()
        supportFragmentManager.popBackStack()
    }

    override fun toNewGameClicked() {
        val transaction = supportFragmentManager.beginTransaction()
        val fragment = FragmentRoom()
        transaction.setCustomAnimations(
            R.animator.scaley_enter,
            R.animator.scaley_exit,
            R.animator.scaley_enter,
            R.animator.scaley_exit

        )
        transaction.replace(R.id.fragment_holder, fragment)
        transaction.commit()
    }

}