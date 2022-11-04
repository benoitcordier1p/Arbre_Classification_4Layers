package com.example.api.models

data class Record(
    val datasetid: String,
    val fields: Fields,
    val geometry: Geometry,
    val record_timestamp: String,
    val recordid: String
)
 //Set to Tree
fun Record.toDomain(): Tree = Tree(
    id = recordid,
    adresse = "${fields.adresse}, ${fields.arrondissement}",
    circonferenceencm = fields.circonferenceencm,
    hauteurenm = fields.hauteurenm,
    espece = fields.espece ?: "Unknown"
)


