package com.vadrevua.vcudining;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class addressActivity extends AppCompatActivity {

    LocationManager locationManager;
    Location location;
    private float distanceToChilis,distanceToBleeker,distanceToCaryStreet,distanceToChickFilA,distanceToCroutons,distanceToEinsteinMCV,distanceToEinsteinShaefer,distanceToFreshii,distanceToIHop,distanceToJonahs,
            distanceToShaefer,distanceToPanda,distanceToPizzaHut,distanceToCanes,distanceToStarbucksCabell,distanceToStarbucksCary,distanceToStarbucksJonahs,distanceToSubway,distanceToTacoBell,distanceToWendys;
    private TextView chilisDistance,bleekerDistance, caryStreetDistance,chickfilaDistance,croutonsDistance, einsteinMCVDistance, einsteinShaeferDistance, freshiiDistance,iHopDistance, jonahsDistance,shaeferDistance,
            pandaDistance, pizzaHutDistance, canesDistance, starbucksCabellDistance, starbucksCaryDistance,starbucksJonahsDistance, subwayDistance,tacobellDistance,wendysDistance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        // Assume thisActivity is the current activity
        int permissionCheck1 = ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION);
        int permissionCheck2 = ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION);

        if ( ContextCompat.checkSelfPermission( this, android.Manifest.permission.ACCESS_COARSE_LOCATION ) == PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission( this, android.Manifest.permission.ACCESS_FINE_LOCATION ) == PackageManager.PERMISSION_GRANTED) {
            locationManager = (LocationManager) addressActivity.this.getSystemService(Context.LOCATION_SERVICE);
            location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

            Location chilis = new Location("chilis");
            chilis.setLatitude(37.543783);
            chilis.setLongitude(-77.448195);

            distanceToChilis = Math.round(location.distanceTo(chilis) * 0.0621371f) / 100.0f;
            chilisDistance = (TextView) findViewById(R.id.chilis);
            chilisDistance.setText(String.valueOf(distanceToChilis) + " miles away");

            Location bleeker = new Location("bleeker");
            bleeker.setLatitude(37.544833);
            bleeker.setLongitude(-77.448228);

            distanceToBleeker = Math.round(location.distanceTo(bleeker) * 0.0621371f) / 100.0f;
            bleekerDistance = (TextView) findViewById(R.id.bleeker);
            bleekerDistance.setText(String.valueOf(distanceToBleeker) + " miles away");

            Location carystreet = new Location("carystreet");
            carystreet.setLatitude(37.543752);
            carystreet.setLongitude(-77.448647);

            distanceToCaryStreet = Math.round(location.distanceTo(carystreet) * 0.0621371f) / 100.0f;
            caryStreetDistance = (TextView) findViewById(R.id.carystreet);
            caryStreetDistance.setText(String.valueOf(distanceToCaryStreet) + " miles away");

            Location chickfila = new Location("chickfila");
            chickfila.setLatitude(37.546516);
            chickfila.setLongitude(-77.453481);

            distanceToChickFilA = Math.round(location.distanceTo(chickfila) * 0.0621371f) / 100.0f;
            chickfilaDistance = (TextView) findViewById(R.id.chickfila);
            chickfilaDistance.setText(String.valueOf(distanceToChickFilA) + " miles away");

            Location croutons = new Location("croutons");
            croutons.setLatitude(37.548941);
            croutons.setLongitude(-77.450330);

            distanceToCroutons = Math.round(location.distanceTo(croutons) * 0.0621371f) / 100.0f;
            croutonsDistance = (TextView) findViewById(R.id.croutons);
            croutonsDistance.setText(String.valueOf(distanceToCroutons) + " miles away");

            Location einsteinMCV = new Location("einsteinMCV");
            einsteinMCV.setLatitude(37.540507);
            einsteinMCV.setLongitude(-77.430335);

            distanceToEinsteinMCV = Math.round(location.distanceTo(chickfila) * 0.0621371f) / 100.0f;
            einsteinMCVDistance = (TextView) findViewById(R.id.einsteinMCV);
            einsteinMCVDistance.setText(String.valueOf(distanceToEinsteinMCV) + " miles away");

            Location einstein = new Location("einsteinShafer");
            einstein.setLatitude(37.548111);
            einstein.setLongitude(-77.452366);

            distanceToEinsteinShaefer = Math.round(location.distanceTo(einstein) * 0.0621371f) / 100.0f;
            einsteinShaeferDistance = (TextView) findViewById(R.id.einsteinShaefer);
            einsteinShaeferDistance.setText(String.valueOf(distanceToEinsteinShaefer) + " miles away");

            Location freshii = new Location("freshii");
            freshii.setLatitude(37.546516);
            freshii.setLongitude(-77.453481);

            distanceToFreshii = Math.round(location.distanceTo(freshii) * 0.0621371f) / 100.0f;
            freshiiDistance = (TextView) findViewById(R.id.freshii);
            freshiiDistance.setText(String.valueOf(distanceToEinsteinShaefer) + " miles away");

            Location ihop = new Location("ihop");
            ihop.setLatitude(37.548941);
            ihop.setLongitude(-77.450330);

            distanceToIHop = Math.round(location.distanceTo(ihop) * 0.0621371f) / 100.0f;
            iHopDistance = (TextView) findViewById(R.id.iHop);
            iHopDistance.setText(String.valueOf(distanceToIHop) + " miles away");

            Location jonah = new Location("jonah");
            jonah.setLatitude(37.544570);
            jonah.setLongitude(-77.429675);

            distanceToJonahs = Math.round(location.distanceTo(jonah) * 0.0621371f) / 100.0f;
            jonahsDistance = (TextView) findViewById(R.id.jonahs);
            jonahsDistance.setText(String.valueOf(distanceToJonahs) + " miles away");

            Location shaefer = new Location("shaefer");
            shaefer.setLatitude(37.548111);
            shaefer.setLongitude(-77.452366);

            distanceToShaefer = Math.round(location.distanceTo(shaefer) * 0.0621371f) / 100.0f;
            shaeferDistance = (TextView) findViewById(R.id.market810);
            shaeferDistance.setText(String.valueOf(distanceToShaefer) + " miles away");

            Location panda = new Location("panda");
            panda.setLatitude(37.550213);
            panda.setLongitude(-77.451494);

            distanceToPanda = Math.round(location.distanceTo(panda) * 0.0621371f) / 100.0f;
            pandaDistance = (TextView) findViewById(R.id.panda);
            pandaDistance.setText(String.valueOf(distanceToPanda) + " miles away");

            Location pizza = new Location("pizza");
            pizza.setLatitude(37.546516);
            pizza.setLongitude(-77.453481);

            distanceToPizzaHut = Math.round(location.distanceTo(pizza) * 0.0621371f) / 100.0f;
            pizzaHutDistance = (TextView) findViewById(R.id.pizzahut);
            pizzaHutDistance.setText(String.valueOf(distanceToPizzaHut) + " miles away");

            Location canes = new Location("canes");
            canes.setLatitude(37.548941);
            canes.setLongitude(-77.450330);

            distanceToCanes = Math.round(location.distanceTo(canes) * 0.0621371f) / 100.0f;
            canesDistance = (TextView) findViewById(R.id.canes);
            canesDistance.setText(String.valueOf(distanceToCanes) + " miles away");

            Location starbucksCabell = new Location("starbucksCabell");
            starbucksCabell.setLatitude(37.547707);
            starbucksCabell.setLongitude(-77.453718);

            distanceToStarbucksCabell = Math.round(location.distanceTo(starbucksCabell) * 0.0621371f) / 100.0f;
            starbucksCabellDistance = (TextView) findViewById(R.id.starbucksCabell);
            starbucksCabellDistance.setText(String.valueOf(distanceToStarbucksCabell) + " miles away");

            Location starbucksCary = new Location("starbucksCary");
            starbucksCary.setLatitude(37.543752);
            starbucksCary.setLongitude(-77.448647);

            distanceToStarbucksCary = Math.round(location.distanceTo(starbucksCary) * 0.0621371f) / 100.0f;
            starbucksCaryDistance = (TextView) findViewById(R.id.starbucksCary);
            starbucksCaryDistance.setText(String.valueOf(distanceToStarbucksCary) + " miles away");

            Location starbucksJonahs = new Location("starbucksJonahs");
            starbucksJonahs.setLatitude(37.544570);
            starbucksJonahs.setLongitude(-77.429675);

            distanceToStarbucksJonahs = Math.round(location.distanceTo(starbucksJonahs) * 0.0621371f) / 100.0f;
            starbucksJonahsDistance = (TextView) findViewById(R.id.starbucksJonah);
            starbucksJonahsDistance.setText(String.valueOf(distanceToStarbucksJonahs) + " miles away");

            Location subway = new Location("subway");
            subway.setLatitude(37.546516);
            subway.setLongitude(-77.453481);

            distanceToSubway = Math.round(location.distanceTo(subway) * 0.0621371f) / 100.0f;
            subwayDistance = (TextView) findViewById(R.id.subway);
            subwayDistance.setText(String.valueOf(distanceToSubway) + " miles away");

            Location tacobell = new Location("tacobell");
            tacobell.setLatitude(37.546516);
            tacobell.setLongitude(-77.453481);

            distanceToTacoBell = Math.round(location.distanceTo(tacobell) * 0.0621371f) / 100.0f;
            tacobellDistance = (TextView) findViewById(R.id.tacobell);
            tacobellDistance.setText(String.valueOf(distanceToTacoBell) + " miles away");


            Location wendys = new Location("wendys");
            wendys.setLatitude(37.540536);
            wendys.setLongitude(-77.430593);

            distanceToWendys = Math.round(location.distanceTo(wendys) * 0.0621371f) / 100.0f;
            wendysDistance = (TextView) findViewById(R.id.wendys);
            wendysDistance.setText(String.valueOf(distanceToWendys) + " miles away");















        }

    }
}
