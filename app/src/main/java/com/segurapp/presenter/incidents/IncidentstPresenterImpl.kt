package com.segurapp.presenter.incidents

import android.content.Context
import android.view.View
import android.app.Activity
import com.segurapp.interfaces.incidents.IncidentsPresenter
import com.segurapp.interfaces.incidents.IncidentsView

class IncidentsPresenterImpl constructor(
        private val context: Context,
        private val view: View,
        private var incidentsView: IncidentsView
    ) : IncidentsPresenter{


    override fun loadIncidents() {
        this.incidentsView.showProgressBar()
        try {
            //Aqui va la llamada a la api
            val incidents = arrayOf("Hola", "dadsas", "dajsdkals", "dakjsdklas", "dkajsdklas", "jdajsdkla")
            this.incidentsView.showIncidentsCards(incidents)
        }catch (e: Exception){
            print(e.printStackTrace())
            this.incidentsView.setMessageError("Algo salio, intente de nuevo")
        }
        this.incidentsView.hideProgressBar()
    }

    override fun onDestroy() {
    }
}