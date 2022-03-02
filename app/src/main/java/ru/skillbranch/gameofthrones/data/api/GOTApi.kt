package ru.skillbranch.gameofthrones.data.api

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import ru.skillbranch.gameofthrones.data.model.response.HouseDetailsResponse
import ru.skillbranch.gameofthrones.data.model.response.HouseResponse

interface GOTApi {
    //https://www.anapioficeandfire.com/api/houses
    @GET("houses")
    fun getAllHouses(): Single<List<HouseResponse>>

    @GET("./houses/{houseId}")
    fun getHouseDetails(@Path("houseId") houseId: String): Single<HouseDetailsResponse>
}