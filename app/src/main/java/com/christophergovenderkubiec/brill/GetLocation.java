package com.christophergovenderkubiec.brill;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;

import es.dmoral.toasty.Toasty;

public class GetLocation extends AppCompatActivity {
    private TextView getPlace;
    private Button saveLocationBtn;
    int PLACE_PICKER_REQUEST = 1;
    DatabaseOpenHelper databaseOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_location);
        getPlace = findViewById(R.id.textView6);
        saveLocationBtn = findViewById(R.id.button6);
        databaseOpenHelper = new DatabaseOpenHelper(this);
        getPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
            Intent intent;
            try {
                intent = builder.build(GetLocation.this);
                startActivityForResult(intent, PLACE_PICKER_REQUEST);
            } catch (GooglePlayServicesRepairableException e) {
                e.printStackTrace();
            } catch (GooglePlayServicesNotAvailableException e) {
                e.printStackTrace();
            }
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PLACE_PICKER_REQUEST) {
            if (resultCode == RESULT_OK) {
                Place place = PlacePicker.getPlace(GetLocation.this, data);
                final String address = String.format("%s", place.getAddress());
                getPlace.setText(address);
                saveLocationBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (address.length() != 0) {
                            AddLocation(address);
                            Intent saveLocationIntent = new Intent(GetLocation.this,
                                    ProfileActivity.class);
                            startActivity(saveLocationIntent);
                            finish();
                        } else {
                            Toasty.error(GetLocation.this, "You must get your location",
                                    Toast.LENGTH_SHORT, true).show();
                        }
                    }
                });
            }
        }
    }

    private void AddLocation(String address) {
        boolean insertLocation = databaseOpenHelper.addLocation(address);
        if (insertLocation) {
            // Toasty success
            Toasty.success(GetLocation.this, "Location saved", Toast.LENGTH_SHORT, true).show();
        } else {
            // Toasty error
            Toasty.error(GetLocation.this, "Location not saved", Toast.LENGTH_SHORT, true).show();
        }
    }
}
