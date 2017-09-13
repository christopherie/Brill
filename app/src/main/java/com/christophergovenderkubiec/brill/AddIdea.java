package com.christophergovenderkubiec.brill;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddIdea extends AppCompatActivity {

    DatabaseOpenHelper databaseOpenHelper;
    private Button saveIdeaBtn;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_idea);
        editText = (EditText)findViewById(R.id.editText6);
        saveIdeaBtn = (Button)findViewById(R.id.button5);
        databaseOpenHelper = new DatabaseOpenHelper(this);
        saveIdeaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            String newIdea = editText.getText().toString().trim();
            if (editText.length() != 0) {
                AddIdea(newIdea);
                editText.setText("");
                Intent saveIdeaIntent = new Intent(AddIdea.this, GetLocation.class);
                startActivity(saveIdeaIntent);
                finish();
            } else {
                toastMessage("You must add an idea!");
            }
            }
        });
    }

    public void AddIdea(String newIdea) {
        boolean insertIdea = databaseOpenHelper.addIdea(newIdea);
        if (insertIdea) {
            toastMessage("Idea saved!");
        } else {
            toastMessage("Idea not saved!");
        }
    }

    private void toastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
