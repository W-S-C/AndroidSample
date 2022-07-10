package com.dong.android.hilttest.hilt

import com.dong.android.hilttest.retrofit.RetrofitInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HiltModule {

    @Provides
    fun provideBASEURL() = "http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/"

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .client(okHttpClient)
            .baseUrl(provideBASEURL())
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofitApi(retrofit: Retrofit) : RetrofitInterface{
        return retrofit.create(RetrofitInterface::class.java)
    }
}