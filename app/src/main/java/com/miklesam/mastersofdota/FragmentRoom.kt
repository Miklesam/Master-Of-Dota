package com.miklesam.mastersofdota

import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.miklesam.mastersofdota.customsnackbar.SimpleCustomSnackbar
import com.miklesam.mastersofdota.datamodels.ProTeamsEnum
import com.miklesam.mastersofdota.datamodels.StreetView
import com.miklesam.mastersofdota.myviews.WeatherView
import com.miklesam.mastersofdota.utils.PrefsHelper
import com.miklesam.mastersofdota.utils.plusDay
import com.miklesam.mastersofdota.utils.showCustomToast
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
        fun twitterClicked()
        fun teamsClicked()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val roomListener = activity as roomListener
        val screenNumber = PrefsHelper.read(PrefsHelper.HAIR_VIEW, "0")?.toInt() ?: 0
        //teamSigning.moveHand(screenNumber)
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

            if (!isSleeping) {
                if (energyPB.progress > 5) {
                    customSnackbar!!.show()
                    timerCT?.start()
                } else {
                    showCustomToast("low energy, please get some energy", Toast.LENGTH_SHORT)
                }
            }


        }
        heroes_update.setOnClickListener {
            if (!isSleeping) {
                roomListener.heroesUpdateClicked()
            }

        }
        player_update.setOnClickListener {
            if (!isSleeping) {
                roomListener.playerUpdateClicked()
            }

        }
        settings.setOnClickListener {
            if (!isSleeping) {
                roomListener.settingsClicked()
            }

        }
        twitter_write.setOnClickListener {
            if (!isSleeping) {
                roomListener.twitterClicked()
            }

        }
        team_home.setOnClickListener {
            if (!isSleeping) {
                roomListener.teamsClicked()
            }
        }
        sleep.setOnClickListener {
            if (!isSleeping) {
                scope?.launch {
                    isSleeping = true
                    delay(3000)
                    isSleeping = false
                    withContext(Dispatchers.Main) {
                        showCustomToast("Energy is full", Toast.LENGTH_SHORT)
                        plusDay()
                        updateCalendar()
                        PrefsHelper.write(PrefsHelper.ENERGY, "100")
                        energyPB.progress = 100
                    }
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

        updateCalendar()

        val currentTeam = PrefsHelper.read(
            PrefsHelper.YOUR_TEAM_ID, "3000"
        )?.toInt() ?: 3000
        if (currentTeam != 3000) {
            your_team_logo.setImageResource(ProTeamsEnum.values()[currentTeam].teamLogo)
        } else {
            your_team_logo.visibility = View.GONE
            your_team_text.visibility = View.GONE
        }
        val currentFans = PrefsHelper.read(
            PrefsHelper.FANS, "0"
        )?.toInt() ?: 0
        val fansString = "Fans: $currentFans"
        fansStats.text = fansString
        val currentXP = PrefsHelper.read(
            PrefsHelper.XP, "0"
        )?.toInt() ?: 0
        val xpString = "XP: $currentXP"
        xp_update.text = xpString
        val currentMMR = PrefsHelper.read(
            PrefsHelper.MMR_COUNT, "0"
        )?.toInt() ?: 0
        val mmrString = "MMR: $currentMMR"
        mmrStats.text = mmrString
        if (currentMMR < 800) {
            medal.setImageResource(R.drawable.recruit_trans)
        } else if (currentMMR < 1600) {
            medal.setImageResource(R.drawable.guardian_trans)
        } else if (currentMMR < 2400) {
            medal.setImageResource(R.drawable.knight_trans)
        } else if (currentMMR < 3200) {
            medal.setImageResource(R.drawable.hero_trans)
        } else if (currentMMR < 4000) {
            medal.setImageResource(R.drawable.legend_trans)
        } else if (currentMMR < 4800) {
            medal.setImageResource(R.drawable.sovereign_trans)
        } else if (currentMMR < 5600) {
            medal.setImageResource(R.drawable.divinity_trans)
        } else {
            medal.setImageResource(R.drawable.titan_trans)
        }
        val currentEnergy = PrefsHelper.read(
            PrefsHelper.ENERGY, "100"
        )?.toInt() ?: 0
        val thisEnergy = currentEnergy
        energyPB.progress = thisEnergy
        energyPB.unreachedBarColor = ContextCompat.getColor(requireContext(), R.color.lose)


    }

    private fun updateCalendar() {
        val currentDay = PrefsHelper.read(
            PrefsHelper.DAYS, "0"
        )?.toInt() ?: 0

        val currentMonth = PrefsHelper.read(
            PrefsHelper.MONTH, "0"
        )?.toInt() ?: 0

        val currentYear = PrefsHelper.read(
            PrefsHelper.YEARS, "0"
        )?.toInt() ?: 0

        val todayIs = "Y: $currentYear M: $currentMonth D: $currentDay"

        dayStats.text = todayIs

        val currentMoney = PrefsHelper.read(
            PrefsHelper.MONEY, "0"
        )?.toInt() ?: 0

        val moneyString = "Money: $currentMoney"
        moneyStats.text = moneyString

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

        val pickDota = ContextCompat.getDrawable(
            requireContext(),
            R.drawable.pick_stage_m
        )
        val startGame = ContextCompat.getDrawable(
            requireContext(),
            R.drawable.start_mon
        )

        val nightScreen = ContextCompat.getDrawable(
            requireContext(),
            R.drawable.night_1
        )

        scope?.launch {
            while (true) {
                if (!isSleeping) {
                    withContext(Dispatchers.Main) {
                        teamSigning.setMonitorPicture(pickDota)
                        delay(1000)
                        if (isSleeping) return@withContext
                        teamSigning.setMonitorPicture(startGame)
                        delay(1000)
                        if (isSleeping) return@withContext
                        teamSigning.setMonitorPicture(pickDota)
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

        val screenNumber = PrefsHelper.read(PrefsHelper.HAIR_VIEW, "0")?.toInt() ?: 0


        scope?.launch {
            while (true) {
                withContext(Dispatchers.Main) {
                    if (!isSleeping) {
                        teamSigning.moveHand(screenNumber)
                        delay(100)
                        teamSigning.moveHand(screenNumber)
                        delay(100)
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