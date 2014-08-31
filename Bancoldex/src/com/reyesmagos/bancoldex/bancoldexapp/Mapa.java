package com.reyesmagos.bancoldex.bancoldexapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
 


import android.app.ActionBar;
import android.app.FragmentManager;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

import com.reyesmagos.bancoldex.bancoldexapp.R;
import com.reyesmagos.bancoldex.bancoldexapp.R.id;
import com.reyesmagos.bancoldex.bancoldexapp.R.layout;
import com.reyesmagos.bancoldex.bancoldexapp.R.menu;
 
public class Mapa extends Activity {
    GoogleMap mapa;
    ActionBar actionBar;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        actionBar = getActionBar();
        setContentView(R.layout.activity_mapa);
        mapa = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
                .getMap();
        if (mapa != null) {
            Log.i("PERRA", "WE HAD MAP");
            
            ubicarEscenario(6.455, -75.34234, 10);
        } else {
            Log.i("PERRA", "NO MAPP");
        }
 
    }
 
	public void ubicarEscenario(Double Lat, Double Lng, int size) {

		LatLng latlong = new LatLng(Lat, Lng);
		// mapa.setMapType(GoogleMap.MAP_TYPE_NORMAL);
		CameraPosition posicion = new CameraPosition.Builder().target(latlong)
				.zoom(size).bearing(0).build();

		CameraUpdate camUpd = CameraUpdateFactory.newCameraPosition(posicion);
		mapa.animateCamera(camUpd);

		Marker n = mapa.addMarker(new MarkerOptions()
				.position(new LatLng(Lat, Lng))
				.icon(BitmapDescriptorFactory
						.defaultMarker(BitmapDescriptorFactory.HUE_RED))
				.title("").snippet("CULO"));

		// n.setIcon(BitmapDescriptorFactory.defaultMarker())

		n.showInfoWindow();

		// se muestra la venta de info

	}

 
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.fragmento_mapa, menu);
        return true;
    }
 
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
        case R.id.streetView:
           
            Uri streetViewUri = Uri.parse("google.streetview:cbll=41.187849, -5.371510&cbp=1,90,,0,1.0&mz=20");
            Intent streetViewIntent = new Intent(Intent.ACTION_VIEW,
                    streetViewUri);
            startActivity(streetViewIntent);
            return true;
 
        default:
            return super.onOptionsItemSelected(item);
 
        }
    }
 
}
