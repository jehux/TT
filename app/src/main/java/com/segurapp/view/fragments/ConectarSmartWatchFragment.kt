package com.segurapp.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.segurapp.R


class ConectarSmartWatchFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_conectar_smart_watch, container, false)
        var tvEntendido = view.findViewById<TextView>(R.id.text_view_vincular)
        var supportFragmentManager = parentFragmentManager

        tvEntendido.setOnClickListener {
            supportFragmentManager.commit {
                replace<VincularDispositivoFragment>(R.id.fragmentContainerViewIntroduction,)
                setReorderingAllowed(true)
                addToBackStack("name") // name can be null
            }
        }
        return view
    }

}