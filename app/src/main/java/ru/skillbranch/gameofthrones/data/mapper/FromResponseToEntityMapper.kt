package ru.skillbranch.gameofthrones.data.mapper

import ru.skillbranch.gameofthrones.data.model.response.CharacterResponse
import ru.skillbranch.gameofthrones.data.model.response.HouseDetailsResponse
import ru.skillbranch.gameofthrones.data.model.response.HouseResponse
import ru.skillbranch.gameofthrones.domain.interactor.model.CharacterEntity
import ru.skillbranch.gameofthrones.domain.interactor.model.HouseDetailsEntity
import ru.skillbranch.gameofthrones.domain.interactor.model.HousesEntity

class FromResponseToEntityMapper {
    fun fromHouseResponseToEntityMapper(response: HouseResponse): HousesEntity =
        with(response) {
            HousesEntity(
                url = url,
                name = name,
                currentLord = currentLord,
                swornMembers = swornMembers
            )
        }

    fun fromHouseDetailsToEntityMapper(response: HouseDetailsResponse): HouseDetailsEntity =
        with(response) {
            HouseDetailsEntity(
                url = url,
                name = name,
                currentLord = currentLord,
                swornMembers = swornMembers
            )
        }

    fun fromCharacterResponseToEntityMapper(response: CharacterResponse): CharacterEntity =
        with(response) {
            CharacterEntity(
                url = url,
                name = name,
                born = born,
                died = died,
                titles = titles,
                aliases = aliases,
                father = father,
                mother = mother,
                houseId = allegiances
            )
        }
}