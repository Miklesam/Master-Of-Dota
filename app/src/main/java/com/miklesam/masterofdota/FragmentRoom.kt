package com.miklesam.masterofdota

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_room.*
import kotlinx.coroutines.*

class FragmentRoom : Fragment(R.layout.fragment_room){

    val scope = CoroutineScope(Dispatchers.IO + SupervisorJob())
    var weatherAnim: WeatherView? = null

    interface roomListener {
        fun gamePlayClicked()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val roomListener = activity as roomListener

        weatherAnim = view.findViewById<WeatherView>(
            R.id.weatherAnim
        )
        weatherAnim?.start(view)


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



        playDotaGame.setOnClickListener {
            roomListener.gamePlayClicked()
        }

        scope.launch {
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




    }


    override fun onResume() {
        weatherAnim?.resume()
        super.onResume()
    }

    override fun onPause() {
        scope.cancel()
        weatherAnim?.pause()
        super.onPause()
    }


    override fun onDestroyView() {
        weatherAnim=null
        super.onDestroyView()
    }
}