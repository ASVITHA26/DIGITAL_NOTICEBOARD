package com.example.noticeboard;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    // Best practice: Keep modifiers private if they aren't used outside this class
    private Button btnAdmin, btnStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdmin = findViewById(R.id.btnAdmin);
        btnStudent = findViewById(R.id.btnStudent);

        // Fixed: Use MainActivity.this to explicitly pass the correct Context
        btnAdmin.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AdminAccessActivity.class);
            startActivity(intent);
        });

        btnStudent.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, StudentAccessActivity.class);
            startActivity(intent);
        });
    }
}