package com.devengers.salaho;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.DocumentReference;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.devengers.salaho.UserDetailsRepository;

import static android.content.Context.MODE_PRIVATE;


public class LoginFragment extends Fragment {


    UserDetailsRepository userDetailsRepository;


    EditText num,password;
    String pass,phone;
    SharedPreferencesConfiguration prefs;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        num= (EditText) view.findViewById(R.id.login_phone);
        password=(EditText) view.findViewById(R.id.login_password);
        userDetailsRepository = new UserDetailsRepository(getContext());
        prefs = new SharedPreferencesConfiguration(getContext());
        Log.d("isLoggedin",String.valueOf(prefs.readLoginStatus()));
        if(prefs.readLoginStatus())
        {
            NavHostFragment.findNavController(LoginFragment.this)
                    .navigate(R.id.action_login_to_nav_home);
        }

        view.findViewById(R.id.login_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserAuthentication();
            }
        });

        return view;
    }
    private void UserAuthentication()
    {
        phone=num.getText().toString();
        if(!TextUtils.isEmpty(num.getText())) {
            pass = password.getText().toString();


            userDetailsRepository.checkUser(phone).addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    if(task.isSuccessful())
                    {
                        DocumentSnapshot document=task.getResult();
                        if(document.exists())
                        {
                            userDetailsRepository.getUserDetails(phone).addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                @Override
                                public void onSuccess(DocumentSnapshot documentSnapshot) {
                                    LoginModel loginModel=documentSnapshot.toObject(LoginModel.class);
                                    Log.d("check",pass);
                                    Log.d("check",loginModel.getPass());
                                    if(pass.equals(loginModel.getPass()))
                                    {
                                        prefs.writeLoginStatus(true);
                                        Log.d("isLoggedin",String.valueOf(prefs.readLoginStatus()));

                                        NavHostFragment.findNavController(LoginFragment.this)
                                                .navigate(R.id.action_login_to_nav_home);
                                    }
                                    else {
                                        password.setError("In correct password");
//                                                 NavHostFragment.findNavController(LoginFragment.this)
//                                                         .navigate(R.id.action_login_self);
                                    }

                                    Log.d("password", loginModel != null ? loginModel.getPass() : "null");

                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.d("failed",e.toString());
                                }
                            });
                        }
                        else
                        {
                            Log.d("error","user does not exist");
                            num.setError("User doesn't exist please register first");
                        }
                    }
                }
            });



        }
        else{
            num.setError("Phone num is required");
            Log.d("error","wrong num");

        }
    }
}