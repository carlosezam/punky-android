package com.example.punky.utils

import android.content.Context
import android.graphics.PorterDuff
import androidx.annotation.ColorRes
import androidx.swiperefreshlayout.widget.CircularProgressDrawable

class LoadingDrawable(context: Context, @ColorRes colorId: Int) : CircularProgressDrawable(context) {
    init {
        strokeWidth = 5f
        centerRadius = 12f
        setColorFilter(
            context.resources.getColor(colorId),
            PorterDuff.Mode.SRC_IN
        )
        start()
    }
}