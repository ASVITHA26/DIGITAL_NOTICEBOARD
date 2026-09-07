package com.example.noticeboard;

import android.content.*;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class AdminSignInActivity extends AppCompatActivity {
    EditText edtUsername, edtPassword;
    Button btnLogin, btnToSignUp;
    String role;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_sign_in);

        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnToSignUp = findViewById(R.id.btnToSignUp);

        role = getIntent().getStringExtra("role");

        btnLogin.setOnClickListener(v -> {
            SharedPreferences prefs = getSharedPreferences("AdminPrefs", MODE_PRIVATE);
            String savedUser = prefs.getString(role + "_username", "");
            String savedPass = prefs.getString(role + "_password", "");

            if (savedUser.equals(edtUsername.getText().toString()) &&
                    savedPass.equals(edtPassword.getText().toString())) {
                Intent intent = new Intent(this, UploadNoteActivity.class);
                intent.putExtra("role", role);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
            }
        });

        btnToSignUp.setOnClickListener(v -> {
            Intent intent = new Intent(this, AdminSignUpActivity.class);
            intent.putExtra("role", role);
            startActivity(intent);
        });
    }
}
