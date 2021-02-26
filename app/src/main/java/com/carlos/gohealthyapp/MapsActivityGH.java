package com.carlos.gohealthyapp;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivityGH extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    /*Creacion de un objeto de la clase SupportMapFragment
     *para que reciba una notificación cuando el mapa esté listo para ser utilizado.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_g_h);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Agregar una marca de la ubicacion GoHealthy
        LatLng gh = new LatLng(40.4023281, -3.6985184 );
        mMap.addMarker(new MarkerOptions().position(gh).title("GoHealthy").snippet("Nuestra misión es tu bienestar").icon(BitmapDescriptorFactory.fromResource(R.drawable.location)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(gh));


        //Listener que permite mostrar las posiciones del marcador.
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                // Extraer la Latitud y Longitud del Listener del marcador
                double lat = marker.getPosition().latitude;
                double lon = marker.getPosition().longitude;

                // Notificar a través de un mensaje la Latitud y Longitud de posicion actual.
                Toast toast = Toast.makeText(MapsActivityGH.this,"Lat: " + lat + "\nLon: " + lon, Toast.LENGTH_SHORT);
                toast.show();

                return false;
            }
        });
    }
}