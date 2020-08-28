package com.devengers.salaho;

import android.content.Context;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class BaseFirestoreRepository {

    public BaseFirestoreRepository(Context context) {

    }
    protected FirebaseFirestore mFirestore = FirebaseFirestore.getInstance();

    protected CollectionReference userRef = mFirestore.collection("Test");
    protected CollectionReference registerRef = mFirestore.collection("NonRegisteredUsers");
    protected CollectionReference groupsRef = mFirestore.collection("Groups");



}
