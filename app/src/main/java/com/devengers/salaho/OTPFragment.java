package com.devengers.salaho;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;


public class OTPFragment extends Fragment {
    TextView tv;
    EditText ev;
    String otp;
    SharedPreferencesConfiguration prefs;
    UserDetailsRepository userDetailsRepository;


    public OTPFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_otp, container, false);
        tv=(TextView) view.findViewById(R.id.otp_number);
        prefs=new SharedPreferencesConfiguration(getContext());
        tv.setText(prefs.readMobileNumber());
        ev=(EditText) view.findViewById(R.id.otp_pin);

        view.findViewById(R.id.verify_otp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                otp= ev.getText().toString();
                if(otp.equals("123456"))
                {

                    userDetailsRepository = new UserDetailsRepository(getContext());
//                    UserModel userModel=new UserModel();
                    userDetailsRepository.setUser(prefs.readMobileNumber());
                    NavHostFragment.findNavController(OTPFragment.this)
                            .navigate(R.id.action_otp_verification_to_register);

                }
                else {
                    ev.setError("Incorrect Pin");
                }
            }
        });

        return view;
    }
}