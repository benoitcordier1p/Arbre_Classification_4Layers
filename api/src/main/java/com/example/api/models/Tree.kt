package com.example.api.models

data class Tree(
    val id: String,
    val adresse: String,
    val circonferenceencm: Int,
    val espece: String,
    val hauteurenm: Int
)

fun mock(): Tree = Tree(
    "1234567890",
    "1 Boulevard de Clichy, 18ème Arrondissement",
    135,
    "hispanica",
    2
)





