package com.example.arbre_classification_pagination

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.api.models.Tree
import com.example.api.useCase.GetTreesUseCase
import com.example.data.network.TreeDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class TreesListViewModel @Inject constructor(
    private val getTreesUseCase: GetTreesUseCase
) : ViewModel() {

    //State. Updated when new tress are loaded.
    val state: Flow<PagingData<Tree>> = Pager(PagingConfig(pageSize = 20)) {
        TreeDataSource(getTreesUseCase)
    }.flow.cachedIn(viewModelScope)

}