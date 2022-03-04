package ru.skillbranch.gameofthrones.presentation.contract

import ru.skillbranch.gameofthrones.domain.interactor.model.CharacterEntity

class CharacterContract {
    interface View : BaseContract.View {
        fun addCharacters(character: CharacterEntity)
        fun notifyAdapter()
        fun showProgress()
        fun hideProgress()
        fun showErrorMessage(error: String?)
        fun refresh()
    }

    abstract class Presenter: BaseContract.Presenter<View>() {
        abstract fun makeList()
        abstract fun refreshList()
    }
}