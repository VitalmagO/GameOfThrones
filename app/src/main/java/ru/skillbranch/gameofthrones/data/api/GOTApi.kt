package ru.skillbranch.gameofthrones.data.api

import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.skillbranch.gameofthrones.data.model.response.CharacterResponse
import ru.skillbranch.gameofthrones.data.model.response.HouseDetailsResponse
import ru.skillbranch.gameofthrones.data.model.response.HouseResponse

interface GOTApi {
    //https://www.anapioficeandfire.com/api/houses
    @GET("houses?pageSize=50")
    fun getAllHouses(): Observable<List<HouseResponse>>

    @GET("houses")
    fun getHouseByName(@Query("name") name: String): Observable<List<HouseResponse>>

    @GET("./houses/{houseId}")
    fun getHouseDetails(@Path("houseId") houseId: String): Observable<HouseDetailsResponse>

    @GET("./characters/{characterId}")
    fun getCharacter(@Path("characterId") characterId: String): Observable<CharacterResponse>
}