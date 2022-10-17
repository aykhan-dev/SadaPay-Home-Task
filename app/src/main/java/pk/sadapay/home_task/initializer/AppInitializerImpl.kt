package pk.sadapay.home_task.initializer

import android.app.Application

class AppInitializerImpl(private vararg val initializers: Initializer) : AppInitializer {

    override fun initAll(application: Application) {
        initializers.forEach {
            it.init(application)
        }
    }

}