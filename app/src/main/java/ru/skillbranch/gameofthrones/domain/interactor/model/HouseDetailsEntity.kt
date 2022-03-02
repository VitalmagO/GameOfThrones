package ru.skillbranch.gameofthrones.domain.interactor.model

import java.io.Serializable

data class HouseDetailsEntity(
    val url: String,
    val name: String,
    val currentLord: String,
    val swornMembers: List<String> = listOf()
) : Serializable