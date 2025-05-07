package com.guyi.class25b_and_3

import android.app.Application

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        MSPV3.init(this)
        MySignal.init(this)
    }
}