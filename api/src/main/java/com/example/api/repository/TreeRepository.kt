package com.example.api.repository

import com.example.api.models.TreesComplete

interface TreeRepository {

    suspend fun getTrees(start: Int): TreesComplete

    //suspend fun getTreeByPosition(position:String) : List<Tree>
}