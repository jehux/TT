package com.segurapp.interfaces.incidents

import com.segurapp.interactors.model.incident.IncidentModel
import com.segurapp.interactors.model.incident.IncidentsResponse

interface IncidentsPresenter {
    fun loadIncidents()
    fun listSuccessLoad(incidents: List<IncidentModel>?)
    fun onDestroy()
}