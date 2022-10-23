package pk.sadapay.domain.di

import org.koin.dsl.module
import pk.sadapay.domain.use_case.LoadTrendingReposUseCase

val domainModule = module {

    single {
        LoadTrendingReposUseCase(
            reposRepository = get()
        )
    }

}