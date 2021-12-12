package com.segurapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.segurapp.R
import com.segurapp.interfaces.incidents.IncidentsView

class IncidentsActivity : AppCompatActivity(), IncidentsView {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_incidents)
    }

    override fun showProgress(): Void {
        TODO("Not yet implemented")

    }

    override fun showIncidentsCards(): Void {
        TODO("Not yet implemented")
    }

    override fun setMessageInfo(): Void {
        TODO("Not yet implemented")
    }

    override fun setMessageSuccess(): Void {
        TODO("Not yet implemented")
    }

    override fun setMessageError(): Void {
        TODO("Not yet implemented")
    }
}