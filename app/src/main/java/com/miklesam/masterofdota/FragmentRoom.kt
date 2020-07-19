package com.miklesam.masterofdota

import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.miklesam.masterofdota.customsnackbar.SimpleCustomSnackbar
import com.miklesam.masterofdota.datamodels.StreetView
import com.miklesam.masterofdota.myviews.WeatherView
import com.miklesam.masterofdota.utils.PrefsHelper
import kotlinx.android.synthetic.main.fragment_room.*
import kotlinx.coroutines.*

class FragmentRoom : Fragment(R.layout.fragment_room) {

    var weatherAnim: WeatherView? = null
    private var customSnackbar: SimpleCustomSnackbar? = null
    private var scope: CoroutineScope? = null
    private var timerCT: CountDownTimer? = null
    private var isSleeping = false

    interface roomListener {
        fun gamePlayClicked()
        fun heroesUpdateClicked()
        fun playerUpdateClicked()
        fun settingsClicked()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val roomListener = activity as roomListener

        weatherAnim = view.findViewById<WeatherView>(
            R.id.weatherAnim
        )
        weatherAnim?.start(view)
        customSnackbar = SimpleCustomSnackbar.make(
            playDotaGame,
            getString(R.string.finding),
            Snackbar.LENGTH_LONG,
            R.drawable.cancel_x,
            ContextCompat.getColor(requireContext(), R.color.white),
            ::onClick
        )

        playDotaGame.setOnClickListener {
            if (energyPB.progress > 5) {
                customSnackbar!!.show()
                timerCT?.start()
            } else {
                Toast.makeText(context, "low energy, please get some energy", Toast.LENGTH_SHORT)
                    .show()
            }

        }
        heroes_update.setOnClickListener {
            roomListener.heroesUpdateClicked()
        }

        player_update.setOnClickListener {
            roomListener.playerUpdateClicked()
        }

        settings.setOnClickListener {
            roomListener.settingsClicked()
        }

        sleep.setOnClickListener {
            scope?.launch {
                isSleeping = true
                delay(3000)
                isSleeping = false
                withContext(Dispatchers.Main) {
                    Toast.makeText(context, "Energy is full", Toast.LENGTH_SHORT).show()
                    PrefsHelper.write(PrefsHelper.ENERGY, "100")
                    energyPB.progress = 100
                }
            }
        }


        timerCT = object : CountDownTimer(3000, 1000) {
            override fun onTick(millisUntilFinished: Long) {}
            override fun onFinish() {

                val current = energyPB.progress - 25
                PrefsHelper.write(PrefsHelper.ENERGY, current.toString())
                energyPB.progress = current
                roomListener.gamePlayClicked()
            }
        }


        /*
        scope.launch {
            while (true) {
                withContext(Dispatchers.Main) {
                    teamSigning.moveHand()
                    delay(100)
                    teamSigning.moveHand()
                    delay(100)
                }
            }
        }

         */

        val currentView = PrefsHelper.read(PrefsHelper.STREET_VIEW, "0")?.toInt()

        val fon = StreetView.values().find { it.id == currentView }?.streetImage?.let {
            ContextCompat.getDrawable(
                requireContext(),
                it
            )
        }
        weatherAnim?.setFon(fon)

        val currentMMR = PrefsHelper.read(
            PrefsHelper.MMR_COUNT, "0"
        )?.toInt() ?: 0
        val mmrString = "MMR: $currentMMR"
        mmrStats.text = mmrString
        if (currentMMR < 500) {
            medal.setImageResource(R.drawable.recruit_trans)
        } else {
            medal.setImageResource(R.drawable.divinity_trans)
        }

        val currentEnergy = PrefsHelper.read(
            PrefsHelper.ENERGY, "100"
        )?.toInt() ?: 0
        val thisEnergy = currentEnergy
        energyPB.progress = thisEnergy


    }

    private fun onClick() {
        timerCT?.cancel()
        customSnackbar?.dismiss()
        //lockIma.setImageResource(R.drawable.ic_lock)
    }

    override fun onResume() {
        weatherAnim?.resume()
        animateMonitor()
        super.onResume()
    }

    private fun animateMonitor() {
        scope = CoroutineScope(Dispatchers.IO + SupervisorJob())
        val turnDota = ContextCompat.getDrawable(
            requireContext(),
            R.drawable.mon_1
        )
        val pickDota = ContextCompat.getDrawable(
            requireContext(),
            R.drawable.pick_stage_mon
        )
        val startGame = ContextCompat.getDrawable(
            requireContext(),
            R.drawable.start_game
        )

        val nightScreen = ContextCompat.getDrawable(
            requireContext(),
            R.drawable.night_1
        )

        scope?.launch {
            while (true) {
                if (!isSleeping) {
                    withContext(Dispatchers.Main) {
                        teamSigning.setMonitorPicture(turnDota)
                        delay(1000)
                        if (isSleeping) return@withContext
                        teamSigning.setMonitorPicture(pickDota)
                        delay(1000)
                        if (isSleeping) return@withContext
                        teamSigning.setMonitorPicture(startGame)
                        delay(1000)
                    }
                } else {
                    withContext(Dispatchers.Main) {
                        teamSigning.setMonitorPicture(nightScreen)
                        delay(1000)
                        teamSigning.setMonitorPicture(nightScreen)
                        delay(1000)
                        teamSigning.setMonitorPicture(nightScreen)
                        delay(1000)
                    }
                }
            }


        }
    }

    override fun onPause() {
        scope?.cancel()
        weatherAnim?.pause()
        super.onPause()
    }


    override fun onDestroyView() {
        timerCT?.cancel()
        customSnackbar?.dismiss()
        weatherAnim = null
        super.onDestroyView()
    }
}