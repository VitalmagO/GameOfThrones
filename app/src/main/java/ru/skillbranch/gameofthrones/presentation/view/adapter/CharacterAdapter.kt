package ru.skillbranch.gameofthrones.presentation.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.rv_house_item.*
import ru.skillbranch.gameofthrones.R
import ru.skillbranch.gameofthrones.domain.interactor.model.CharacterEntity

class CharacterAdapter : BaseAdapter<CharacterAdapter.CharactersViewHolder>() {

    //создает ViewHolder и инициализирует views для списка
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.rv_house_item, parent, false)
        return CharactersViewHolder(v)
    }

    //реализация вьюхолдера
    class CharactersViewHolder(view: View) : BaseAdapter.BaseViewHolder(view), LayoutContainer {
        /**Обязательно реализовывать LayoutContainer для нормального кеширования, так как иначе убивается производительность
        каждый раз обращаясь ко view*/
        override val containerView: View
            get() = view

        //привязываем элементы представления списка к RecyclerView и заполняем данными
        override fun bind(item: Any) {
            let {
                item as CharacterEntity
                ivCharacterIcon.setImageResource(R.drawable.lanister_icon)
                tvCharacterName.text = item.name
                tvCharacterCulture.text = getCulture(item.culture)
            }
        }

        private fun getCulture(culture: String): String =
            culture.ifEmpty { "Information unknown" }
    }
}