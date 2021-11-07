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


class CapturarGestoFragment : Fragment() {
    lateinit var tvContinuar : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_capturar_gesto, container, false)
         tvContinuar = view.findViewById(R.id.text_view_vincular)

        var supportFragmentManager = parentFragmentManager

        tvContinuar.setOnClickListener {
            supportFragmentManager.commit {
                replace<ConectarSmartWatchFragment>(R.id.fragmentContainerViewIntroduction,)
                setReorderingAllowed(true)
                addToBackStack("name") // name can be null
            }
        }
        return view
    }


}