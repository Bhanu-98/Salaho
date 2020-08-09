package com.devengers.salaho;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.SetOptions;
import com.google.firebase.firestore.Transaction;

import org.w3c.dom.DocumentType;

import java.util.HashMap;

public class UserDetailsRepository extends BaseFirestoreRepository {


    public UserDetailsRepository(Context context) {
        super(context);
    }

    public Task<DocumentSnapshot> getUserDetails(String mobile) {
        return userRef.document(mobile).get();
    }

    public Task<DocumentSnapshot> checkUser(String mobile) {
        return userRef.document(mobile).get();
    }

    public Task<Void> registerUserDetails(UserModel user) {
        DocumentReference userDetails = userRef.document(user.getMobile());
        return userDetails.update(user.getMobile(), user);
    }


    public Task<Void> createUser(String mobile) {
        final DocumentReference newUser = userRef.document(mobile);
        final UserModel userModel = new UserModel();
        return mFirestore.runTransaction(new Transaction.Function<Void>() {
            @Nullable
            @Override
            public Void apply(@NonNull Transaction transaction) throws FirebaseFirestoreException {
                transaction.set(newUser, userModel);
                return null;
            }
        });
    }
}
