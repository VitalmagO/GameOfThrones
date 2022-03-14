package ru.skillbranch.gameofthrones.presentation.view.adapter.fragment

import android.graphics.drawable.AnimatedVectorDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import ru.skillbranch.gameofthrones.R

/**
 * A simple [Fragment] subclass.
 */
class SplashFragment : Fragment() {
    private lateinit var draw : Drawable

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fr_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onPause() {
       super.onPause()
        (draw as AnimatedVectorDrawable).stop()
    }
}
