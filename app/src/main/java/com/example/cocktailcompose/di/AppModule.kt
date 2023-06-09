package com.example.cocktailmynewproject.di

import com.example.cocktailmynewproject.data.remote.ApiDetail
import com.example.cocktailmynewproject.data.remote.ApiRequest
import com.example.cocktailmynewproject.data.repository.RepoImplementaion
import com.example.cocktailcompose.data.repository.Repository
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {


    @Provides
    fun ProvideGson(): Gson {
        return Gson()

    }

    @Provides
    fun ProvideOkhttp(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }

            )
            .build()

    }

    @Provides
    @Singleton
    fun ProvidesRetrofit(
        gson: Gson,
        client: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ApiDetail.base_Url)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()

    }


    @Provides
    fun provideAPI(
        retrofit: Retrofit
    ): ApiRequest {
        return retrofit.create(ApiRequest::class.java)
    }


    @Provides
    fun ProvideRepository(apiRequest: ApiRequest): Repository {
        return RepoImplementaion(apiRequest)

    }
}


