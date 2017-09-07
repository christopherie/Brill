package com.christophergovenderkubiec.brill;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.location.places.ui.PlacePicker;

public class GetLocation extends AppCompatActivity {
    private TextView getPlace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_location);
        getPlace = (TextView)findViewById(R.id.textView6);
        getPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
                Intent intent;
                //intent = builder.build(getApplicationContext());
            }
        });
    }
}
