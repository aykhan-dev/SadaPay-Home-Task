package pk.sadapay.home_task.initializer

import android.app.Application

interface AppInitializer {
    fun initAll(application: Application)
}