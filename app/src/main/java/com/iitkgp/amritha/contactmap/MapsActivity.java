package com.iitkgp.amritha.contactmap;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

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
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        ArrayList<HashMap<String, String>> list = (ArrayList<HashMap<String, String>>) getIntent().getSerializableExtra("Contacts");

        int i=0;
        LatLng temp;
        for (i=0;i<list.size();i++){
            HashMap<String,String> hm = list.get(i);
            temp = new LatLng(Double.parseDouble(hm.get("Latitude")), Double.parseDouble(hm.get("Longitude")));
            mMap.addMarker(new MarkerOptions().position(temp).title(hm.get("Name")));
        }

        LatLng sydney = new LatLng(27.0, 90.0);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Johny"));


        // Add a marker in Sydney and move the camera
        //LatLng sydney = new LatLng(27.0, 90.0);
       // mMap.addMarker(new MarkerOptions().position(sydney).title("Marker2"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}
