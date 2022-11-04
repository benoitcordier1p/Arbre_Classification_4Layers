package com.example.data.network

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.api.models.Tree
import com.example.api.models.toDomain
import com.example.api.useCase.GetTreesUseCase

class TreeDataSource(private val useCase: GetTreesUseCase): PagingSource<Int, Tree>()  {

    override fun getRefreshKey(state: PagingState<Int, Tree>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Tree> {
        val pageNumber = params.key ?: 0
        return try {
            val response = useCase.getTrees(pageNumber)
            val data = response.records.map { it.toDomain() }

            var nextPageNumber: Int? = null
            if (response.records.size == response.parameters.rows) {
                nextPageNumber = response.parameters.start + response.parameters.rows
            }

            LoadResult.Page(
                data = data,
                prevKey = null,
                nextKey = nextPageNumber
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}