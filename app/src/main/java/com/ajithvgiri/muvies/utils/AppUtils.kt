package com.ajithvgiri.muvies.utils

import android.content.Context
import android.widget.Toast

class AppUtils {

    var appUtils: AppUtils? = null
    val loadingTime: Long = 2000

    val instance: AppUtils
        get() {
            if (appUtils == null)
                appUtils = AppUtils()

            return appUtils!!
        }

    fun showToast(context: Context, message: String) {
        Toast.makeText(context, "$message", Toast.LENGTH_SHORT).show()
    }
}