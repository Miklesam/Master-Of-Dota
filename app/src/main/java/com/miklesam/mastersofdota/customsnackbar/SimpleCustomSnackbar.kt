package com.miklesam.mastersofdota.customsnackbar

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.miklesam.mastersofdota.R

class SimpleCustomSnackbar private constructor(
    parent: ViewGroup,
    content: SimpleCustomSnackbarView
) : BaseTransientBottomBar<SimpleCustomSnackbar>(parent, content, content) {


    init {
        getView().setBackgroundColor(
            ContextCompat.getColor(
                view.context,
                android.R.color.transparent
            )
        )
        getView().setPadding(0, 0, 0, 0)
    }

    companion object {
        /**
         * make
         * Создает СнекБар с заданными параметрами:
         *
         * @param view любая вьюха на экране в котором мы хотим показать снекБар
         * @param message сообщение выводимое в снекбаре
         * @param duration длительность показа снекбара
         * @param icon иконка, справа от текста действия
         * @param actionLabel текст действия, который нужно выполнить при нажатиии на него
         * @param bgColor цвет фона
         * @param messageFont шрифт сообщения
         * @param actionFont шрифт действия
         * @param onClick выполняемая функция при нажатии на actionLabel
         *
         */
        fun make(
            view: View,
            message: String,
            duration: Int,
            icon: Int,
            bgColor: Int,
            onClick: () -> Unit
        ): SimpleCustomSnackbar {
            // First we find a suitable parent for our custom view
            val parent = findParentViewGroup(view) ?: throw IllegalArgumentException(
                "No suitable parent found from the given view. Please provide a valid view."
            )
            // We inflate our custom view
            val customView = LayoutInflater.from(view.context).inflate(
                R.layout.custom_view_inflation,
                parent,
                false
            ) as SimpleCustomSnackbarView
            // We create and return our Snackbar
            customView.message.text = message
            customView.icon.setImageResource(icon)
            customView.icon.setOnClickListener { onClick.invoke() }
            customView.rootLayout.setBackgroundColor(bgColor)

            return SimpleCustomSnackbar(
                parent,
                customView
            ).setDuration(duration)
        }

        private fun findParentViewGroup(view: View?): ViewGroup? {
            var viewMy = view
            var fallback: ViewGroup? = null
            do {
                if (viewMy is CoordinatorLayout) {
                    // We've found a CoordinatorLayout, use it
                    return viewMy
                } else if (viewMy is FrameLayout) {
                    if (viewMy.id == android.R.id.content) {
                        // If we've hit the decor content view, then we didn't find a CoL in the
                        // hierarchy, so use it.
                        return viewMy
                    } else {
                        // It's not the content view but we'll use it as our fallback
                        fallback = viewMy
                    }
                }
                if (viewMy != null) {
                    // Else, we will loop and crawl up the view hierarchy and try to find a parent
                    val parent = viewMy.parent
                    viewMy = if (parent is View) parent else null
                }
            } while (viewMy != null)

            // If we reach here then we didn't find a CoL or a suitable content view so we'll fallback
            return fallback
        }
    }
}