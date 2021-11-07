package com.segurapp.interfaces.contactalert

interface ContactsAlertPresenter {
    fun callToEmergency()
    fun sendMessageToContacts()
    //fun callMap()
    fun onDestroy()
}