package com.devengers.salaho.ui.signup;

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

import com.devengers.salaho.R;
import com.devengers.salaho.UserDetailsRepository;
import com.devengers.salaho.UserModel;
import com.devengers.salaho.Utils;


public class RegisterFragment extends Fragment {

    EditText uname,pass,cpass,email,fname;
    Utils utils;

    UserDetailsRepository userDetailsRepository;
    RegisterViewModel registerViewModel;

    String mobilefromOTP;




    public RegisterFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_register, container, false);
        uname=(EditText)view.findViewById(R.id.username);
        fname=(EditText)view.findViewById(R.id.full_name);
        pass=(EditText)view.findViewById(R.id.password);
        cpass=(EditText)view.findViewById(R.id.confirm_password);
        email=(EditText)view.findViewById(R.id.email_id);
        final Bundle bundle = getArguments();
        mobilefromOTP= bundle.getString("mobile");
        userDetailsRepository = new UserDetailsRepository(getContext());
        utils=new Utils();

        view.findViewById(R.id.Register_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utils.hideKeyboard(getActivity());
                RegisterUserDetails(mobilefromOTP);
            }
        });

        return view;
    }

    private void RegisterUserDetails(final String mobilefromOTP)
    {

        if(pass.getText().toString().equals(cpass.getText().toString()))
        {
            UserModel userModel = new UserModel();

            userModel.setFullname(fname.getText().toString());
            userModel.setUsername(uname.getText().toString());
            userModel.setEmail(email.getText().toString());
            userModel.setPass(pass.getText().toString());
            userModel.setMobile(mobilefromOTP);
            registerViewModel= ViewModelProviders.of(this).get(RegisterViewModel.class);
            registerViewModel.registerDetails(userModel,mobilefromOTP);

//            userDetailsRepository.registerUserDetails(userModel).addOnSuccessListener(new OnSuccessListener<Void>() {
//                @Override
//                public void onSuccess(Void aVoid) {
//                    Bundle bd=new Bundle();
//                    bd.putString("signUpMobile",mobilefromOTP);
//                    Log.d("Register","Success");
//                    NavHostFragment.findNavController(RegisterFragment.this)
//                            .navigate(R.id.action_register_to_login,bd);
//
//                }
//            }).addOnFailureListener(new OnFailureListener() {
//                @Override
//                public void onFailure(@NonNull Exception e) {
//                    Log.d("register",e.toString());
//                }
//            });

        }
        else
        {
            cpass.setError("Password does not match");
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        registerViewModel= ViewModelProviders.of(this).get(RegisterViewModel.class);
        registerViewModel.getIsRegistered().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean)
                {
                    Bundle bd=new Bundle();
                    bd.putString("signUpMobile",mobilefromOTP);
                    NavHostFragment.findNavController(RegisterFragment.this)
                            .navigate(R.id.action_register_to_login,bd);
                }
            }
        });
    }
}