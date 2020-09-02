package com.miklesam.mastersofdota

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import android.widget.Toast
import androidx.activity.viewModels
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.games.AchievementsClient
import com.google.android.gms.games.Games
import com.google.android.gms.games.LeaderboardsClient
import com.miklesam.mastersofdota.game.FragmentGame
import com.miklesam.mastersofdota.heroupdate.FragmentHeroesUpdate
import com.miklesam.mastersofdota.newgame.FragmentYourNickName
import com.miklesam.mastersofdota.pickstage.FragmentPickStage
import com.miklesam.mastersofdota.playerupdate.FragmentPlayerUpdate
import com.miklesam.mastersofdota.proteams.FragmentProTeams
import com.miklesam.mastersofdota.settingsview.FragmentSettings
import com.miklesam.mastersofdota.utils.PrefsHelper
import com.miklesam.mastersofdota.utils.ScreenState
import kotlinx.android.synthetic.main.your_custom_layout.*

class MainActivity : AppCompatActivity(), FragmentMenu.MenuListener, FragmentRoom.roomListener,
    FragmentPickStage.nextFromPick, FragmentGame.backToLobby,
    FragmentYourNickName.nickNameListener, FragmentTwitter.TweetClicked,
    FragmentServices.ServicesListener {

    private var googleSignInClient: GoogleSignInClient? = null
    private var achievementClient: AchievementsClient? = null
    private var leaderboardsClient: LeaderboardsClient? = null
    private val mainViewModel by viewModels<MainActivityViewModel>()

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

        initGoogleClientAndSignin()


    }

    fun initGoogleClientAndSignin() {
        Log.w("Activity Google", "try to  init")
        googleSignInClient = GoogleSignIn.getClient(
            this,
            GoogleSignInOptions.Builder(
                GoogleSignInOptions.DEFAULT_GAMES_SIGN_IN
            ).build()
        )

        Log.w("Activity Google", "googleSignInClient $googleSignInClient")

        googleSignInClient?.silentSignIn()?.addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Log.w("Activity Google ", "succes Sign")
                achievementClient = Games.getAchievementsClient(
                    this,
                    task.result!!
                )
                leaderboardsClient = Games.getLeaderboardsClient(
                    this,
                    task.result!!
                )
            } else {
                Log.w("Activity Google", "signInError", task.exception)
            }
        }
    }

    private fun showAchievements() {
        Log.w("Activity Google", "try to start Activity")
        achievementClient?.achievementsIntent?.addOnSuccessListener { intent ->
            Log.w("Activity Google", "start Activity")
            startActivityForResult(intent, 0)
        }
    }

    private fun showTopPlayers() {
        leaderboardsClient?.allLeaderboardsIntent?.addOnSuccessListener { intent ->
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

    override fun servicesClicked() {
        val transaction = supportFragmentManager.beginTransaction()
        val fragment = FragmentServices()
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

    override fun onBackPressed() {
        if (mainViewModel.getCurrentState() != ScreenState.PickScreen) {
            super.onBackPressed()
        }
    }

    override fun leaderBoardClicked() {
        showTopPlayers()
    }

    override fun marketClicked() {
        val intent = Intent(this, PurchaceActivity::class.java)
        startActivity(intent)
    }

    override fun countersClicked() {
        val transaction = supportFragmentManager.beginTransaction()
        val fragment = FragmentCounters()
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
        mainViewModel.setState(ScreenState.PickScreen)
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

    override fun teamsClicked() {
        val transaction = supportFragmentManager.beginTransaction()
        val fragment =
            FragmentProTeams()
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

    override fun pickEnded(radiant: ArrayList<Int>, direPicks: ArrayList<Int>, percentToWin: Int) {
        val transaction = supportFragmentManager.beginTransaction()
        val fragment = FragmentGame()
        val bundle = Bundle()
        bundle.putIntegerArrayList("radiant", radiant)
        bundle.putIntegerArrayList("dire", direPicks)
        bundle.putInt("percentToWin", percentToWin)
        fragment.arguments = bundle
        transaction.replace(R.id.fragment_holder, fragment)
            .addToBackStack(null)
        transaction.commit()
    }

    override fun backToLobbyCLicked() {
        mainViewModel.setState(ScreenState.MainScreenState)
        val currentXP = PrefsHelper.read(PrefsHelper.XP, "0")?.toInt() ?: 0
        val currentMMR = PrefsHelper.read(PrefsHelper.MMR_COUNT, "0")?.toInt() ?: 0
        val plusXP = when (currentMMR) {
            in (0..999) -> 4
            in (1000..1999) -> 3
            in (2000..2999) -> 2
            else -> 1
        }

        PrefsHelper.write(PrefsHelper.XP, (currentXP + plusXP).toString())

        leaderboardsClient?.submitScore(getString(R.string.leadearboard_id), currentMMR.toLong())
        when (currentMMR) {
            in (991..1039) -> achievementClient?.unlock(getString(R.string.ach_1000_mmr))
            in (1991..2039) -> achievementClient?.unlock(getString(R.string.ach_2000_mmr))
            in (2991..3039) -> achievementClient?.unlock(getString(R.string.ach_3000_mmr))
            in (3991..4039) -> achievementClient?.unlock(getString(R.string.ach_4000_mmr))
            in (4991..5039) -> achievementClient?.unlock(getString(R.string.ach_5000_mmr))
        }

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