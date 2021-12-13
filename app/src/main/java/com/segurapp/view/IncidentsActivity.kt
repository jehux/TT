package com.segurapp.view

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.segurapp.R
import com.segurapp.interfaces.incidents.IncidentsPresenter
import com.segurapp.interfaces.incidents.IncidentsView
import com.segurapp.presenter.incidents.IncidentsPresenterImpl
import com.segurapp.presenter.incidents.adapters.IncidentsAdapter

class IncidentsActivity : AppCompatActivity(), IncidentsView {
    private lateinit var recyclerViewIncidents : RecyclerView
    private lateinit var progressMoreIncidents: ProgressBar
    private lateinit var incidentsPresenter: IncidentsPresenter
    private lateinit var view: View
    private lateinit var incidentsAdapter: IncidentsAdapter
    private lateinit var context: Context
    private val NUMBER_ELEMT_IN_GRID = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_incidents)

        this.recyclerViewIncidents = findViewById(R.id.recycler_incidents)
        this.progressMoreIncidents = findViewById(R.id.progress_wait_incidents)

        this.view = View(this)
        this.context = this
        var linearLayoutManager: LinearLayoutManager = GridLayoutManager(this, NUMBER_ELEMT_IN_GRID)
        this.recyclerViewIncidents.layoutManager = linearLayoutManager
        println("hola amigos de yourube")
        incidentsPresenter = IncidentsPresenterImpl(this, this.view, this)
    }

    override fun onResume() {
        super.onResume()
        println("hola amigos de yourube")
        this.incidentsPresenter.loadIncidents()
    }

    override fun showProgressBar(): Unit {
        this.progressMoreIncidents.visibility = View.VISIBLE
    }
    override fun hideProgressBar(): Unit{
        this.progressMoreIncidents.visibility = View.GONE
    }
    override fun showIncidentsCards(incidents: Array<String>): Unit {
        println("hola amigos de yourube")
        this.incidentsAdapter = IncidentsAdapter(incidents)
        this.recyclerViewIncidents.adapter = this.incidentsAdapter
        this.incidentsAdapter?.notifyDataSetChanged()
    }

    override fun setMessageInfo(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun setMessageSuccess(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun setMessageError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

}