package com.segurapp.interfaces.contactalert

interface OnContactsAlertFinishedListener {
    fun successContactsList(contacts: Array<String>)
    fun errorContactsList(textError: String)
}