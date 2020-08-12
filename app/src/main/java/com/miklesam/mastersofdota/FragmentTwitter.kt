package com.miklesam.mastersofdota

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.miklesam.mastersofdota.utils.PrefsHelper
import com.miklesam.mastersofdota.utils.showCustomToast
import kotlinx.android.synthetic.main.fragment_twitter.*
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.Main


class FragmentTwitter : Fragment(R.layout.fragment_twitter) {

    interface TweetClicked {
        fun tweet()
    }

    val scope = CoroutineScope(Main)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tweetListener = activity as TweetClicked
        val nick = "@${PrefsHelper.read(PrefsHelper.NICK_NAME, "Your NickName")}"
        your_nickname.text = nick
        val currentFansNumber = PrefsHelper.read(PrefsHelper.FANS, "0")?.toInt() ?: 0
        val currentFans = "Fans $currentFansNumber"
        number_fans.text = currentFans

        tweet_text.setOnClickListener {

            if (twitter_edit.text.isNotEmpty()) {
                scope.launch {
                    PrefsHelper.write(PrefsHelper.FANS, (currentFansNumber + 100).toString())
                    for (i in 0..100) {
                        val fans =
                            "Fans ${currentFansNumber + i}"
                        number_fans.text = fans
                        delay(10)
                    }
                    tweetListener.tweet()
                }
            } else {
                showCustomToast("Type what happens", Toast.LENGTH_SHORT)
            }


        }


    }

    override fun onPause() {
        scope.cancel()
        super.onPause()
    }
}