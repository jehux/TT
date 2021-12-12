package com.segurapp.view.adapters

import android.annotation.SuppressLint
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.segurapp.R
import com.segurapp.model.dao.Contacts
import com.segurapp.view.interfaces.ContactsEvents

class ContactsAdapter(var contacts: MutableList<Contacts>, val listener: ContactsEvents) : RecyclerView.Adapter<ContactsAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.card_view_contacto, parent, false)
        return ViewHolder(view)
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        //val tvTitle = view.findViewById<TextView>(R.id.text_view_title)
        val etName = view.findViewById<EditText>(R.id.editText_name)
        val etPhone = view.findViewById<EditText>(R.id.editText_phone)
        val ivDelete = view.findViewById<ImageView>(R.id.imageView_delete)
        val tvLabelContact = view.findViewById<TextView>(R.id.textView_contact_label)
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentContact = contacts[position]
        holder.etName.text = currentContact.name.toEditable()
        holder.etPhone.text = currentContact.phone.toEditable()

        when (currentContact.id){
            1 -> holder.tvLabelContact.text = "Contacto principal"
            else -> {
                holder.tvLabelContact.text = "Contacto ${currentContact.id}"
            }
        }

         holder.ivDelete.setOnClickListener {
             if (contacts.size == 1){
                 print("nope")
             }else{
                 listener.deleteContact(position)
             }

         }
    }
    fun String.toEditable(): Editable =  Editable.Factory.getInstance().newEditable(this)

}

