package ru.skillbranch.gameofthrones.domain.interactor

import io.reactivex.Single
import ru.skillbranch.gameofthrones.data.repository.HouseRepository
import ru.skillbranch.gameofthrones.domain.interactor.model.HouseDetailsEntity

class HouseInteractor(private val repository: HouseRepository) {

        fun getDetailsHouse(houseId: String): Single<HouseDetailsEntity> =
            repository.getHouseDetails(houseId)
}