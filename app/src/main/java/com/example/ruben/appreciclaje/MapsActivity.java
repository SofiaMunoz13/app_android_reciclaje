package com.example.ruben.appreciclaje;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    double lat = -17.371097;
    double lng = -66.136642;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        Toast.makeText(MapsActivity.this, "Buscando ubicacion", Toast.LENGTH_LONG).show();
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        miUbicacion();
    }
    private void agregarMarcador(double lat, double lng) {
        LatLng coordenadas = new LatLng(-17.371097, -66.136642);
        LatLng coordenadas1 = new LatLng(-17.372654, - 66.136376);
        LatLng coordenadas2 = new LatLng(-17.371364, - 66.140088);
        LatLng coordenadas3 = new LatLng(-17.373872, - 66.138962);
        LatLng coordenadas4 = new LatLng(-17.373330, - 66.130035);
        LatLng coordenadas5 = new LatLng(-17.367462, - 66.138672);
        LatLng coordenadas6 = new LatLng(-17.370401, - 66.141740);
        LatLng coordenadas7 = new LatLng(-17.365220, - 66.138768);
        LatLng coordenadas8 = new LatLng(-17.367094, - 66.148660);
        LatLng coordenadas9 = new LatLng(-17.371333, - 66.149390);
        LatLng coordenadas10 = new LatLng(-17.366408, -66.130218);
        LatLng coordenadas11 = new LatLng(-17.362947, -66.140968);
        LatLng coordenadas12 = new LatLng(-17.376209, -66.135607);
        LatLng coordenadas13 = new LatLng(-17.373239, -66.130757);
        LatLng coordenadas14 = new LatLng(-17.365539, -66.132056);

        Marker marcador = mMap.addMarker(new MarkerOptions().position(coordenadas).title("Mi Posicion").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_marcador_rojo)));
        CameraUpdate miUbicacion = CameraUpdateFactory.newLatLngZoom(coordenadas, 15);
        //if(marcador != null) marcador.remove();

        mMap.addMarker(new MarkerOptions().position(coordenadas1).title("Papelera Vinto").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_marcador_verde)));
        mMap.addMarker(new MarkerOptions().position(coordenadas2).title("Panaflex").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_marcador_verde)));
        mMap.addMarker(new MarkerOptions().position(coordenadas3).title("Plastic CIDBOL").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_marcador_verde)));
        mMap.addMarker(new MarkerOptions().position(coordenadas4).title("Papeleria Pacata").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_marcador_verde)));
        mMap.addMarker(new MarkerOptions().position(coordenadas5).title("Aboneria el buen Samaritano").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_marcador_verde)));
        mMap.addMarker(new MarkerOptions().position(coordenadas6).title("Baterias Pepe").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_marcador_verde)));
        mMap.addMarker(new MarkerOptions().position(coordenadas7).title("Vidrieria Cristal").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_marcador_verde)));
        mMap.addMarker(new MarkerOptions().position(coordenadas8).title("Recauchutadora Gudier").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_marcador_verde)));
        mMap.addMarker(new MarkerOptions().position(coordenadas9).title("Fundidora Hacktoon").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_marcador_verde)));
        mMap.addMarker(new MarkerOptions().position(coordenadas10).title("Proyecto Verde").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_marcador_verde)));
        mMap.addMarker(new MarkerOptions().position(coordenadas11).title("CODEFF").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_marcador_verde)));
        mMap.addMarker(new MarkerOptions().position(coordenadas12).title("Polambiente").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_marcador_verde)));
        mMap.addMarker(new MarkerOptions().position(coordenadas13).title("ELDAN").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_marcador_verde)));
        mMap.addMarker(new MarkerOptions().position(coordenadas14).title("BIOILS").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_marcador_verde)));

        mMap.animateCamera(miUbicacion);
    }
    private void actualizarUbicacion(Location location) {
        if(location != null) {
            lat = location.getLatitude();
            lng = location.getLongitude();
            agregarMarcador(lat, lng);
        }
    }
    LocationListener locListener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            actualizarUbicacion(location);
        }
        @Override
        public void onStatusChanged(String s, int i, Bundle bundle) {
        }
        @Override
        public void onProviderEnabled(String s) {
        }
        @Override
        public void onProviderDisabled(String s) {
        }
    };
    private void miUbicacion() {
        if(ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        actualizarUbicacion(location);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 0, locListener);
    }
}