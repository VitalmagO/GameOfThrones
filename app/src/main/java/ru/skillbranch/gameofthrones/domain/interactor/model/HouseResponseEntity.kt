package ru.skillbranch.gameofthrones.domain.interactor.model

import java.io.Serializable

class HouseResponseEntity(
    val url: String,
    val name: String,
    val region: String,
    val coatOfArms: String
) : Serializable