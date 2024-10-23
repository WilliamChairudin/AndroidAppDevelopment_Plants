package com.example.nit3213_assignment2_s4676997.data

data class PlantResponse(
    val entities: List<Plant>,
    val entityTotal: Int
)

data class Plant(
    val scientificName: String,
    val commonName: String,
    val careLevel: String,
    val lightRequirement: String,
    val description: String
)