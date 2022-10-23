package pk.sadapay.data.repository_impl

import pk.sadapay.data.data_source.remote.ReposRemoteDataSource
import pk.sadapay.data.mapper.toRepoUiModel
import pk.sadapay.domain.repository.ReposRepository
import pk.sadapay.domain.ui_model.RepoUIModel

class ReposRepositoryImpl(
    private val reposRemoteDataSource: ReposRemoteDataSource,
) : ReposRepository {

    override suspend fun getTrendingReposSortedByStars(): List<RepoUIModel> {
        val data = reposRemoteDataSource.fetchTrendingReposSortedByStars()
        return data.items.map { it.toRepoUiModel() }
    }

}