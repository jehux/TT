package com.segurapp.presenter.contactalert.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.segurapp.R

class IncidentsAdapter(private val dataSet: Array<String>) :
    RecyclerView.Adapter<IncidentsAdapter.ViewHolder>(){
    class ViewHolder(view: View): RecyclerView.ViewHolder (view) {
        val textView: TextView = view.findViewById(R.id.description_incident_card)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
                                .inflate(R.layout.incidents_card, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.textView.text = dataSet[position]
    }

    override fun getItemCount() = dataSet.size


}