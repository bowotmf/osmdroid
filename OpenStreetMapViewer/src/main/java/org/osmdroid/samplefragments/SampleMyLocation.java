package org.osmdroid.samplefragments;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import org.osmdroid.R;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.ScaleBarOverlay;
import org.osmdroid.views.overlay.compass.CompassOverlay;
import org.osmdroid.views.overlay.compass.InternalCompassOrientationProvider;
import org.osmdroid.views.overlay.gestures.RotationGestureOverlay;
import org.osmdroid.views.overlay.mylocation.GpsMyLocationProvider;
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay;

/**
 * Created by alex on 9/27/16.
 */

public class SampleMyLocation extends BaseSampleFragment {
    @Override
    public String getSampleTitle() {
        return "My location";
    }

    private MyLocationNewOverlay mLocationOverlay;


  public void addOverlays(){
      super.addOverlays();
      this.mLocationOverlay = new MyLocationNewOverlay(new GpsMyLocationProvider(getActivity()),
              mMapView);

      mMapView.getController().setZoom(15);
      mMapView.setTilesScaledToDpi(true);
      mMapView.setBuiltInZoomControls(true);
      mMapView.setMultiTouchControls(true);
      mMapView.setFlingEnabled(true);
      mMapView.getOverlays().add(this.mLocationOverlay);

      mLocationOverlay.enableMyLocation();
      mLocationOverlay.enableFollowLocation();
      mLocationOverlay.setOptionsMenuEnabled(true);
  }

    @Override
    public void onPause() {
        super.onPause();
        mLocationOverlay.disableFollowLocation();
        mLocationOverlay.disableMyLocation();
    }
    @Override
    public void onResume(){
        super.onResume();

        mLocationOverlay.enableFollowLocation();
        mLocationOverlay.enableMyLocation();

    }


    @Override
    public void onDestroyView(){
        super.onDestroyView();

        mLocationOverlay=null;

    }
}
