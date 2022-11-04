package com.example.domain.di

import com.example.api.repository.TreeRepository
import com.example.api.useCase.GetTreesUseCase
import com.example.domain.usecase.GetTreesUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideUseCase(repo: TreeRepository): GetTreesUseCase {
        return GetTreesUseCaseImpl(repo)
    }

}