package afeka.battleship;

import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

import afeka.battleship.Model.Score;
import afeka.battleship.logic.Game;

public class ScoreActivity extends FragmentActivity implements OnMapReadyCallback, HighScoreFragment.OnFragmentInteractionListener {

    private GoogleMap mMap;
    private Score[] scoreList;
    private int difficult;
    private HighScoreFragment highScoreFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mapFargment);
        mapFragment.getMapAsync(this);
        highScoreFragment = (HighScoreFragment) getSupportFragmentManager().findFragmentById(R.id.scoreTableFragment);




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

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-33.852, 151.211);
        googleMap.addMarker(new MarkerOptions().position(sydney)
                .title("Marker in Sydney"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }


    public void showScoreList(View view) {
        switch (view.getId()){
            case R.id.scoreEasy:
                this.difficult = 3;
                break;
            case R.id.scoreMedium:
                this.difficult = 2;
                break;
            case R.id.scoreHard:
                this.difficult = 1;
                break;
            default:
                this.difficult = 1;
                break;
        }



    }
}
