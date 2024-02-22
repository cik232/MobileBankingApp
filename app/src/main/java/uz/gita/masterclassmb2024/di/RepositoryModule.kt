package uz.gita.masterclassmb2024.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.masterclassmb2024.data.repository.AuthRepository
import uz.gita.masterclassmb2024.data.repository.impl.AuthRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    fun bindAuthRepository(impl: AuthRepositoryImpl): AuthRepository
}