package com.example.data.di

import com.example.api.repository.TreeRepository
import com.example.data.network.TreeApi
import com.example.data.repository.TreeRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideTreeRepository(api: TreeApi): TreeRepository {
        return TreeRepositoryImpl(api)
    }

}