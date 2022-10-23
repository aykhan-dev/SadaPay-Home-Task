package pk.sadapay.presentation.fragment.trending_repos

import pk.sadapay.domain.ui_model.RepoUIModel
import pk.sadapay.domain.use_case.LoadTrendingReposUseCase
import pk.sadapay.presentation.base.BaseViewModel

class TrendingReposViewModel(
    private val loadTrendingReposUseCase: LoadTrendingReposUseCase,
) : BaseViewModel<TrendingReposState, Unit, TrendingReposEvent>() {

    override fun provideInitialState() = TrendingReposState()

    init {
        onEvent(TrendingReposEvent.LoadAll)
    }

    override fun onEvent(event: TrendingReposEvent) {
        when (event) {
            TrendingReposEvent.LoadAll -> {
                launchOnMain {
                    val result = loadTrendingReposUseCase.start(Unit)
                    emitState(state.value.copy(isLoading = false, repos = result))
                }
            }
            TrendingReposEvent.Refresh -> {
                emitState(state.value.copy(isRefreshing = true))
                launchOnMain {
                    val result = loadTrendingReposUseCase.start(Unit)
                    emitState(state.value.copy(isRefreshing = false, repos = result))
                }
            }
        }
    }

}

data class TrendingReposState(
    var isLoading: Boolean = true,
    var isRefreshing: Boolean = false,
    val repos: List<RepoUIModel> = emptyList(),
)

sealed class TrendingReposEvent {
    object LoadAll : TrendingReposEvent()
    object Refresh : TrendingReposEvent()
}