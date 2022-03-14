package ru.skillbranch.gameofthrones.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import ru.skillbranch.gameofthrones.*
import ru.skillbranch.gameofthrones.presentation.view.adapter.fragment.HouseFragment


class SingleActivity : AppCompatActivity() {
    lateinit var navController : NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single)
        savedInstanceState ?: prepareData()
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        navController.navigate(R.id.nav_splash)
    }

    private fun prepareData() {
        if (!isNetworkAvailable(this)) {
            TODO("Load data from SharedPref")
            Toast.makeText(this, "Отсутствует интернет", Toast.LENGTH_LONG).show()
        } else {
            navController.navigate(R.id.action_nav_splash_to_nav_houses)
//            supportFragmentManager
//                .beginTransaction()
//                .add(R.id.container, HouseFragment(), null)
//                .commit()
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