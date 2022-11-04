package com.example.domain.usecase

import com.example.api.models.TreesComplete
import com.example.api.repository.TreeRepository
import com.example.api.useCase.GetTreesUseCase
import javax.inject.Inject


class GetTreesUseCaseImpl @Inject constructor(
    private val repository: TreeRepository
) : GetTreesUseCase {

    override suspend fun getTrees(start: Int):  TreesComplete {
        return repository.getTrees(start)
    }

}