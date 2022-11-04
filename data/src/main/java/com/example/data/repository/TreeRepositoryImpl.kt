package com.example.data.repository

import com.example.api.models.TreesComplete
import com.example.api.repository.TreeRepository
import com.example.data.network.TreeApi
import javax.inject.Inject

class TreeRepositoryImpl @Inject constructor(
    private val api: TreeApi
) : TreeRepository {

    override suspend fun getTrees(start: Int): TreesComplete {
        return api.getTrees(start)
    }
}