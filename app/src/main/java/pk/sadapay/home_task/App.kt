package pk.sadapay.home_task

import android.app.Application
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin
import pk.sadapay.home_task.di.appComponent
import pk.sadapay.home_task.initializer.AppInitializer

class App : Application() {

    private val initializer by inject<AppInitializer>()

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(androidContext = this@App)
            properties(
                mapOf(
                    "isDebug" to BuildConfig.DEBUG.toString(),
                    "baseUrl" to "https://api.github.com/",
                )
            )
            modules(appComponent)
        }

        initializer.initAll(this)
    }

}