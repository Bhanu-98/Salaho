package com.devengers.salaho;

import android.app.Application;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

public class RegisterViewModel extends AndroidViewModel {
    UserDetailsRepository userDetailsRepository;
    private MutableLiveData<Boolean> isRegistered;
    public RegisterViewModel(@NonNull Application application) {
        super(application);
        userDetailsRepository=new UserDetailsRepository(application);
        this.isRegistered=new MutableLiveData<>();
    }
    public MutableLiveData<Boolean> getIsRegistered() {
        return isRegistered;
    }

    public void setIsRegistered(Boolean isRegistered) {
        this.isRegistered.postValue(isRegistered);
    }

    public void registerDetails(UserModel userModel, final String mobilefromOTP)
    {
        userDetailsRepository.registerUserDetails(userModel).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                setIsRegistered(true);
                Log.d("Register","Success");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                setIsRegistered(false);
                Log.d("Register",e.toString());
            }
        });
    }
}
