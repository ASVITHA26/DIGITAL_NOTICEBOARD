package com.example.noticeboard;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class StudentAccessActivity extends AppCompatActivity {
    Button btnSignIn, btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_access);

        btnSignIn = findViewById(R.id.btnSignIn);
        btnSignUp = findViewById(R.id.btnSignUp);

        btnSignIn.setOnClickListener(v -> startActivity(new Intent(this, StudentSignInActivity.class)));
        btnSignUp.setOnClickListener(v -> startActivity(new Intent(this, StudentSignUpActivity.class)));
    }
}
