package com.neilzbohr.notesapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ExamplesActivity extends AppCompatActivity {

    private static final String TAG = "ExamplesActivity";
    FirebaseFirestore firestore = FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examples);
    }

    public void createDocument(View view) {
        //Toast.makeText(this, "createDocument", Toast.LENGTH_SHORT).show();
        //FirebaseFirestore.getInstance();

        Map<String, Object> map = new HashMap<>();
        map.put("text", "I wanna learn to live");
        map.put("isCompleted",false);
        map.put("created", new Timestamp(new Date()));

        firestore.collection("notes")
                .add(map)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG, "onSuccess: Task was successful");
                        Log.d(TAG, "onSuccess: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.d(TAG, "onFailure: Task was not successful");
                    }
                });

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