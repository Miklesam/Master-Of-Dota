package com.miklesam.masterofdota.customsnackbar

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Context
import android.os.CountDownTimer
import android.util.AttributeSet
import android.view.View
import android.view.animation.OvershootInterpolator
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.daimajia.numberprogressbar.NumberProgressBar
import com.google.android.material.snackbar.ContentViewCallback
import com.miklesam.masterofdota.R

class SimpleCustomSnackbarView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr), ContentViewCallback {

    var message: TextView
    var icon: ImageView
    var rootLayout: ConstraintLayout
    var pb: NumberProgressBar
    private var timerCT: CountDownTimer? = null

    init {
        View.inflate(context, R.layout.view_snackbar_simple, this)
        clipToPadding = false
        this.message = findViewById(R.id.message)
        this.icon = findViewById(R.id.icon)
        this.rootLayout = findViewById(R.id.snack_constraint)
        pb = findViewById(R.id.number_progress_bar)
    }

    override fun animateContentIn(delay: Int, duration: Int) {
        pb.max = 100
        timerCT = object : CountDownTimer(3000, 50) {
            override fun onTick(millisUntilFinished: Long) {
                val count = ((3260 - millisUntilFinished) / 30).toInt()
                if (count > 0) {
                    pb.progress = count
                }

            }

            override fun onFinish() {
                //pb.progress = 100
            }
        }.start()
        val scaleX = ObjectAnimator.ofFloat(icon, View.SCALE_X, 0f, 1f)
        val scaleY = ObjectAnimator.ofFloat(icon, View.SCALE_Y, 0f, 1f)
        val animatorSet = AnimatorSet().apply {
            interpolator = OvershootInterpolator()
            setDuration(500)
            playTogether(scaleX, scaleY)
        }
        animatorSet.start()
        rootLayout.setBackgroundColor(ContextCompat.getColor(context,R.color.cancel_back))
    }

    override fun animateContentOut(delay: Int, duration: Int) {
        timerCT?.cancel()

    }
}