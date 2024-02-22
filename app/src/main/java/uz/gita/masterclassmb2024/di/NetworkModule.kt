package uz.gita.masterclassmb2024.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun getRetrofit() = Retrofit.Builder()
        .baseUrl("http://195.158.16.140/mobile-bank/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}