package pk.sadapay.domain.use_case

import pk.sadapay.domain.base.BaseUseCase
import pk.sadapay.domain.repository.ReposRepository
import pk.sadapay.domain.ui_model.RepoUIModel

class LoadTrendingReposUseCase(
    private val reposRepository: ReposRepository
) : BaseUseCase<Unit, List<RepoUIModel>>() {

    override suspend fun execute(params: Unit): List<RepoUIModel> {
        return reposRepository.getTrendingReposSortedByStars()
    }

}