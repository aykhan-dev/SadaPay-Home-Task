package pk.sadapay.data.data_source.remote.pojo

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class ResultPOJO<T>(
    @SerialName("total_count") val totalCount: Long,
    @SerialName("incomplete_results") val incompleteResults: Boolean,
    val items: List<T>
)