package com.segurapp.interfaces.incidents

interface IncidentsInteractor {
    fun getIncidents(typeIncident: String, incidentsPresenter: IncidentsPresenter): Unit
    fun addIncident(): Unit
}