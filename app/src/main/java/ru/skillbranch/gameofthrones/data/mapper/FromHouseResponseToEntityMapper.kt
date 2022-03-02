package ru.skillbranch.gameofthrones.data.mapper

import ru.skillbranch.gameofthrones.data.model.response.HouseDetailsResponse
import ru.skillbranch.gameofthrones.data.model.response.HouseResponse
import ru.skillbranch.gameofthrones.domain.interactor.model.HouseDetailsEntity
import ru.skillbranch.gameofthrones.domain.interactor.model.HouseResponseEntity

class FromHouseResponseToEntityMapper {
    fun fromHouseResponseToEntityMapper(response: HouseResponse): HouseResponseEntity =
        with(response) {
            HouseResponseEntity(
                url = response.url,
                name = response.name,
                region = response.region,
                coatOfArms = response.coatOfArms
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
}