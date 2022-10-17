package pk.sadapay.home_task.initializer

import android.app.Application
import timber.log.Timber

class TimberInitializer(private val isDebug: Boolean) : Initializer {

    override fun init(application: Application) {
        if (isDebug) {
            Timber.plant(object : Timber.DebugTree() {
                override fun createStackElementTag(element: StackTraceElement) =
                    "${super.createStackElementTag(element)}:${element.lineNumber}"
            })
        }
    }
}