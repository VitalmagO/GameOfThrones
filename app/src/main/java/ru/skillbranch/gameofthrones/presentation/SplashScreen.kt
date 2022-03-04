package ru.skillbranch.gameofthrones.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.Observable
import ru.skillbranch.gameofthrones.*
import ru.skillbranch.gameofthrones.data.cache.HouseRepositoryCache
import ru.skillbranch.gameofthrones.data.mapper.FromResponseToEntityMapper
import ru.skillbranch.gameofthrones.data.repository.Repository
import ru.skillbranch.gameofthrones.domain.interactor.Interactor
import ru.skillbranch.gameofthrones.domain.interactor.model.CharacterEntity
import ru.skillbranch.gameofthrones.domain.interactor.model.HousesEntity
import ru.skillbranch.gameofthrones.presentation.view.adapter.fragment.CharacterListFragment


class SplashScreen : AppCompatActivity() {

//    private val api = App.getApi()
//    private val cache = HouseRepositoryCache()
//    private val repository: Repository = Repository(api, FromResponseToEntityMapper(), cache)
//    private val interact: Interactor = Interactor(repository)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.container, CharacterListFragment(), null)
                .commit()
        }
    }

//    private fun needHousesWithCharacters(): List<Pair<HousesEntity, List<CharacterEntity>>> {
//        val result = mutableListOf<Pair<HousesEntity, List<CharacterEntity>>>()
//        val houses = AppConfig.NEED_HOUSES.toList()
//
//        Observable.fromIterable(houses)
//            .flatMap { house ->
//                interact.getHouseByName(house)
//                    .map {
//                        Observable.fromIterable(it.first().swornMembers)
//                            .flatMap { character ->
//                                interact.getCharacter(character.split("/").last())
//                            }
//                            .async()
//                            .subscribeLog()
//                    }
//            }
//            .async()
//            .subscribeLog()


//        interact.getHouses()
//            .async()
//            .subscribeLog()

//        interact.getHouseByName(houses[0])
//            .async()
//            .subscribeLog()
//
//        val house = interact.getDetailsHouse("362")
//            .async()
//            .subscribeLog()
//
//        val character = interact.getCharacter("823")
//            .async()
//            .subscribeLog()
//    }


//        houses.forEach { houseName ->
//            interact.getHouseByName(houseName)
//                .map { house ->
//                    house.first().swornMembers.forEach { character ->
//                        interact.getCharacter(character.split("/").last())
//                            .async()
//                            .subscribeLog()
//                    }
//                }
//                .async()
//                .subscribeLog()
//        }
//        return result
//    }
}