package com.miklesam.masterofdota

import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.miklesam.masterofdota.customsnackbar.SimpleCustomSnackbar
import com.miklesam.masterofdota.myviews.WeatherView
import com.miklesam.masterofdota.utils.PrefsHelper
import kotlinx.android.synthetic.main.fragment_room.*
import kotlinx.coroutines.*

class FragmentRoom : Fragment(R.layout.fragment_room) {

    var weatherAnim: WeatherView? = null
    private var customSnackbar: SimpleCustomSnackbar? = null
    private var scope: CoroutineScope? = null
    private var timerCT: CountDownTimer? = null

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
            customSnackbar!!.show()
            timerCT?.start()
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


        timerCT = object : CountDownTimer(3000, 1000) {
            override fun onTick(millisUntilFinished: Long) {}
            override fun onFinish() {
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


        val fon = ContextCompat.getDrawable(
            requireContext(),
            R.drawable.china_view
        )
        weatherAnim?.setFon(fon)

        val currentMMR = PrefsHelper.read(
            PrefsHelper.MMR_COUNT, "0"
        )?.toInt() ?: 0
        val mmrString = "MMR: 10$currentMMR"
        mmrStats.text = mmrString
        if (currentMMR < 500) {
            medal.setImageResource(R.drawable.recruit_trans)
        } else {
            medal.setImageResource(R.drawable.divinity_trans)
        }


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
        scope?.launch {
            while (true) {
                withContext(Dispatchers.Main) {
                    teamSigning.setMonitorPicture(turnDota)
                    delay(1000)
                    teamSigning.setMonitorPicture(pickDota)
                    delay(1000)
                    teamSigning.setMonitorPicture(startGame)
                    delay(1000)
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