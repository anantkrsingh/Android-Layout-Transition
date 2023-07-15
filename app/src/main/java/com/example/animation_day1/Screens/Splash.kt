package com.example.animation_day1.Screens

import android.animation.LayoutTransition
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.animation_day1.databinding.ActivitySplashBinding

class Splash : AppCompatActivity() {
    lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        animate()
    }
    fun animate(){
        var layoutTransition = LayoutTransition()
        layoutTransition.enableTransitionType(LayoutTransition.CHANGING)
        binding.parentBox.layoutTransition = layoutTransition

        binding.image.visibility = View.GONE
        binding.text.visibility = View.VISIBLE

        object : CountDownTimer(2000, 1000) {
            override fun onTick(l: Long) {}
            override fun onFinish() {
                animateAgain()

            }
        }.start()

    }
    fun animateAgain(){
        binding.image.visibility = View.VISIBLE
        binding.text.visibility = View.GONE

        object : CountDownTimer(2000, 1000) {
            override fun onTick(l: Long) {}
            override fun onFinish() {
                animate()

            }
        }.start()

    }
}