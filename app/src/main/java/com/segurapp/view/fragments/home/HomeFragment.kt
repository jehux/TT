package com.segurapp.view.fragments.home

import android.app.Activity.RESULT_OK
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.segurapp.R
import com.segurapp.interfaces.contactalert.ContactsAlertPresenter
import com.segurapp.presenter.contactalert.ContactsAlertPresenterImpl
import com.segurapp.view.MainActivity
import com.segurapp.view.MainActivity.Companion.isCall

class HomeFragment : Fragment() {

    lateinit var contactsAlertPresenter: ContactsAlertPresenter
    lateinit var tvUserName: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val ivVerMapa =  view.findViewById<ImageView>(R.id.image_view_ver_map)
        val ivCallEmergency = view.findViewById<ImageView>(R.id.image_view_enviar_alerta)
        tvUserName = view.findViewById(R.id.textView_bienvenida)
        ivVerMapa.setOnClickListener {
            //fun onClick(view: View){
            /*val intent= Intent(context, Map::class.java)
            startActivity(intent)*/
            //}
            (activity as MainActivity).showMap()
        }
        ivCallEmergency.setOnClickListener {
            (activity as MainActivity).callEmergency()

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

    override fun onResume() {
        super.onResume()
        //val sharedPref = activity?.getSharedPreferences( "key_name", Context.MODE_PRIVATE)
        val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE) ?: return
        val text = sharedPref.getString("key_name", "")
        tvUserName.text = "Bienvenida $text"
        if (isCall){
            (activity as MainActivity).dispatchTakePictureIntent()
            isCall = false
        }
        //Toast.makeText(context,"onResume",Toast.LENGTH_SHORT).show()

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val REQUEST_IMAGE_CAPTURE = 1
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            //imageView.setImageBitmap(imageBitmap)
        }
    }

}