package pk.sadapay.home_task.di

import pk.sadapay.data.di.dataModule
import pk.sadapay.domain.di.domainModule
import pk.sadapay.presentation.di.presentationModule

val appComponent = listOf(
    appModule,
    dataModule,
    domainModule,
    presentationModule,
)