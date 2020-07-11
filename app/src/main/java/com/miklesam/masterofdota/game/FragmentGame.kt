package com.miklesam.masterofdota.game

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.miklesam.masterofdota.utils.Gone
import com.miklesam.masterofdota.datamodels.Heroes
import com.miklesam.masterofdota.utils.PrefsHelper
import com.miklesam.masterofdota.R
import kotlinx.android.synthetic.main.fragment_game.*
import kotlinx.coroutines.*

class FragmentGame : Fragment(R.layout.fragment_game), AssignCallback,
    EndMatchDialog.toLobbyInterface {
    private lateinit var mListener: backToLobby
    private val radiantImages =
        arrayOfNulls<ImageView>(5)
    private val radiantHeroName =
        arrayOfNulls<TextView>(5)
    private val radiantPlayerName =
        arrayOfNulls<TextView>(5)
    private val direImages =
        arrayOfNulls<ImageView>(5)
    private val direHeroName =
        arrayOfNulls<TextView>(5)

    interface backToLobby {
        fun backToLobbyCLicked()
    }

    private var gameEnd = false
    var gameGame: GameSimulationView? = null
    var heroes: ArrayList<Int>? = null
    var direHeroes: ArrayList<Int>? = null
    var firstInit = true
    private val gameViewModel: GameViewModel by viewModels()
    val scope = CoroutineScope(Dispatchers.IO + SupervisorJob())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
        mListener = activity as backToLobby
        if (arguments != null) {
            heroes = requireArguments().getIntegerArrayList(("radiant"))
            direHeroes = requireArguments().getIntegerArrayList(("dire"))
            gameViewModel.radiantHeroes = heroes!!
            gameViewModel.direHeroes = direHeroes!!
        }
        gameViewModel.setCallbackToGame(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        radiantImages[0] = firstRadiantPlayerHeroImage
        radiantImages[1] = secondRadiantPlayerHeroImage
        radiantImages[2] = thirdRadiantPlayerHeroImage
        radiantImages[3] = forthRadiantPlayerHeroImage
        radiantImages[4] = fifthRadiantPlayerHeroImage
        radiantHeroName[0] = heroRad1
        radiantHeroName[1] = heroRad2
        radiantHeroName[2] = heroRad3
        radiantHeroName[3] = heroRad4
        radiantHeroName[4] = heroRad5
        radiantPlayerName[0] = firstRadiantPlayerName
        radiantPlayerName[1] = secondRadiantPlayerName
        radiantPlayerName[2] = thirdRadiantPlayerName
        radiantPlayerName[3] = forthRadiantPlayerName
        radiantPlayerName[4] = fifthRadiantPlayerName


        direImages[0] = firstDirePlayerHeroImage
        direImages[1] = secondDirePlayerHeroImage
        direImages[2] = thirdDirePlayerHeroImage
        direImages[3] = forthDirePlayerHeroImage
        direImages[4] = fifthDirePlayerHeroImage

        direHeroName[0] = heroDire1
        direHeroName[1] = heroDire2
        direHeroName[2] = heroDire3
        direHeroName[3] = heroDire4
        direHeroName[4] = heroDire5


        for (i in 0 until 5) {
            radiantImages[i]?.setImageResource(
                Heroes.values().find { it.id == heroes?.get(i) ?: 0 }!!.icon
            )
            radiantHeroName[i]?.text =
                Heroes.values().find { it.id == heroes?.get(i) ?: 0 }!!.heroName

            direImages[i]?.setImageResource(
                Heroes.values().find { it.id == direHeroes?.get(i) ?: 0 }!!.icon
            )

            direHeroName[i]?.text =
                Heroes.values().find { it.id == direHeroes?.get(i) ?: 0 }!!.heroName
        }

        gameGame = view.findViewById(R.id.gameGame)
        gameViewModel.getStarted().observe(viewLifecycleOwner, Observer {
            if (it) {
                gameGame?.initHeroes(gameViewModel.radiantHeroes, gameViewModel.direHeroes)
                gameGame?.Start()
                scope.launch {
                    delay(200)
                    gameGame?.setBasePosition()
                }
            }
        })



        gameViewModel.getPlayersMatchStatistic().observe(viewLifecycleOwner, Observer {
            radiantStat1.text = it[0]
            radiantStat2.text = it[1]
            radiantStat3.text = it[2]
            radiantStat4.text = it[3]
            radiantStat5.text = it[4]

            direStat1.text = it[5]
            direStat2.text = it[6]
            direStat3.text = it[7]
            direStat4.text = it[8]
            direStat5.text = it[9]

            radiantTotalScore.text = it[10]
            direTotalScore.text = it[11]

        })

        gameViewModel.getradiantTowers().observe(viewLifecycleOwner, Observer {
            Log.w("Fragment Game", "Current TowerState= $it")
            gameGame?.setTowers(it)
            if (!it[9] || !it[19]) {
                gameEnd = true
                gameViewModel.gameEnd = gameEnd
                scope.launch {
                    delay(2000)
                    if (!it[9] && !it[19]) {
                        initiateEnd(3)
                    } else if (!it[9]) {
                        initiateEnd(2)
                    } else if ((!it[19])) {
                        initiateEnd(1)
                    }
                }
            }
        })

        gameViewModel.getTimeState().observe(viewLifecycleOwner, Observer {
            val time = "${it * 3}:00"
            dayTime.text = time

        })

        commonsHideButton.setOnClickListener {
            commonsHideButton.Gone()
        }

    }

    override fun onDestroyView() {
        gameGame = null
        super.onDestroyView()
    }

    fun initiateEnd(side: Int) {
        if (firstInit) {
            Log.w("Initiate End", "End $side")
            firstInit = false
            gameGame?.initiateWin(side)
            createEndMatchDialogDialog(side)
        }
    }

    private fun createEndMatchDialogDialog(side: Int) {
        val dialog = EndMatchDialog(this, side)
        fragmentManager?.let { dialog.show(it, "CreateEndMatchDialogDialog") }
    }


    override fun onAssign(position: Array<Int>) {
        if (!gameEnd) {
            gameGame?.CalcilateSpeed(
                position
            )
        }
    }

    override fun goToLobbyClick(points: Int) {
        var currentMMR = PrefsHelper.read(
            PrefsHelper.MMR_COUNT, "0")?.toInt() ?: 0
        when (points) {
            1 -> currentMMR += 25
            2 -> currentMMR -= 25
        }
        PrefsHelper.write(PrefsHelper.MMR_COUNT, currentMMR.toString())

        mListener.backToLobbyCLicked()
    }
}