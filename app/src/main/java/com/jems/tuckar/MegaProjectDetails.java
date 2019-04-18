package com.jems.tuckar;

import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.jems.tuckar.utils.ImageSlider;
import com.smarteist.autoimageslider.SliderLayout;

public class MegaProjectDetails extends AppCompatActivity implements OnMapReadyCallback {

    private SliderLayout sliderLayout;
    private SupportMapFragment mapFragment;
    private GoogleMap gMap;
    private LocationManager locationManager;
    private Marker marker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mega_project_details);

        initViews();
        ImageSlider.show(this, sliderLayout);

        mapFragment.getMapAsync(this);
    }

    /***************  init Views   ***************/
    private void initViews() {
        mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        sliderLayout = findViewById(R.id.image_slider);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        // and move the map's camera to the same location.
        LatLng lng = new LatLng(34.0, 35.9);
        googleMap.addMarker(new MarkerOptions().position(lng).title("Marker in Gujrat"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(lng));
    }

    /***************     ***************/


    /***************     ***************/


    /***************     ***************/
}
