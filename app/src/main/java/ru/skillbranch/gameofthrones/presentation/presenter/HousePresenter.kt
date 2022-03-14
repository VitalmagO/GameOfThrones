package ru.skillbranch.gameofthrones.presentation.presenter

import ru.skillbranch.gameofthrones.App
import ru.skillbranch.gameofthrones.AppConfig
import ru.skillbranch.gameofthrones.async
import ru.skillbranch.gameofthrones.data.cache.HouseRepositoryCache
import ru.skillbranch.gameofthrones.data.mapper.FromResponseToEntityMapper
import ru.skillbranch.gameofthrones.data.repository.Repository
import ru.skillbranch.gameofthrones.domain.interactor.Interactor
import ru.skillbranch.gameofthrones.domain.interactor.model.CharacterEntity
import ru.skillbranch.gameofthrones.presentation.contract.HouseContract
import ru.skillbranch.gameofthrones.subscribeLog

class HousePresenter : HouseContract.Presenter() {
    private val api = App.getApi()
    private val cache = HouseRepositoryCache()
    private val repository: Repository = Repository(api, FromResponseToEntityMapper(), cache)
    private val interact: Interactor = Interactor(repository)

    override fun makeList() {
        val houses = AppConfig.NEED_HOUSES.toList()

        //подписываемся на поток данных
        interact.getHouseByName(houses[0])
            .map { house ->
                house.first().swornMembers.forEach { character ->
                    subscribe(interact.getCharacter(character.split("/").last())
                        .async()
                        .doOnNext { character ->
                            view.addCharacters(
                                CharacterEntity(
                                    character.url,
                                    character.name,
                                    character.culture,
                                    character.born,
                                    character.died,
                                    character.titles,
                                    character.aliases,
                                    character.father,
                                    character.mother
                                )
                            )
                        }
                        .doOnComplete {
                            view.hideProgress()
                        }
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
            }
            .async()
            .subscribeLog()
    }

    //обновляем список
    override fun refreshList() {
        view.refresh()
        makeList()
    }
}