package ru.skillbranch.gameofthrones.presentation.view.adapter.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fr_character.*
import kotlinx.android.synthetic.main.fr_houses.*
import ru.skillbranch.gameofthrones.R
import ru.skillbranch.gameofthrones.presentation.SingleActivity

class CharacterFragment : Fragment() {
//    private val args: CharacterFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fr_character, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val houseType = HouseType.fromString(args.house)
//        val arms = houseType.coastOfArms
//        val scrim = houseType.primaryColor
//        val scrimDark = houseType.darkColor

        val rootActivity = requireActivity() as SingleActivity
//        rootActivity.setSupportActionBar(toolbar)
        rootActivity.supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
//            title = args.title
        }
//        iv_arms.setImageResource(arms)
//        with(collapsing_layout) {
//            setBackgroundResource(scrim)
//            setContentScrimResource(scrim)
//            setStatusBarScrimResource(scrimDark)
//        }

        collapsing_layout.post { collapsing_layout.requestLayout() }
    }
}