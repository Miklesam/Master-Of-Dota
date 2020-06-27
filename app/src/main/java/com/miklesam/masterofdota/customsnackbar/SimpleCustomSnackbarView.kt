package com.miklesam.masterofdota.customsnackbar

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.animation.OvershootInterpolator
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
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

    init {
        View.inflate(context, R.layout.view_snackbar_simple, this)
        clipToPadding = false
        this.message = findViewById(R.id.message)
        this.icon = findViewById(R.id.icon)
        this.rootLayout = findViewById(R.id.snack_constraint)
    }

    override fun animateContentIn(delay: Int, duration: Int) {
        val scaleX = ObjectAnimator.ofFloat(icon, View.SCALE_X, 0f, 1f)
        val scaleY = ObjectAnimator.ofFloat(icon, View.SCALE_Y, 0f, 1f)
        val animatorSet = AnimatorSet().apply {
            interpolator = OvershootInterpolator()
            setDuration(500)
            playTogether(scaleX, scaleY)
        }
        animatorSet.start()
    }

    override fun animateContentOut(delay: Int, duration: Int) {
    }
}