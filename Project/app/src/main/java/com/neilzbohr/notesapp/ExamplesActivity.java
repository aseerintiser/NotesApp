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
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
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

//        Map<String, Object> map = new HashMap<>();
//        map.put("text", "I wanna learn to live");
//        map.put("isCompleted",false);
//        map.put("created", new Timestamp(new Date()));
//
//        firestore.collection("notes")
//                .add(map)
//                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
//                    @Override
//                    public void onSuccess(DocumentReference documentReference) {
//                        Log.d(TAG, "onSuccess: Task was successful");
//                        Log.d(TAG, "onSuccess: " + documentReference.getId());
//                    }
//                })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Log.d(TAG, "onFailure: Task was not successful");
//                    }
//                });

        Map<String, Object> map = new HashMap<>();
        map.put("name", "iPhone 11");
        map.put("price", 699);
        map.put("isAvailable", true);

        FirebaseFirestore.getInstance()
                .collection("products")
                .add(map)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG, "onSuccess: Product is added successfully");
                        Log.d(TAG, "onSuccess: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.e(TAG, "onFailure: ", e);
                    }
                });

    }

    public void readDocument(View view) {
        //Toast.makeText(this, "readDocument", Toast.LENGTH_SHORT).show();
//        FirebaseFirestore.getInstance()
//                .collection("products")
//                .get()
//                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//                    @Override
//                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//                        Log.d(TAG, "onSuccess: We're getting the data");
//                        List<DocumentSnapshot> snapshotList = queryDocumentSnapshots.getDocuments();
//                        for(DocumentSnapshot snapshot : snapshotList) {
//                            Log.d(TAG, "onSuccess: " + snapshot.getData());
//                        }
//                    }
//                })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Log.e(TAG, "onFailure: ", e);
//                    }
//                });

//        FirebaseFirestore.getInstance()
//                .collection("products")
//                //.whereLessThan("price", 500)
//                //.whereEqualTo("isAvailable", false)
//                //.whereEqualTo("price", 499)
//                .get()
//                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//                    @Override
//                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//                        Log.d(TAG, "onSuccess: We're getting the data");
//                        List<DocumentSnapshot> snapshotList = queryDocumentSnapshots.getDocuments();
//                        for(DocumentSnapshot snapshot : snapshotList) {
//                            Log.d(TAG, "onSuccess: " + snapshot.getData());
//                        }
//                    }
//                })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Log.e(TAG, "onFailure: ", e);
//                    }
//                });

        FirebaseFirestore.getInstance()
                .collection("products")
                .document("tlIpf6HcJkuzTHaaq4AZ")
                .get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        Log.d(TAG, "onSuccess: " + documentSnapshot.getId());
                        Log.d(TAG, "onSuccess: " + documentSnapshot.getData());
                        Log.d(TAG, "onSuccess: " + documentSnapshot.getString("name"));
                        Log.d(TAG, "onSuccess: " + documentSnapshot.getBoolean("isAvailable"));
                        Log.d(TAG, "onSuccess: " + documentSnapshot.getDouble("price"));
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.e(TAG, "onFailure: ", e);
                    }
                });
    }

    public void updateDocument(View view) {
        Toast.makeText(this, "updateDocument", Toast.LENGTH_SHORT).show();
    }

    public void deleteDocument(View view) {
        Toast.makeText(this, "deleteDocument", Toast.LENGTH_SHORT).show();
    }

    public void getAllDocuments(View view) {
        //Toast.makeText(this, "getAllDocuments", Toast.LENGTH_SHORT).show();

        FirebaseFirestore.getInstance()
                .collection("products")
                //.orderBy("price")
                //.orderBy("price", Query.Direction.DESCENDING)
                .limit(2)
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        List<DocumentSnapshot> snapshotList = queryDocumentSnapshots.getDocuments();
                        for(DocumentSnapshot snapshot : snapshotList) {
                            Log.d(TAG, "onSuccess: " + snapshot.getData());
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.e(TAG, "onFailure: ", e);
                    }
                });
    }

    public void getAllDocumentsWithRealtimeUpdates(View view) {
        Toast.makeText(this, "getAllDocumentsWithRealtimeUpdates", Toast.LENGTH_SHORT).show();
    }
}