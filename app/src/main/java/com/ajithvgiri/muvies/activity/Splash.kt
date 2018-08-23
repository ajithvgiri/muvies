package com.ajithvgiri.muvies.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ajithvgiri.muvies.MainActivity



class Splash : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = Intent(applicationContext,
                MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}
