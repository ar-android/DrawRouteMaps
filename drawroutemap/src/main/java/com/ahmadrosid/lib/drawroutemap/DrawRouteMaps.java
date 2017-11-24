package com.ahmadrosid.lib.drawroutemap;

import android.content.Context;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Polyline;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ocittwo on 11/14/16.
 *
 * @Author Ahmad Rosid
 * @Email ocittwo@gmail.com
 * @Github https://github.com/ar-android
 * @Web http://ahmadrosid.com
 */
public class DrawRouteMaps {
    private static DrawRouteMaps instance;
    private Context context;
    private List<Polyline> polies;

    public static DrawRouteMaps getInstance(Context context) {
        if (instance == null) {
            instance = new DrawRouteMaps();
        }
        instance.context = context;
        return instance;
    }

    private DrawRouteMaps() {
        polies = new ArrayList<>();
    }

    public DrawRouteMaps draw(LatLng origin, LatLng destination, TravelMode travelMode, GoogleMap googleMap) {
        String url_route = FetchUrl.getUrl(origin, destination, travelMode);
        DrawRoute drawRoute = new DrawRoute(googleMap);
        drawRoute.execute(url_route);
        return instance;
    }

    void addToPolies(Polyline polygon) {
        this.polies.add(polygon);
    }

    public void removeLines() {
        if (polies != null) {
            for (Polyline polygon : polies) {
                polygon.remove();
            }
            polies.clear();
        }
    }

    public static Context getContext() {
        return instance.context;
    }
}
