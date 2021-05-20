package com.example.cognizant.Screens;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

import com.example.cognizant.R;
import com.google.firebase.auth.FirebaseAuth;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private Button login;
    private FirebaseAuth auth;
    private TextView username;
    private TextView password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        auth = FirebaseAuth.getInstance();
        login = (Button) findViewById(R.id.loginBtn);
        username = (TextView) findViewById(R.id.username);
        password = (TextView) findViewById(R.id.password);
        login.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        String userEmail = username.getText().toString();
        String userPassword = password.getText().toString();

        // if either the username or password field is empty, show an error message
        if(userEmail.isEmpty() || userPassword.isEmpty()) {
            Toast.makeText(LoginActivity.this, "Please do not leave empty fields", Toast.LENGTH_LONG).show();
        }
        /**
         * Check if userEmail and userPassword same as the ones stored in Cloud Firestore
         * {username = test@test.com, password: cognizant}
         */
        else {
            auth.signInWithEmailAndPassword(userEmail, userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        startActivity(new Intent(LoginActivity.this, ListViewActivity.class));
                    } else {
                        Toast.makeText(LoginActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            });
        }

    }
}