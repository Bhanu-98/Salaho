package com.devengers.salaho;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


public class SignupFragment extends Fragment {


    SharedPreferencesConfiguration prefs;
    String mobile;
    EditText phone;

    public SignupFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_signup, container, false);

        phone = (EditText) view.findViewById(R.id.register_num);

        view.findViewById(R.id.num_register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mobile = phone.getText().toString();
                Bundle signUpBundle = new Bundle();
                signUpBundle.putString("mobile", mobile);
                NavHostFragment.findNavController(SignupFragment.this).navigate(R.id.action_signup_to_otp_verification, signUpBundle);
            }
        });
        return view;
    }
}