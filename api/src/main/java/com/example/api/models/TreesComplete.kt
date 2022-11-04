package com.example.api.models

data class TreesComplete(
    val nhits: Int,
    val parameters: Parameters,
    val records: List<Record>
)

