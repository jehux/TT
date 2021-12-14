package com.segurapp.presenter.incidents.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.segurapp.R
import com.segurapp.interactors.model.incident.IncidentModel
import com.segurapp.interactors.model.incident.IncidentsResponse

class IncidentsAdapter(private val dataSet: List<IncidentModel>) :
    RecyclerView.Adapter<IncidentsAdapter.ViewHolder>(){
    class ViewHolder(view: View): RecyclerView.ViewHolder (view) {
        val titleIncident: TextView = view.findViewById(R.id.title_incident)
        val descriptionIncident: TextView = view.findViewById(R.id.description_incident_card)
        val imageIncident: ImageView = view.findViewById(R.id.incident_image_card)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
                                .inflate(R.layout.incidents_card, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.titleIncident.text = dataSet[position].titleIncident
        viewHolder.descriptionIncident.text = dataSet[position].descriptionIncident
        viewHolder.imageIncident.setImageResource(R.drawable.holderincidents)
    }

    override fun getItemCount() = dataSet.size


}