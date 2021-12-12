package com.segurapp.view.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.segurapp.R
import com.segurapp.model.dao.Contacts
import com.segurapp.view.adapters.ContactsAdapter
import com.segurapp.view.interfaces.ContactsEvents


class ContactosFragment : Fragment(), ContactsEvents {

    var listContacts = mutableListOf<Contacts>()
    lateinit var adapter: ContactsAdapter
    lateinit var rvContacts: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contactos, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvContacts = view.findViewById<RecyclerView>(R.id.recyclerViewContacts)
        val ivOk = view.findViewById<ImageView>(R.id.imageView_ok)
        val fbAdd = view.findViewById<FloatingActionButton>(R.id.floating_button)

        fbAdd.setOnClickListener {
            addNewContact()
        }
        ivOk.setOnClickListener {
            Toast.makeText(context,"Contactos guardados",Toast.LENGTH_LONG).show()
        }

        listContacts.add(Contacts(1,"Midori","5519263057"))
        listContacts.add(Contacts(2,"Jehu","5519263059"))
        listContacts.add(Contacts(3,"Pachita","5519263559"))

        rvContacts.layoutManager = LinearLayoutManager(context)
        adapter = ContactsAdapter(listContacts,this)
        rvContacts.adapter = adapter
    }

    fun addNewContact(){
        listContacts.add(Contacts(listContacts[listContacts.size-1].id+1,"",""))
        adapter.notifyItemInserted(listContacts.size)

    }


    @SuppressLint("NotifyDataSetChanged")
    override fun deleteContact(index: Int) {

        for (i in index+1 until listContacts.size) {
            listContacts[i].id -= 1
        }
        listContacts.removeAt(index)
        adapter.notifyItemRemoved(index)
        adapter.notifyItemRangeChanged(index,listContacts.size-index)

    }

    override fun addcontact(contact: Contacts) {
        TODO("Not yet implemented")
    }


}