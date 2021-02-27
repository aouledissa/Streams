package io.aouledissa.streams

import android.os.Bundle
import androidx.navigation.NavController
import org.koin.androidx.scope.ScopeActivity

class MainActivity : ScopeActivity() {

    private val navController: NavController by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }
}