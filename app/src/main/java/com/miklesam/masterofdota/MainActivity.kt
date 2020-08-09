package com.miklesam.masterofdota

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.games.AchievementsClient
import com.google.android.gms.games.Games
import com.google.android.gms.games.LeaderboardsClient
import com.miklesam.masterofdota.game.FragmentGame
import com.miklesam.masterofdota.heroupdate.FragmentHeroesUpdate
import com.miklesam.masterofdota.newgame.FragmentYourNickName
import com.miklesam.masterofdota.pickstage.FragmentPickStage
import com.miklesam.masterofdota.playerupdate.FragmentPlayerUpdate
import com.miklesam.masterofdota.settingsview.FragmentSettings
import com.miklesam.masterofdota.utils.PrefsHelper

class MainActivity : AppCompatActivity(), FragmentMenu.MenuListener, FragmentRoom.roomListener,
    FragmentPickStage.nextFromPick, FragmentGame.backToLobby,
    FragmentYourNickName.nickNameListener, FragmentTwitter.TweetClicked {

    private var googleSignInClient: GoogleSignInClient? = null
    private var achievementClient: AchievementsClient? = null
    private var leaderboardsClient: LeaderboardsClient? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initGoogleClientAndSignin()
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        if (savedInstanceState == null) {
            showMenuFragment()
        }

    }

    fun initGoogleClientAndSignin() {
        Log.w("Activity", "try to  init")
        googleSignInClient = GoogleSignIn.getClient(
            this,
            GoogleSignInOptions.Builder(
                GoogleSignInOptions.DEFAULT_GAMES_SIGN_IN
            ).build()
        )

        googleSignInClient?.silentSignIn()?.addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Log.w("Activity", "succes Sign")
                achievementClient = Games.getAchievementsClient(
                    this,
                    task.result!!
                )
                leaderboardsClient = Games.getLeaderboardsClient(
                    this,
                    task.result!!
                )
            } else {
                Log.e("Error", "signInError", task.exception)
            }
        }
    }

    private fun showAchievements() {
        achievementClient?.achievementsIntent?.addOnSuccessListener { intent ->
            Log.w("Activity", "start Activity")
            startActivityForResult(intent, 0)
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

    override fun achivmentsClicked() {
        showAchievements()
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
            R.animator.stack_left_in,
            R.animator.stack_right_out
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

    override fun twitterClicked() {
        val transaction = supportFragmentManager.beginTransaction()
        val fragment =
            FragmentTwitter()
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
        val currentXP = PrefsHelper.read(PrefsHelper.XP, "0")?.toInt() ?: 0
        PrefsHelper.write(PrefsHelper.XP, (currentXP + 200).toString())
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

    override fun tweet() {
        supportFragmentManager.popBackStack()
    }

}