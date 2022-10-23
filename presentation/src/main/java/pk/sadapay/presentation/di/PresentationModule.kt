package pk.sadapay.presentation.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import pk.sadapay.presentation.fragment.trending_repos.TrendingReposViewModel

val presentationModule = module {

    viewModel {
        TrendingReposViewModel(
            loadTrendingReposUseCase = get()
        )
    }

}