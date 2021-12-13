package com.segurapp.interactors.model.incident

import com.google.gson.annotations.SerializedName

data class IncidentsResponse (
    @SerializedName("incidents") var incidents: Array<Map<String, String>>
)