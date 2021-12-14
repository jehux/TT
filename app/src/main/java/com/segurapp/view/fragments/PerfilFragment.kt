package com.segurapp.view.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.segurapp.R


class PerfilFragment : Fragment() {
    private lateinit var name: EditText

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        name = view.findViewById(R.id.editTextTextPersonName)

        val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE)
        val text = sharedPref?.getString("key_name", "")

        name.setText(text)
        val tvButtonOk = view.findViewById<TextView>(R.id.textViewButtonOk)
        tvButtonOk.setOnClickListener {
            setSharePreferences(name.text.toString())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_perfil, container, false)
    }

    fun setSharePreferences(name: String){
        val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE) ?: return
        with (sharedPref.edit()) {
            putString("key_name", name)
            commit()
        }
        Toast.makeText(context,"Perfil guardado",Toast.LENGTH_SHORT).show()
    }

    fun onCheckboxClicked(view: View) {
        if (view is CheckBox) {
            val checked: Boolean = view.isChecked

            when (view.id) {
                R.id.checkbox_meat -> {
                    if (checked) {
                        // Put some meat on the sandwich
                    } else {
                        // Remove the meat
                    }
                }
                R.id.checkbox_cheese -> {
                    if (checked) {
                        // Cheese me
                    } else {
                        // I'm lactose intolerant
                    }
                }
                // TODO: Veggie sandwich
            }
        }
    }

}