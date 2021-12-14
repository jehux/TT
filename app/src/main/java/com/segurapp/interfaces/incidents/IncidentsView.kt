package com.segurapp.interfaces.incidents

import com.segurapp.interactors.model.incident.IncidentModel

interface IncidentsView {
    fun showProgressBar(): Unit
    fun hideProgressBar(): Unit
    fun showIncidentsCards(incidents: List<IncidentModel>): Unit
    fun setMessageInfo(message: String): Unit
    fun setMessageSuccess(message: String): Unit
    fun setMessageError(message: String): Unit
}