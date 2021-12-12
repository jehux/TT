package com.segurapp.interfaces.incidents

interface IncidentsView {
    fun showProgressBar(): Unit
    fun hideProgressBar(): Unit
    fun showIncidentsCards(incidents: Array<String>): Unit
    fun setMessageInfo(message: String): Unit
    fun setMessageSuccess(message: String): Unit
    fun setMessageError(message: String): Unit
}