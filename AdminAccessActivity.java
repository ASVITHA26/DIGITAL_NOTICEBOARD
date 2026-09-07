package com.example.noticeboard;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class AdminAccessActivity extends AppCompatActivity {
    Button btnHOD, btnPrincipal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_access);

        btnHOD = findViewById(R.id.btnHOD);
        btnPrincipal = findViewById(R.id.btnPrincipal);

        btnHOD.setOnClickListener(v -> openSignOption("HOD"));
        btnPrincipal.setOnClickListener(v -> openSignOption("Principal"));
    }

    void openSignOption(String role) {
        Intent intent = new Intent(this, AdminSignInActivity.class);
        intent.putExtra("role", role);
        startActivity(intent);
    }
}
