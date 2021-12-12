package com.segurapp.view.fragments.home

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.segurapp.R
import com.segurapp.interfaces.contactalert.ContactsAlertPresenter
import com.segurapp.presenter.contactalert.ContactsAlertPresenterImpl

class HomeFragment : Fragment() {
    lateinit var contactsAlertPresenter: ContactsAlertPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var ivVerMapa =  view.findViewById<ImageView>(R.id.image_view_ver_map)
        ivVerMapa.setOnClickListener {
            //fun onClick(view: View){
            val intent= Intent(context, Map::class.java)
            startActivity(intent)
            //}
        }

        /*this.contactsAlertPresenter =
            context?.let { activity?.let { it1 -> ContactsAlertPresenterImpl(it.applicationContext , it1.parent) } }!!*/
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode==3112){
            if(grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                this.contactsAlertPresenter.callToEmergency()
            }else{
                Toast.makeText(context, "Los permisos ya han sido rechazados, activalos", Toast.LENGTH_SHORT).show()
            }
        }
    }
    /*override fun onDestroy() {
        super.onDestroy()
        this.contactsAlertPresenter.onDestroy()
    }*/



}