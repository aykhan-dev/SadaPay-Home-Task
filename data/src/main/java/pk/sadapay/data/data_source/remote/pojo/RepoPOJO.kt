package pk.sadapay.data.data_source.remote.pojo

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class RepoPOJO(
    val id: Long,
    val name: String,
    val description: String?,
    val language: String?,
    val owner: OwnerPOJO,
    @SerialName("stargazers_count") val stargazersCount: Long,
)

@kotlinx.serialization.Serializable
data class OwnerPOJO(
    val login: String,
    @SerialName("avatar_url") val avatarUrl: String?,
)