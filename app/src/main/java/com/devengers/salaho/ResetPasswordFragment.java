package com.devengers.salaho;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class ResetPasswordFragment extends Fragment {

    EditText pass,cpass;
    Utils utils;
    String password;
    String mobile;

    UserDetailsRepository userDetailsRepository;
    ResetPasswordViewModel resetPasswordViewModel;
    String mobileFromReset;

    public ResetPasswordFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reset_password, container, false);
        pass=(EditText)view.findViewById(R.id.password);
        cpass=(EditText)view.findViewById(R.id.confirm_password);
        final Bundle bundle = getArguments();
        mobileFromReset= bundle.getString("mobile");
        userDetailsRepository = new UserDetailsRepository(getContext());
        utils=new Utils();

        view.findViewById(R.id.reset_password).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utils.hideKeyboard(getActivity());
                ResetPassword(mobileFromReset);
            }
        });
        return view;
    }

    private void ResetPassword(final String mobileFromReset){

        if(pass.getText().toString().equals(cpass.getText().toString())){
            password = pass.getText().toString();

            resetPasswordViewModel = ViewModelProviders.of(this).get(ResetPasswordViewModel.class);
            resetPasswordViewModel.resetpassword(password,mobileFromReset);
        }
        else
        {
            cpass.setError("Password does not match");
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        resetPasswordViewModel = ViewModelProviders.of(this).get(ResetPasswordViewModel.class);
        resetPasswordViewModel.getIsResetSucessfull().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean)
                {
                    Bundle bd=new Bundle();
                    bd.putString("ResetMobile",mobileFromReset);
                    NavHostFragment.findNavController(ResetPasswordFragment.this)
                            .navigate(R.id.action_reset_password_to_login,bd);
                }
            }
        });
    }
}