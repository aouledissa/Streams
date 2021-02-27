package io.aouledissa.streams.di.modules

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import androidx.navigation.findNavController
import io.aouledissa.streams.MainActivity
import io.aouledissa.streams.R
import io.aouledissa.streams.navigation.INavigationManager
import io.aouledissa.streams.navigation.NavigationManager
import org.koin.dsl.module

val activityModule = module {

    scope<MainActivity> {
        //Provide context
        scoped { get<Context>().activity() }

        scoped {

            //Provide NavController
            val activity = get<Activity>()
            activity.findNavController(R.id.nav_host_fragment)
        }

        scoped<INavigationManager> {
            NavigationManager(navController = get())
        }
    }
}

private tailrec fun Context.activity(): Activity? = when (this) {
    is Activity -> this
    else -> (this as? ContextWrapper)?.baseContext?.activity()
}