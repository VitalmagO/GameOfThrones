package ru.skillbranch.gameofthrones.presentation.view.adapter.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fr_house.*
import ru.skillbranch.gameofthrones.presentation.contract.HouseContract
import ru.skillbranch.gameofthrones.R
import ru.skillbranch.gameofthrones.domain.interactor.model.CharacterEntity
import ru.skillbranch.gameofthrones.presentation.presenter.HousePresenter
import ru.skillbranch.gameofthrones.presentation.view.adapter.BaseAdapter
import ru.skillbranch.gameofthrones.presentation.view.adapter.CharacterAdapter

class HouseFragment : BaseFragment(), HouseContract.View {

    private var presenter: HousePresenter = HousePresenter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fr_houses, container, false)
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
//        requireActivity().appbar.visibility = ViewGroup.INVISIBLE
//        requireActivity().progressBar.visibility = View.VISIBLE
//        requireActivity().findViewById<ImageView>(R.id.myImage).visibility = View.VISIBLE
    }

    override fun hideProgress() {
//        requireActivity().appbar.visibility = ViewGroup.VISIBLE
//        requireActivity().progressBar.visibility = View.INVISIBLE
//        requireActivity().findViewById<ImageView>(R.id.myImage).visibility = View.INVISIBLE
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