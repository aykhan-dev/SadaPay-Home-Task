package pk.sadapay.domain.repository

import pk.sadapay.domain.ui_model.RepoUIModel

interface ReposRepository {

    suspend fun getTrendingReposSortedByStars(): List<RepoUIModel>

}