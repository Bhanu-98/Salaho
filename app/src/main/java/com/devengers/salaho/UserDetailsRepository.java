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

    public Task<DocumentSnapshot> getUserDetails(String mobile)
    {
        return  userRef.document(mobile).get();
    }

    public Task<DocumentSnapshot> checkUser(String mobile){
        return userRef.document(mobile).get();
    }
    public Task<Void> setUserDetails(UserModel user)
    {
        DocumentReference userDetails=userRef.document(user.getMobile());
        return userDetails.update(user.getMobile(),user);
    }
    public Task<Void> setUser(String mobile) {
//        DocumentReference userCreate = userRef.document(mobile);
        final DocumentReference neUser = userRef.document(mobile);
        final UserModel userModel = new UserModel();
        userModel.setFullname("Bhanu");
        userModel.setMobile(mobile);
        mFirestore.runTransaction(new Transaction.Function<Void>() {
            @Nullable
            @Override
            public Void apply(@NonNull Transaction transaction) throws FirebaseFirestoreException {
                transaction.set(neUser, userModel);
                return null;
            }
        });
        return null;
    }
}
