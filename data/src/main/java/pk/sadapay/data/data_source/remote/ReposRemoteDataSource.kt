package pk.sadapay.data.data_source.remote

import pk.sadapay.data.data_source.remote.pojo.RepoPOJO
import pk.sadapay.data.data_source.remote.pojo.ResultPOJO
import retrofit2.http.GET
import retrofit2.http.Query

interface ReposRemoteDataSource {

    @GET("search/repositories")
    suspend fun fetchTrendingReposSortedByStars(
        @Query("q") query: String = "language=+sort:stars",
    ): ResultPOJO<RepoPOJO>

}