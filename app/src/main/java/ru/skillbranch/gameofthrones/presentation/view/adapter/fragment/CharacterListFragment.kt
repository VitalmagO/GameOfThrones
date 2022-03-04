package ru.skillbranch.gameofthrones.presentation.view.adapter.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import ru.skillbranch.gameofthrones.presentation.contract.CharacterContract
import kotlinx.android.synthetic.main.activity_splashscreen.*
import ru.skillbranch.gameofthrones.R
import ru.skillbranch.gameofthrones.domain.interactor.model.CharacterEntity
import ru.skillbranch.gameofthrones.presentation.presenter.CharacterPresenter
import ru.skillbranch.gameofthrones.presentation.view.adapter.BaseAdapter
import ru.skillbranch.gameofthrones.presentation.view.adapter.CharacterAdapter

class CharacterListFragment : BaseListFragment(), CharacterContract.View {

    private var presenter: CharacterPresenter = CharacterPresenter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fr_cryptocurrency_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attach(this)
        presenter.makeList()
    }

    override fun createAdapterInstance(): BaseAdapter<*> {
        return CharacterAdapter()
    }

    override fun addCharacters(currency: CharacterEntity) {
        viewAdapter.add(currency)
    }

    override fun notifyAdapter() {
        viewAdapter.notifyDataSetChanged()
    }

    override fun showProgress() {
        requireActivity().progress.visibility = View.VISIBLE
        requireActivity().findViewById<ImageView>(R.id.myImage).visibility = View.VISIBLE
    }

    override fun hideProgress() {
        requireActivity().progress.visibility = View.INVISIBLE
        requireActivity().findViewById<ImageView>(R.id.myImage).visibility = View.INVISIBLE
    }

    override fun showErrorMessage(error: String?) {
        Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
    }

    override fun refresh() {
        viewAdapter.items.clear()
        viewAdapter.notifyDataSetChanged()
    }

    override fun onResume() {
        super.onResume()
        presenter.attach(this)
    }

    override fun onPause() {
        super.onPause()
        presenter.detach()
    }
}