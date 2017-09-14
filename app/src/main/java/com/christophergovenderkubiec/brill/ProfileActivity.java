package com.christophergovenderkubiec.brill;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
    DatabaseOpenHelper databaseOpenHelper;
    private TextView ideaCount, userLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ideaCount = (TextView)findViewById(R.id.textView8);
        userLevel = findViewById(R.id.textView9);
        databaseOpenHelper = new DatabaseOpenHelper(this);
        populateIdeaCount();

    }

    private void populateIdeaCount() {
        int data = databaseOpenHelper.countIdeas();
        databaseOpenHelper.close();
        ideaCount.setText(String.valueOf(data));
    }
}
