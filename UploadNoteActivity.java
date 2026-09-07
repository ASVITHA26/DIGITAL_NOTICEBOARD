package com.example.noticeboard;

import android.content.*;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class UploadNoteActivity extends AppCompatActivity {
    EditText edtNote;
    Button btnUpload;
    String role;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_note);

        edtNote = findViewById(R.id.edtNote);
        btnUpload = findViewById(R.id.btnUpload);
        role = getIntent().getStringExtra("role");

        btnUpload.setOnClickListener(v -> {
            SharedPreferences prefs = getSharedPreferences("NotesPrefs", MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            String allNotes = prefs.getString("all_notes", "");
            allNotes += role + ": " + edtNote.getText().toString() + "\n";
            editor.putString("all_notes", allNotes);
            editor.apply();
            Toast.makeText(this, "Note Uploaded", Toast.LENGTH_SHORT).show();
            edtNote.setText("");
        });
    }
}
