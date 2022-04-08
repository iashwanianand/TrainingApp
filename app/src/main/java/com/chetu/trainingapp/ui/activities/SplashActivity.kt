package com.chetu.trainingapp.ui.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.chetu.trainingapp.base.BaseActivity
import com.chetu.trainingapp.databinding.ActivitySplashBinding

class SplashActivity : BaseActivity() {
    private lateinit var binding: ActivitySplashBinding
    private val splashScreenTime: Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Handler().postDelayed({
            intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }, splashScreenTime)
    }
}