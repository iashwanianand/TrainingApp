package com.chetu.trainingapp.application

import android.app.Application

class TheApplication : Application() {
    companion object {
        lateinit var instance: TheApplication
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}