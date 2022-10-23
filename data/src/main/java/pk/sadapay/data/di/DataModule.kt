@file:OptIn(ExperimentalSerializationApi::class)

package pk.sadapay.data.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import pk.sadapay.data.data_source.remote.ReposRemoteDataSource
import pk.sadapay.data.repository_impl.ReposRepositoryImpl
import pk.sadapay.domain.repository.ReposRepository
import retrofit2.Retrofit

val dataModule = module {

    single {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(
            if (getProperty<String>("isDebug") == true.toString()) HttpLoggingInterceptor.Level.BODY
            else HttpLoggingInterceptor.Level.NONE
        )
    }

    single {
        OkHttpClient.Builder()
            .addInterceptor(get<HttpLoggingInterceptor>())
            .build()
    }

    single {
        Json {
            isLenient = true
            encodeDefaults = false
            ignoreUnknownKeys = true
            prettyPrint = true
        }
    }

    single<Retrofit> {
        Retrofit.Builder()
            .client(get())
            .baseUrl(getProperty<String>("baseUrl"))
            .addConverterFactory(get<Json>().asConverterFactory("application/json".toMediaType()))
            .build()
    }

    single {
        get<Retrofit>().create(ReposRemoteDataSource::class.java)
    }

    single<ReposRepository> {
        ReposRepositoryImpl(
            reposRemoteDataSource = get(),
        )
    }

}