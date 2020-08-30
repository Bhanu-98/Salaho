package com.devengers.salaho.ui.forgotPassword;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.devengers.salaho.R;
import com.devengers.salaho.SharedPreferencesConfiguration;
import com.devengers.salaho.UserDetailsRepository;

public class VerifyOTPFragment extends Fragment {

    TextView tv;
    EditText evOTP;
    String otp;
    SharedPreferencesConfiguration prefs;
    UserDetailsRepository userDetailsRepository;
    private String mobileFromReset;
    private Button verifyOtpButton;
    public VerifyOTPFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_verify_otp, container, false);
        tv = (TextView) view.findViewById(R.id.otp_number);
        Bundle bundle = getArguments();
        if (bundle != null) {
            mobileFromReset = bundle.getString("mobile");
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
            Log.d("Reset", "Resetsuccess");
            Bundle OTPBundle = new Bundle();
            OTPBundle.putString("mobile", mobileFromReset);
            NavHostFragment.findNavController(VerifyOTPFragment.this)
                    .navigate(R.id.action_recheck_otp_to_reset_password
                            ,OTPBundle);

        } else {
            evOTP.setError("Incorrect Pin");
        }
    }
}