package com.segurapp.interfaces.incidents

import com.segurapp.interactors.model.incident.IncidentsResponse
import com.segurapp.interfaces.baseAPI.ConstantsAPI
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface IncidentsServices {
    @GET(ConstantsAPI.PARAMETER)
    fun getIncidents(@Path("parameter") parameterName: String): Call<IncidentsResponse>

}