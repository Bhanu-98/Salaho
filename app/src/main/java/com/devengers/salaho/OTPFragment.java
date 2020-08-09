package com.devengers.salaho;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;


public class OTPFragment extends Fragment {
    TextView tv;
    EditText evOTP;
    String otp;
    SharedPreferencesConfiguration prefs;
    UserDetailsRepository userDetailsRepository;
    private String mobileFromSignUp;
    private Button verifyOtpButton;


    public OTPFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_otp, container, false);
        tv = (TextView) view.findViewById(R.id.otp_number);
        Bundle bundle = getArguments();
        if (bundle != null) {
            mobileFromSignUp = bundle.getString("mobile");
            tv.setText(bundle.getString("mobile"));
        }
        evOTP = (EditText) view.findViewById(R.id.otp_pin);
        userDetailsRepository = new UserDetailsRepository(getContext());
        verifyOtpButton = view.findViewById(R.id.verify_otp);


        verifyOtpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifyEnteredOtp(evOTP.getText().toString());
            }
        });
        return view;
    }

    private void verifyEnteredOtp(String enteredOTP) {
        otp = evOTP.getText().toString();
        if (otp.equals("123456")) {
            userDetailsRepository.createUser(mobileFromSignUp).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    Log.d("Signup", "Signupsuccess");
                    NavHostFragment.findNavController(OTPFragment.this)
                            .navigate(R.id.action_otp_verification_to_register);
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Log.d("signupfailed", "Signup failed");
                }
            });

        } else {
            evOTP.setError("Incorrect Pin");
        }
    }
}

