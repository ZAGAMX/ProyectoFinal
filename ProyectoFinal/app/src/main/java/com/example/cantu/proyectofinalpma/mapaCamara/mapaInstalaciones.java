package com.example.cantu.proyectofinalpma.mapaCamara;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.example.cantu.proyectofinalpma.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class mapaInstalaciones extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    double lan;
    double lng;
    String nombre;
    private Marker marcador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa_instalaciones);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        Intent intent = getIntent();
        lan = intent.getExtras().getDouble("lan");
        lng = intent.getExtras().getDouble("lng");
        nombre = intent.getStringExtra("nombre");
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
        mMap.setMinZoomPreference(19.5f);
        mMap.setMaxZoomPreference(20.5f);
        // Add a marker in Sydney and move the camera
        LatLng coordenada = new LatLng(lan, lng);
        CameraPosition positions = new CameraPosition.Builder()
                .target(coordenada)
                .tilt(90)
                .build();
        if (marcador != null) {
            marcador.remove();
        }
        marcador = mMap.addMarker(new MarkerOptions().position(coordenada).title(nombre)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(positions));
        mMap.getUiSettings().setScrollGesturesEnabled(false);


    }
}
