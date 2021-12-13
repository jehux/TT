package com.segurapp.view

import android.app.Activity
import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.GoogleApiAvailability
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.segurapp.R

class MapActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var mMap: GoogleMap
    //private lateinit var binding: ActivityMapBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)
        //binding = ActivityMapBinding.inflate(layoutInflater)
        //setContentView(binding.root)
        //GoogleApiAvailability.GOOGLE_PLAY_SERVICES_PACKAGE
        val status:Int=GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(applicationContext)
        if(status== ConnectionResult.SUCCESS){
            // Obtain the SupportMapFragment and get notified when the map is ready to be used.
            val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
            mapFragment.getMapAsync(this)
        }
        else{
            val dialog: Dialog = GoogleApiAvailability.getInstance().getErrorDialog(applicationContext as Activity?, status, 10)
            dialog.show()
        }
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        mMap.mapType=GoogleMap.MAP_TYPE_NORMAL
        mMap.uiSettings.isZoomControlsEnabled
        // Add a marker in Sydney and move the camera
        val mexico = LatLng(23.981921020889178, -102.51876145645701)
        mMap.addMarker(MarkerOptions().position(mexico).title("Mexico"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mexico, 4.2f))
        //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, zoom))
    }
}