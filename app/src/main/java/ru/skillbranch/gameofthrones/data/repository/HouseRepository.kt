package ru.skillbranch.gameofthrones.data.repository

import io.reactivex.Single
import ru.skillbranch.gameofthrones.data.api.GOTApi
import ru.skillbranch.gameofthrones.data.mapper.FromHouseResponseToEntityMapper
import ru.skillbranch.gameofthrones.data.model.response.HouseResponse
import ru.skillbranch.gameofthrones.domain.interactor.model.HouseDetailsEntity

class HouseRepository(
    private val api: GOTApi,
    private val mapper: FromHouseResponseToEntityMapper
) {
    fun getHouses(): Single<List<HouseResponse>> =
        api.getAllHouses()
//            .map { mapper::fromHouseResponseToEntityMapper }

    fun getHouseDetails(houseId: String): Single<HouseDetailsEntity> =
        api.getHouseDetails(houseId)
            .map(mapper::fromHouseDetailsToEntityMapper)
}