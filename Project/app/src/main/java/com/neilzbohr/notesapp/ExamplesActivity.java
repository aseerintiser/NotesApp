package com.neilzbohr.notesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ExamplesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examples);
    }

    public void createDocument(View view) {
        Toast.makeText(this, "createDocument", Toast.LENGTH_SHORT).show();
    }

    public void readDocument(View view) {
        Toast.makeText(this, "readDocument", Toast.LENGTH_SHORT).show();
    }

    public void updateDocument(View view) {
        Toast.makeText(this, "updateDocument", Toast.LENGTH_SHORT).show();
    }

    public void deleteDocument(View view) {
        Toast.makeText(this, "deleteDocument", Toast.LENGTH_SHORT).show();
    }

    public void getAllDocuments(View view) {
        Toast.makeText(this, "getAllDocuments", Toast.LENGTH_SHORT).show();
    }

    public void getAllDocumentsWithRealtimeUpdates(View view) {
        Toast.makeText(this, "getAllDocumentsWithRealtimeUpdates", Toast.LENGTH_SHORT).show();
    }
}