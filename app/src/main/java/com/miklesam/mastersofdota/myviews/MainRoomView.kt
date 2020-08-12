package com.miklesam.mastersofdota.myviews

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import com.miklesam.mastersofdota.R

class MainRoomView : View {

    internal var kubikSize: Float = 0.toFloat()
    internal var sizeX: Float = 0.toFloat()
    internal var sizeY: Float = 0.toFloat()

    internal var choosePaint = Paint()

    private var mDrawable: Drawable? = null
    private var monitorPicture: Drawable? = null
    private var hand = true


    //viewingview


    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init()
    }

    private fun init() {
        mDrawable = ContextCompat.getDrawable(
            context,
            R.drawable.hair
        )
    }


    override fun onSizeChanged(width: Int, height: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(width, height, oldw, oldh)
        sizeX = getWidth().toFloat()
        sizeY = getHeight().toFloat()
        kubikSize = getWidth().toFloat() / 10

        choosePaint.setColor(Color.rgb(195, 167, 153))
        choosePaint.setStyle(Paint.Style.STROKE)
        choosePaint.setStrokeWidth(35f)

    }

    override fun onDraw(canvas: Canvas) {

        mDrawable?.setBounds(0, 0, sizeX.toInt(), sizeY.toInt())
        mDrawable?.draw(canvas)

        monitorPicture?.setBounds(
            (39 * sizeX / 100).toInt(),
            (10 * sizeY / 100).toInt(),
            (61 * sizeX / 100).toInt(),
            (52 * sizeY / 100).toInt()
        )
        monitorPicture?.draw(canvas)


    }

    fun setMonitorPicture(picture: Drawable?) {
        monitorPicture = picture
        invalidate()
    }

    fun moveHand() {
        mDrawable = if (hand) {
            ContextCompat.getDrawable(
                context,
                R.drawable.hair
            )
        } else {
            ContextCompat.getDrawable(
                context,
                R.drawable.hair_up
            )
        }
        hand = hand.not()
        invalidate()
    }


}
