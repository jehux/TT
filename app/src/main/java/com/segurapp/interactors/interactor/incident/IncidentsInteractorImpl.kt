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
        println("Hola*******++++ pendejos ***************")

        call?.enqueue(object: Callback<IncidentsResponse>{
            override fun onResponse(
                call: Call<IncidentsResponse>,
                response: Response<IncidentsResponse>
            ) {
                println(response)
                if(response?.isSuccessful!!){
                    var results = response?.body()
                    Log.i("****dasdasdas*****", results.toString())
                    println("**********data ***********")
                    println(results)

                }
            }

            override fun onFailure(call: Call<IncidentsResponse>, t: Throwable) {
                Log.e("Fail response", t.toString())
                println(t.toString())

            }

        })
    }

    override fun addIncident(): Unit {

    }

}