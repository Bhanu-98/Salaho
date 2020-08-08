package com.devengers.salaho;

import android.content.Context;

import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class UserDetailsRepository extends BaseFirestoreRepository {


    public UserDetailsRepository(Context context) {
        super(context);
    }

    public Task<DocumentSnapshot> getUserDetails(String mobile)
    {
        return  userRef.document(mobile).get();
    }

    public Task<DocumentSnapshot> checkUser(String mobile){
        return userRef.document(mobile).get();
    }
}
