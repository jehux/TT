package com.segurapp.interactors.interactor.incident

import android.util.Log
import com.segurapp.interactors.API.APISeguraApp
import com.segurapp.interactors.model.incident.IncidentsResponse
import com.segurapp.interfaces.incidents.IncidentsInteractor
import com.segurapp.interfaces.incidents.IncidentsPresenter
import com.segurapp.interfaces.incidents.IncidentsServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class IncidentsInteractorImpl : IncidentsInteractor{

    private val incident = "ditto"
    private var apiClient: IncidentsServices? = null
    init {
        apiClient = APISeguraApp.client.create(IncidentsServices::class.java)
    }

    override fun getIncidents(typeIncidents: String, incidentsPresenter: IncidentsPresenter): Unit {
        val call = apiClient?.getIncidents(typeIncidents)
        print("Hola*******++++ pendejos ***************")
        call?.enqueue(object : Callback<List<IncidentsResponse>>{
            override fun onFailure(call: Call<List<IncidentsResponse>>?, t: Throwable?) {
                Log.d("Fallo*****************", t.toString())
            }

            override fun onResponse(
                call: Call<List<IncidentsResponse>>,
                response: Response<List<IncidentsResponse>>
            ) {
                if(response?.isSuccessful!!){
                    var results = response?.body()
                    print("**********data ***********")
                    print(results)

                }
            }
        })
    }

    override fun addIncident(): Unit {

    }

}