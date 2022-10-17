package pk.sadapay.home_task.di

import org.koin.dsl.module
import pk.sadapay.home_task.initializer.AppInitializer
import pk.sadapay.home_task.initializer.AppInitializerImpl
import pk.sadapay.home_task.initializer.TimberInitializer

val appModule = module {

    single<AppInitializer> {
        AppInitializerImpl(
            TimberInitializer(isDebug = getProperty<String>("isDebug") == true.toString()),
        )
    }

}