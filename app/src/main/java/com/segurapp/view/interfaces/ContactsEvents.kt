package com.segurapp.view.interfaces

import com.segurapp.model.dao.Contacts

interface ContactsEvents {
    fun deleteContact(index: Int)
    fun addcontact(contact: Contacts)
}