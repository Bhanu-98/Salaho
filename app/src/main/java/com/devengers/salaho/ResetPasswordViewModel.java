package com.devengers.salaho;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.devengers.salaho.UserDetailsRepository;
import com.devengers.salaho.UserModel;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

public class ResetPasswordViewModel extends AndroidViewModel{
    UserDetailsRepository userDetailsRepository;
    private MutableLiveData<Boolean> isResetSucessfull;
    String password;

    public MutableLiveData<Boolean> getIsResetSucessfull() {
        return isResetSucessfull;
    }

    public void setIsResetSucessfull(Boolean isResetSucessfull) {
        this.isResetSucessfull.postValue(isResetSucessfull);
    }

    public ResetPasswordViewModel(@NonNull Application application) {
        super(application);
        userDetailsRepository=new UserDetailsRepository(application);
        this.isResetSucessfull = new MutableLiveData<>();
    }

    public void resetpassword(final String password, final String mobileFromReset)
    {
        userDetailsRepository.resetUserPassword(password,mobileFromReset).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                setIsResetSucessfull(true);
                Log.d("Password Reset","Success");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                setIsResetSucessfull(false);
                Log.d("Password Reset",e.toString());
            }
        });
    }
}
