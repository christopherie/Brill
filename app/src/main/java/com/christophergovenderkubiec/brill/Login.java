package com.christophergovenderkubiec.brill;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import es.dmoral.toasty.Toasty;


public class Login extends AppCompatActivity {

    private EditText inputEmail, inputPassword;
    private FirebaseAuth auth;
    private Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Get Firebase auth instance
        auth = FirebaseAuth.getInstance();

        if (auth.getCurrentUser() != null) {
            startActivity(new Intent(Login.this, IdeaList.class));
        }

        setContentView(R.layout.activity_login);

        inputEmail = findViewById(R.id.editText4);
        inputPassword = findViewById(R.id.editText5);
        loginBtn = findViewById(R.id.button4);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            String email = inputEmail.getText().toString().trim();
            final String password = inputPassword.getText().toString().trim();

            if (TextUtils.isEmpty(email)) {
                Toasty.warning(getApplicationContext(), "Enter email address",
                        Toast.LENGTH_SHORT, true).show();
                return;
            }

            if (TextUtils.isEmpty(password)) {
                Toasty.warning(getApplicationContext(), "Enter password",
                        Toast.LENGTH_SHORT, true).show();
                return;
            }



        // Authenticate user
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                if (!task.isSuccessful()) {
                    // there was an error
                    if (password.length() < 6) {
                        inputPassword.setError(getString(R.string.minimum_password));
                    } else {
                        Toasty.error(Login.this, getString(R.string.auth_failed),
                                Toast.LENGTH_LONG).show();
                    }
                } else {
                    Intent intent = new Intent(Login.this, IdeaList.class);
                    startActivity(intent);
                }
                }
            });
            }
        });
    }
}
