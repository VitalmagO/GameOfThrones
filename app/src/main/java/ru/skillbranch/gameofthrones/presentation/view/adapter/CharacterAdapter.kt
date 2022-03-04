package ru.skillbranch.gameofthrones.presentation.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.recycler_view_item.view.*
import ru.skillbranch.gameofthrones.R
import ru.skillbranch.gameofthrones.domain.interactor.model.CharacterEntity

class CharacterAdapter : BaseAdapter<CharacterAdapter.CharactersViewHolder>() {

    //создает ViewHolder и инициализирует views для списка
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_view_item, parent, false)
        return CharactersViewHolder(v)
    }

    //реализация вьюхолдера
    class CharactersViewHolder(view: View) : BaseAdapter.BaseViewHolder(view) {
        var name: String = ""
        var alieses: List<String> = listOf()
        var born: String = ""

        //привязываем элементы представления списка к RecyclerView и заполняем данными
        override fun bind(item: Any) {
            let {
                item as CharacterEntity
                view.ivCharacterIcon.setImageResource(R.drawable.lanister_icon)
                view.tvCharacterName.text = item.name
                view.tvCharacterAliases.text = item.aliases.toString()
                view.tvCharacterBorn.text = item.born
            }
        }
    }
}