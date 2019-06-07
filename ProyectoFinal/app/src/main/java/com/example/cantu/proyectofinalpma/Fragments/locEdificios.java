package com.example.cantu.proyectofinalpma.Fragments;


import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

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

import static com.google.android.gms.maps.model.CameraPosition.*;


/**
 * A simple {@link Fragment} subclass.
 */
public class locEdificios extends Fragment implements OnMapReadyCallback{
    final static int PERMISSION_ALL = 1;
    final static String[] PERMISSIONS = {Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION};

    private GoogleMap mMap;
    SupportMapFragment mapFragment;
    private Marker marcador;
    double lat=0.000, lng=0.000;
    View view;

    LocationManager locationManager;

    public locEdificios() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_loc_edificios, container, false);
        getActivity().setTitle("Edificios");
        setHasOptionsMenu(true);
        locationManager = (LocationManager) view.getContext().getSystemService(Context.LOCATION_SERVICE);
        if (!isPermissionGranted()) {
            requestPermissions(PERMISSIONS, PERMISSION_ALL);
        } else miUbicacion();
        if (!isLocationEnabled())
            showAlert(1);
        init();
        return view;
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_mapa, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int menuItem = item.getItemId();
        if (menuItem == R.id.mapa_camera) {

            return true;
        }
        return false;
    }

    private void init() {
        mapFragment = (SupportMapFragment) getFragmentManager().findFragmentById(R.id.mapas);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        mapFragment = SupportMapFragment.newInstance();
        fragmentTransaction.replace(R.id.mapas, mapFragment).commit();

        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMinZoomPreference(19.5f);
        mMap.setMaxZoomPreference(20.5f);

        miUbicacion();
        /* Add a marker in Sydney and move the camera
        LatLng poliforo = new LatLng(24.1026053, -110.3160389);
        LatLng macrocentro = new LatLng(24.1026293, -110.3160214);
        LatLng dacs = new LatLng(24.1026053, -110.3160389);
        MarkerOptions markerOptions = new MarkerOptions().icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA));
        markerOptions.position(poliforo).title("Poliforo de la Universidad Autonoma de Baja California Sur");
        mMap.addMarker(markerOptions);
        mMap.addMarker(new MarkerOptions().position(macrocentro).title("Macrocentro de Computo"));
        mMap.addMarker(new MarkerOptions().position(dacs).title("Depto. Academico Sistemas Computacionaes"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(poliforo,15));*/
    }
    public void agregar(double lat, double lng) {
        LatLng coordenada = new LatLng(lat, lng);

        CameraPosition positions = new Builder()
                .target(coordenada)
                .tilt(90)
                .build();
        if (marcador != null) {
            marcador.remove();
        }
        marcador = mMap.addMarker(new MarkerOptions().position(coordenada).title("Ubicacion Actual")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(positions));
        /*CameraUpdate miUbicacion = CameraUpdateFactory.newLatLngZoom(coordenada, 20);

        mMap.animateCamera(miUbicacion);*/
    }

    public void actualizar(Location location) {
        if (location != null) {
            lat = location.getLatitude();
            lng = location.getLongitude();
            agregar(lat, lng);
        }

    }
    private boolean isLocationEnabled() {
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) ||
                locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
    }

    private void miUbicacion() {
        if (ActivityCompat.checkSelfPermission(view.getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(view.getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        Criteria criteria = new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_FINE);
        criteria.setPowerRequirement(Criteria.POWER_HIGH);
        String provider = locationManager.getBestProvider(criteria, true);

        LocationManager locationManager = (LocationManager) view.getContext().getSystemService(Context.LOCATION_SERVICE);
        Location locations = locationManager.getLastKnownLocation(provider);
        actualizar(locations);
        locationManager.requestLocationUpdates(provider, 10000, 10, new android.location.LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                actualizar(location);
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        });
    }

    private boolean isPermissionGranted() {
        if (ActivityCompat.checkSelfPermission(view.getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(view.getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            Log.v("mylog", "Permission is granted");
            return true;
        } else {
            Log.v("mylog", "Permission not granted");
            return false;
        }
    }
    private void showAlert(final int status) {
        String message, title, btnText;
        if (status == 1) {
            message = "Your Locations Settings is set to 'Off'.\nPlease Enable Location to " +
                    "use this app";
            title = "Enable Location";
            btnText = "Location Settings";
        } else {
            message = "Please allow this app to access location!";
            title = "Permission access";
            btnText = "Grant";
        }
        AlertDialog.Builder dialog = new AlertDialog.Builder(view.getContext());
        dialog.setCancelable(false);
        dialog.setTitle(title);
                dialog.setMessage(message);
                dialog.setPositiveButton(btnText, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface paramDialogInterface, int paramInt) {
                        if (status == 1) {
                            Intent myIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                            startActivity(myIntent);
                        } else
                            requestPermissions(PERMISSIONS, PERMISSION_ALL);
                    }
                });
                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface paramDialogInterface, int paramInt) {
                        paramDialogInterface.cancel();
                    }
                });
        AlertDialog alertDialog = dialog.create();
        alertDialog.show();
    }
}

