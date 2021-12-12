package com.segurapp.view

import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.segurapp.R
import com.segurapp.interfaces.contactalert.ContactsAlertPresenter
import com.segurapp.presenter.contactalert.ContactsAlertPresenterImpl


class MainActivity : AppCompatActivity() {
    private var name:Int = 0


    private lateinit var ivBotonAlerta: ImageView
    private lateinit var contactsAlertPresenter: ContactsAlertPresenter
    private lateinit var ivVerMapa: ImageView
    //private lateinit var Map: Map
    private lateinit var view: View
    lateinit var navigationController: NavController
    lateinit var navigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        Thread.sleep(2000)
        setTheme(R.style.Theme_Segurapp)


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.view = findViewById(R.id.mainViewL)
        navigationView = findViewById(R.id.bottomNavigationView)
        navigationController = findNavController(R.id.nav_host_fragment)
        navigationView.setupWithNavController(navigationController)
        //this.btnTest = findViewById(R.id.btnPrueba)


        /*ivBotonAlerta.setOnClickListener {
            contactsAlertPresenter.callToEmergency()
        }


        ivVerMapa.setOnClickListener {
            //fun onClick(view: View){
            val intent= Intent(this@MainActivity, Map::class.java)
            startActivity(intent)
            //}
        }*/

        this.contactsAlertPresenter = ContactsAlertPresenterImpl(this, this)

    }


}