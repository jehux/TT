package com.segurapp.presenter.incidents

import android.content.Context
import android.view.View
import android.app.Activity
import com.segurapp.interfaces.incidents.IncidentsPresenter

class IncidentstPresenterImpl constructor(
        private val context: Context,
        private val view: View,
        private val activity: Activity
    ) : IncidentsPresenter{

    override fun loadInicidents() {

        TODO("Not yet implemented")
    }

    override fun onDestry() {
        TODO("Not yet implemented")
    }
}