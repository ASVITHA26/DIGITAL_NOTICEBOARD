package com.example.noticeboard;

import android.content.*;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class StudentSignInActivity extends AppCompatActivity {
    EditText edtUsername, edtPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_sign_in);

        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(v -> {
            SharedPreferences prefs = getSharedPreferences("StudentPrefs", MODE_PRIVATE);
            String user = prefs.getString("student_username", "");
            String pass = prefs.getString("student_password", "");

            if (user.equals(edtUsername.getText().toString()) &&
                    pass.equals(edtPassword.getText().toString())) {
                startActivity(new Intent(this, StudentDashboardActivity.class));
                finish();
            } else {
                Toast.makeText(this, "Invalid Student Credentials", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
