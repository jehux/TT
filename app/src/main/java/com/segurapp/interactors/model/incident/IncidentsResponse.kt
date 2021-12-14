package com.segurapp.interactors.model.incident

import com.google.gson.annotations.SerializedName

data class IncidentsResponse (
    @SerializedName("data") var data: List<IncidentModel>,
    @SerializedName("message") var message: String,
    @SerializedName("ok") var ok: Boolean
)