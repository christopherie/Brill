package com.christophergovenderkubiec.brill;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AddIdea extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_idea);
        Button saveIdeaBtn = (Button)findViewById(R.id.button5);
        saveIdeaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent saveIdeaIntent = new Intent(AddIdea.this, AddLocation.class);
                //startActivity(saveIdeaIntent);
            }
        });
    }
}
