package com.segurapp.presenter.contactalert

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.segurapp.interfaces.contactalert.ContactsAlertPresenter
import com.segurapp.interfaces.contactalert.OnContactsAlertFinishedListener

class ContactsAlertPresenterImpl constructor(context: Context, view: View, activity: Activity) : ContactsAlertPresenter, OnContactsAlertFinishedListener {
    private var context: Context = context
    private var view: View = view
    private var activity: Activity = activity

    override fun callToEmergency() {
        try {
            checkPermission(Manifest.permission.CALL_PHONE, { requestCallPermission() }, { callIntentEmergency() })
        }catch (e: Exception){
            e.printStackTrace()
        }

    }

    override fun sendMessageToContacts() {
        TODO("Not yet implemented")
    }

    override fun onDestroy() {
        TODO("Not yet implemented")
    }

    override fun successContactsList(contacts: Array<String>) {
        TODO("Not yet implemented")
    }

    override fun errorContactsList(textError: String) {
        TODO("Not yet implemented")
    }

    //Este metodo es checar los permisos en base a los que se tienen al manifest
    //Es de uso general para no volver a repetir codigo al momento de checar permisos, se puede usar para el intent de mensajes
    private fun checkPermission(permissionRequired: String, callbackRequestPermission: ()->Unit, callbackIntentStart: ()->Unit){
        if(ContextCompat.checkSelfPermission(this.context, permissionRequired)!= PackageManager.PERMISSION_GRANTED){
            //Perimisos no aceptados por el momento
            //requestCallPermission()
            callbackRequestPermission()
        }else{
            //intent llamar
            //callIntentEmergency()
            callbackIntentStart()
        }
    }

    //Por el momento no hace marcacion directa al 911, pero si con otros numeros, en desarrollo
    private fun callIntentEmergency(){
        val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:911 "))
        //intent.flags = Intent.FLAG_ACTIVITY_NO_USER_ACTION
        context.startActivity(intent)
    }

    private fun requestCallPermission() {
        if(ActivityCompat.shouldShowRequestPermissionRationale(this.activity, Manifest.permission.CALL_PHONE)){
            //El usuario ya ha rechazado los permisos
            Toast.makeText(this.context, "Los permisos ya han sido rechazados, activalos", Toast.LENGTH_SHORT).show()
        }else{
            ActivityCompat.requestPermissions(this.activity, arrayOf(Manifest.permission.CALL_PHONE), 3112)
        }
    }
    //override fun callMap(){
    //    val intent=Intent(context, Map::class.java)
    //    context.startActivity(intent)
    //}
}