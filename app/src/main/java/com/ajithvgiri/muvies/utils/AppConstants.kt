package com.ajithvgiri.muvies.utils

class AppConstants {

    var appConstants: AppConstants? = null
    val loadingTime: Long = 2000

    val instance: AppConstants
        get() {
            if (appConstants == null)
                appConstants = AppConstants()

            return appConstants!!
        }

}