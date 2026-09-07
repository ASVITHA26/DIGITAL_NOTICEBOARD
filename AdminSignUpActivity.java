package com.example.noticeboard;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class AdminSignUpActivity extends AppCompatActivity {
    EditText edtUsername, edtPassword;
    Button btnRegister;
    String role;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_sign_up);

        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnRegister = findViewById(R.id.btnRegister);
        role = getIntent().getStringExtra("role");

        btnRegister.setOnClickListener(v -> {
            SharedPreferences prefs = getSharedPreferences("AdminPrefs", MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString(role + "_username", edtUsername.getText().toString());
            editor.putString(role + "_password", edtPassword.getText().toString());
            editor.apply();
            Toast.makeText(this, "Registered Successfully", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}
