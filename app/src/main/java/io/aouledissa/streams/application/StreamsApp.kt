package io.aouledissa.streams.application

import android.app.Application
import io.aouledissa.streams.BuildConfig
import timber.log.Timber

class StreamsApp : Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG)
            Timber.plant(Timber.DebugTree())
    }
}