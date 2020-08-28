package com.devengers.salaho.ui.groups;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.devengers.salaho.R;
import com.google.android.material.tabs.TabLayout;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GroupFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GroupFragment extends Fragment {


    public GroupFragment() {
        // Required empty public constructor
    }


    public static GroupFragment newInstance(String param1, String param2) {
        GroupFragment fragment = new GroupFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_group, container, false);
        ViewPager viewPager = view.findViewById(R.id.group_fragment_view_pager);
        GroupViewPagerAdapter pagerAdapter = new GroupViewPagerAdapter(getChildFragmentManager(), 0);
        viewPager.setAdapter(pagerAdapter);
        TabLayout groupTabs = view.findViewById(R.id.groupTabLayout);
        groupTabs.setupWithViewPager(viewPager);
        return view;
        // Inflate the layout for this fragment
    }
}