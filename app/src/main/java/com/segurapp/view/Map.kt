package com.segurapp.view

import android.app.Activity
import android.app.Dialog
import android.location.Address
import android.location.Geocoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.SearchView
import android.widget.Toast
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.GoogleApiAvailability
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.TileOverlayOptions
import com.google.maps.android.heatmaps.HeatmapTileProvider
import com.segurapp.R
import java.io.IOException
import java.lang.Exception

class Map : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var mMap: GoogleMap
    private lateinit var searchPlace: EditText
    private lateinit var backButton: ImageButton
    //private lateinit var binding: ActivityMapBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)
        //binding = ActivityMapBinding.inflate(layoutInflater)
        //setContentView(binding.root)
        //GoogleApiAvailability.GOOGLE_PLAY_SERVICES_PACKAGE
        searchPlace = findViewById(R.id.search_in_view)
        backButton = findViewById(R.id.back_button_in_map)
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
        backButton.setOnClickListener(View.OnClickListener {
            finish()
        })
        searchPlace.setOnKeyListener(object: View.OnKeyListener {
            override fun onKey(v: View?, keyCode: Int, event: KeyEvent): Boolean{
                if ((event.getAction() != KeyEvent.ACTION_DOWN) &&
                    (keyCode != KeyEvent.KEYCODE_ENTER)) {
                        return false
                }
                println("sadadlkas***********************")
                println(searchPlace.text.toString())
                val place: String? = searchPlace?.text?.toString()
                var addressList: List<Address>? = null
                if(place == null && place == ""){
                    return false
                }

                var geocoder: Geocoder = Geocoder(applicationContext)
                try {
                    addressList = geocoder.getFromLocationName(place, 1)
                }catch (e: IOException){
                    e.printStackTrace()
                }
                var address: Address? = addressList?.get(0)
                if(address != null){
                    var latLng: LatLng = LatLng(address.longitude, address.longitude)
                    var listLatLng: List<LatLng> = arrayListOf(latLng)
                    mMap.addMarker(MarkerOptions().position(latLng).title(place))
                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10.0f))

                    addHeatMap(listLatLng)
                    return true
                }

                return false
            }
        })
    }

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
    private fun addHeatMap(latsLons: List<LatLng>?){
        var latLngs: List<LatLng?>? = null

        // Get the data: latitude/longitude positions of police stations.
        try {
            latLngs = latsLons
        } catch (e: Exception) {
            Toast.makeText(this, "Hubo un problema al momento de localizar el lugar", Toast.LENGTH_LONG)
                .show()
        }

        // Create a heat map tile provider, passing it the latlngs of the police stations.
        val provider = HeatmapTileProvider.Builder()
            .data(latLngs)
            .build()

        // Add a tile overlay to the map, using the heat map tile provider.
        val overlay = mMap.addTileOverlay(TileOverlayOptions().tileProvider(provider))
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}