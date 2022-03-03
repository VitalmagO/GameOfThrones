package ru.skillbranch.gameofthrones.domain.interactor

import io.reactivex.Observable
import io.reactivex.Single
import ru.skillbranch.gameofthrones.AppConfig
import ru.skillbranch.gameofthrones.data.model.response.CharacterResponse
import ru.skillbranch.gameofthrones.data.model.response.HouseResponse
import ru.skillbranch.gameofthrones.data.repository.Repository
import ru.skillbranch.gameofthrones.domain.interactor.model.CharacterEntity
import ru.skillbranch.gameofthrones.domain.interactor.model.HouseDetailsEntity
import ru.skillbranch.gameofthrones.domain.interactor.model.HousesEntity

class Interactor(private val repository: Repository) {

    fun getHouses(): Observable<List<HousesEntity>> =
        repository.getHouses()

    fun getHouseByName(houseName: String): Observable<List<HousesEntity>> =
        repository.getHouseByName(houseName)
            .map { it.filter { house -> house.name == houseName } }

    fun getDetailsHouse(houseId: String): Observable<HouseDetailsEntity> =
        repository.getHouseDetails(houseId)

    fun getCharacter(characterId: String): Observable<CharacterEntity> =
        repository.getCharacter(characterId)

    fun getHouseWithCharacters(): Observable<Pair<List<HousesEntity>, List<CharacterEntity>>>? {
        val houses = AppConfig.NEED_HOUSES
        val characters = mutableListOf<CharacterResponse>()

        houses.forEach { house ->
            getHouseByName(house)
        }
        return null
    }
}