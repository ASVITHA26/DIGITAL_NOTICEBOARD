package com.example.noticeboard;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class StudentDashboardActivity extends AppCompatActivity {
    TextView txtNotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_dashboard);

        txtNotes = findViewById(R.id.txtNotes);

        SharedPreferences prefs = getSharedPreferences("NotesPrefs", MODE_PRIVATE);
        String notes = prefs.getString("all_notes", "No notes uploaded yet.");
        txtNotes.setText(notes);
    }
}
