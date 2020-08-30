package com.devengers.salaho;

import android.content.Context;
import android.util.Log;

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
        Log.d("usermodel",user.getMobile());
        return userDetails.set(user,SetOptions.merge());
//        return null;
    }

    public Task<Void> resetUserPassword(String password,String mobileFromReset) {
        DocumentReference userDetails = userRef.document(mobileFromReset);
        //Log.d("usermodel",user.getMobile());
        return userDetails.update("password",password);
//        return null;
    }


    public Task<Void> createUser(String mobile) {
        final DocumentReference newUser = userRef.document(mobile);
        final UserModel userModel = new UserModel();
        DocumentReference users=registerRef.document(mobile);
        users.set(new HashMap<String,Object>());

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
