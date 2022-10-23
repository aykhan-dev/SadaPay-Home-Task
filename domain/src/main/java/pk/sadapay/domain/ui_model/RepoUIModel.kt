package pk.sadapay.domain.ui_model

data class RepoUIModel(
    val id: Long,
    val name: String,
    val description: String?,
    val ownerName: String,
    val ownerAvatarUrl: String?,
    val language: String?,
    val starCount: Long,
    var isExpanded: Boolean = false,
)

