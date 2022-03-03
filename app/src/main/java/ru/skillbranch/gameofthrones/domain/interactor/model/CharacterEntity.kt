package ru.skillbranch.gameofthrones.domain.interactor.model

import java.io.Serializable

data class CharacterEntity(
    val url: String,
    val name: String,
    val born: String,
    val died: String,
    val titles: List<String> = listOf(),
    val aliases: List<String> = listOf(),
    val father: String,
    val mother: String,
    val houseId: List<String> = listOf()
) : Serializable