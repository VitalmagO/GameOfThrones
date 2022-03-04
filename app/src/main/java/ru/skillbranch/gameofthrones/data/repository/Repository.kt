package ru.skillbranch.gameofthrones.data.repository

import io.reactivex.Observable
import io.reactivex.Single
import ru.skillbranch.gameofthrones.data.api.GOTApi
import ru.skillbranch.gameofthrones.data.cache.HouseRepositoryCache
import ru.skillbranch.gameofthrones.data.mapper.FromResponseToEntityMapper
import ru.skillbranch.gameofthrones.domain.interactor.model.CharacterEntity
import ru.skillbranch.gameofthrones.domain.interactor.model.HouseDetailsEntity
import ru.skillbranch.gameofthrones.domain.interactor.model.HousesEntity

class Repository(
    private val api: GOTApi,
    private val mapper: FromResponseToEntityMapper,
    private val cache: HouseRepositoryCache
) {
    fun getHouses(): Observable<List<HousesEntity>> =
        api.getAllHouses()
            .map { it.map(mapper::fromHouseResponseToEntityMapper) }

    fun getHouseByName(houseName: String): Observable<List<HousesEntity>> =
        api.getHouseByName(houseName)
            .map { it.map(mapper::fromHouseResponseToEntityMapper) }
            .doOnNext { cache.setNeedHouses(it) }

    fun getHouseDetails(houseId: String): Observable<HouseDetailsEntity> =
        api.getHouseDetails(houseId)
            .map(mapper::fromHouseDetailsToEntityMapper)

    fun getCharacter(characterId: String): Observable<CharacterEntity> =
        api.getCharacter(characterId)
            .map(mapper::fromCharacterResponseToEntityMapper)
}