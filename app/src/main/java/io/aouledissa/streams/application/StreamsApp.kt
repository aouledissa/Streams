package io.aouledissa.streams.application

import android.app.Application
import io.aouledissa.chat.di.chatModule
import io.aouledissa.data.di.dataModule
import io.aouledissa.streams.BuildConfig
import io.aouledissa.streams.MainActivity
import io.aouledissa.streams.di.modules.activityModule
import io.aouledissa.streams.di.modules.fragmentModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.component.KoinComponent
import org.koin.core.context.startKoin
import timber.log.Timber

class StreamsApp : Application(), KoinComponent {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG)
            Timber.plant(Timber.DebugTree())

        startKoin {
            androidContext(this@StreamsApp)
            modules(activityModule, fragmentModule, chatModule, dataModule)
            koin.createScope<MainActivity>()
        }
    }
}