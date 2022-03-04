package ru.skillbranch.gameofthrones.presentation.presenter

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.skillbranch.gameofthrones.App
import ru.skillbranch.gameofthrones.AppConfig
import ru.skillbranch.gameofthrones.async
import ru.skillbranch.gameofthrones.data.cache.HouseRepositoryCache
import ru.skillbranch.gameofthrones.data.mapper.FromResponseToEntityMapper
import ru.skillbranch.gameofthrones.data.repository.Repository
import ru.skillbranch.gameofthrones.domain.interactor.Interactor
import ru.skillbranch.gameofthrones.domain.interactor.model.CharacterEntity
import ru.skillbranch.gameofthrones.presentation.contract.CharacterContract
import ru.skillbranch.gameofthrones.subscribeLog

class CharacterPresenter : CharacterContract.Presenter() {
    private val api = App.getApi()
    private val cache = HouseRepositoryCache()
    private val repository: Repository = Repository(api, FromResponseToEntityMapper(), cache)
    private val interact: Interactor = Interactor(repository)

    override fun makeList() {

//            val houses = AppConfig.NEED_HOUSES.toList()
//            Observable.fromIterable(houses)
//                .flatMap { house ->
//                    interact.getHouseByName(house)
//                        .map {
//                            Observable.fromIterable(it.first().swornMembers)
//                                .flatMap { character ->
//                                    interact.getCharacter(character.split("/").last())
//                                }
//                                .async()
//                                .subscribeLog()
//                        }
//                }
//                .async()
//                .subscribeLog()

        view.showProgress()
        //подписываемся на поток данных
        subscribe(api.getCharacter("823")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            //наполняем поля элемента списка для адаптера
            .doOnNext {
                view.addCharacters(
                    CharacterEntity(
                        it.url,
                        it.name,
                        it.born,
                        it.died,
                        it.titles,
                        it.aliases,
                        it.father,
                        it.mother
                    )
                )
            }

            //вызывается при вызове onComplete
            .doOnComplete {
                view.hideProgress()
            }

            /*подписывает Observer на Observable
            * принимает объект CoinGeckoApi, получающий данные от сервера вызовом функции getCoinMarket(),
            * которая возврящяет Observable<List<CoinGecko>>*/
            .subscribe({
                view.hideProgress()
                view.notifyAdapter()
            }, {
                view.showErrorMessage(it.message)
                view.hideProgress()
                it.printStackTrace()
            })
        )
    }

    //обновляем список
    override fun refreshList() {
        view.refresh()
        makeList()
    }
}