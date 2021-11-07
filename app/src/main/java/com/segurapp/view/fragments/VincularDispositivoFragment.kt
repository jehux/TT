package com.segurapp.view.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.segurapp.R
import com.segurapp.view.MainActivity

class VincularDispositivoFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_vincular_dispositivo, container, false)
        val tvVincular = view.findViewById<TextView>(R.id.text_view_vincular)
        val tvOmitir = view.findViewById<TextView>(R.id.text_view_omitir_vincular)

        tvOmitir.setOnClickListener {
            val intent = Intent(context,MainActivity::class.java)
            startActivity(intent)
        }
        return view
    }

}