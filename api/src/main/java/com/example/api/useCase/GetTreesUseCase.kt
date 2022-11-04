package com.example.api.useCase

import com.example.api.models.TreesComplete

interface GetTreesUseCase {

    suspend fun getTrees(start: Int):  TreesComplete
}