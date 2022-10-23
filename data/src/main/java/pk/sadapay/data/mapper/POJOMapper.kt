package pk.sadapay.data.mapper

import pk.sadapay.data.data_source.remote.pojo.RepoPOJO
import pk.sadapay.domain.ui_model.RepoUIModel

fun RepoPOJO.toRepoUiModel(): RepoUIModel {
    return RepoUIModel(
        id = this.id,
        name = this.name,
        ownerName = this.owner.login,
        description = this.description,
        language = this.language,
        starCount = this.stargazersCount,
        ownerAvatarUrl = this.owner.avatarUrl,
    )
}