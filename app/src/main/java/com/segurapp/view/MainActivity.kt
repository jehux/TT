package com.segurapp.view

import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
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
    override fun onCreate(savedInstanceState: Bundle?) {
        Thread.sleep(2000)
        setTheme(R.style.Theme_Segurapp)


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.view = findViewById(R.id.mainViewL)
        ivBotonAlerta = findViewById(R.id.image_view_enviar_alerta)
        //this.btnTest = findViewById(R.id.btnPrueba)


        ivBotonAlerta.setOnClickListener {
            contactsAlertPresenter.callToEmergency()
        }

        ivVerMapa = findViewById(R.id.image_view_ver_mapa)
        ivVerMapa.setOnClickListener {
            //fun onClick(view: View){
            val intent= Intent(this@MainActivity, Map::class.java)
            startActivity(intent)
            //}
        }

        this.contactsAlertPresenter = ContactsAlertPresenterImpl(this, this.view, this)

    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode==3112){
            if(grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                this.contactsAlertPresenter.callToEmergency()
            }else{
                Toast.makeText(this, "Los permisos ya han sido rechazados, activalos", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        this.contactsAlertPresenter.onDestroy()
    }
}