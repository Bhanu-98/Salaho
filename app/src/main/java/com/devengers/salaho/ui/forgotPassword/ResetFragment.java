package com.devengers.salaho.ui.forgotPassword;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.devengers.salaho.R;
import com.devengers.salaho.SharedPreferencesConfiguration;

public class ResetFragment extends Fragment {

    SharedPreferencesConfiguration prefs;
    EditText phone;
    String mobile;

    public ResetFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reset, container, false);
        phone = (EditText) view.findViewById(R.id.reset_num);

        view.findViewById(R.id.num_reset).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mobile = phone.getText().toString();
                Bundle resetBundle = new Bundle();
                resetBundle.putString("mobile", mobile);
                NavHostFragment.findNavController(ResetFragment.this).navigate(R.id.action_reset_otp_to_recheck_otp, resetBundle);
            }
        });

        return view;
    }
}