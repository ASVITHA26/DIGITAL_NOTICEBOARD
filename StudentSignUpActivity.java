package com.example.noticeboard;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class StudentSignUpActivity extends AppCompatActivity {
    EditText edtUsername, edtPassword;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_sign_up);

        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(v -> {
            SharedPreferences prefs = getSharedPreferences("StudentPrefs", MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString("student_username", edtUsername.getText().toString());
            editor.putString("student_password", edtPassword.getText().toString());
            editor.apply();
            Toast.makeText(this, "Student Registered", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}
