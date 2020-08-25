package com.devengers.salaho;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;

public class LoginViewModel extends AndroidViewModel {
    UserDetailsRepository userDetailsRepository;
    SharedPreferencesConfiguration prefs;
    private MutableLiveData<Boolean> isUserValid;


    public LoginViewModel(@NonNull Application application) {
        super(application);
        userDetailsRepository=new UserDetailsRepository(application);
        prefs=new SharedPreferencesConfiguration(application);

    }
    public MutableLiveData<Boolean> getIsUserValid() {
        return isUserValid;
    }

    public void setIsUserValid(Boolean isUserValid) {
        this.isUserValid.postValue(isUserValid);
    }

    public void userAuthentication(final String phone, final String pass){
        userDetailsRepository.checkUser(phone).addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        userDetailsRepository.getUserDetails(phone).addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                            @Override
                            public void onSuccess(DocumentSnapshot documentSnapshot) {
                                UserModel loginModel = documentSnapshot.toObject(UserModel.class);
                                Log.d("check", pass);
                                Log.d("check", loginModel.getPass());
                                if (pass.equals(loginModel.getPass())) {
                                    prefs.writeLoginStatus(true);
                                    Log.d("isLoggedin", String.valueOf(prefs.readLoginStatus()));
                                    setIsUserValid(true);
                                } else {
                                    setIsUserValid(false);
                                }

                                Log.d("password", loginModel != null ? loginModel.getPass() : "null");

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.d("failed", e.toString());
                            }
                        });
                    } else {
                        Log.d("error", "user does not exist");
                    }
                }
            }
        });
    }

}
