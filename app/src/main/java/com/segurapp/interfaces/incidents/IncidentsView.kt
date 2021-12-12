package com.segurapp.interfaces.incidents

interface IncidentsView {
    fun showProgress(): Void
    fun showIncidentsCards(): Void
    fun setMessageInfo(): Void
    fun setMessageSuccess(): Void
    fun setMessageError(): Void
}