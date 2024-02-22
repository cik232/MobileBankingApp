package uz.gita.masterclassmb2024.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create
import uz.gita.masterclassmb2024.data.api.AuthApi
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    @[Singleton Provides]
    fun authApi(retrofit: Retrofit): AuthApi = retrofit.create()
}