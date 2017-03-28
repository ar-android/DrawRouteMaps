# DrawRouteMaps
If you want to add route maps feature in your apps you can use DrawRouteMaps to make you work more easier. This is lib will help you to draw route maps between two point LatLng.

![alt tag](https://github.com/ar-android/DrawRouteMaps/raw/master/example-app.png)

# Usage
Make sure your app have allready enable Google Map API and Google Direction API. Then you can use this library and follow this task to integrate DrawRouteMaps into your project.

Add support jitpact repository in root build.gradle at the end of repositories:
```gradle
allprojects {
   repositories {
	maven { url "https://jitpack.io" }
   }
}
```
Add dependencies :
```gradle
dependencies {
    compile 'com.github.ar-android:DrawRouteMaps:1.0.0'
}
```

In Your GoogleMap Ready
-----
```java
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng origin = new LatLng(-7.788969, 110.338382);
        LatLng destination = new LatLng(-7.781200, 110.349709);
        DrawRouteMaps.getInstance(this)
                .draw(origin, destination, mMap);
        DrawMarker.getInstance(this).draw(mMap, origin, R.drawable.marker_a, "Origin Location");
        DrawMarker.getInstance(this).draw(mMap, destination, R.drawable.marker_b, "Destination Location");

        LatLngBounds bounds = new LatLngBounds.Builder()
                .include(origin)
                .include(destination).build();
        Point displaySize = new Point();
        getWindowManager().getDefaultDisplay().getSize(displaySize);
        mMap.moveCamera(CameraUpdateFactory.newLatLngBounds(bounds, displaySize.x, 250, 30));
    }
```
If you want to change color of line route just add this in your resource
```xml
    <color name="colorRouteLine">#FF4081</color>
```

# License

    Copyright 2017 Ahmad Rosid

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
