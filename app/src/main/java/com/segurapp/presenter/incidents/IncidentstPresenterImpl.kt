package com.segurapp.presenter.incidents

import android.content.Context
import android.view.View
import android.app.Activity
import com.segurapp.interactors.interactor.incident.IncidentsInteractorImpl
import com.segurapp.interactors.model.incident.IncidentModel
import com.segurapp.interactors.model.incident.IncidentsResponse
import com.segurapp.interfaces.incidents.IncidentsInteractor
import com.segurapp.interfaces.incidents.IncidentsPresenter
import com.segurapp.interfaces.incidents.IncidentsView

class IncidentsPresenterImpl constructor(
        private val context: Context,
        private val view: View,
        private var incidentsView: IncidentsView

    ) : IncidentsPresenter{
    private var incidentsInteractor: IncidentsInteractor = IncidentsInteractorImpl()

    override fun loadIncidents() {
        this.incidentsView.showProgressBar()
        try {
            //Aqui va la llamada a la api
            //val incidents = arrayOf("Hola", "dadsas", "dajsdkals", "dakjsdklas", "dkajsdklas", "jdajsdkla")
            //this.incidentsView.showIncidentsCards(incidents)
            this.incidentsInteractor.getIncidents("incidentes", this)
        }catch (e: Exception){
            println(e.printStackTrace())
            this.incidentsView.setMessageError("Algo salio, intente de nuevo")
        }

    }

    override fun listSuccessLoad(incidents: List<IncidentModel>?) {
        if (incidents != null) {
            this.incidentsView.showIncidentsCards(incidents)
        }
        this.incidentsView.hideProgressBar()
    }

    override fun onDestroy() {
    }
}