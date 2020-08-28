package com.devengers.salaho.ui.groups;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.devengers.salaho.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link JoinGroupFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class JoinGroupFragment extends Fragment {

    public JoinGroupFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_join_group, container, false);
        return view;
    }
}