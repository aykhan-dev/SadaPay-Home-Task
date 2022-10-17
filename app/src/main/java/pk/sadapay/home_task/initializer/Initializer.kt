package pk.sadapay.home_task.initializer

import android.app.Application

interface Initializer {
    fun init(application: Application)
}