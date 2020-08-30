package com.devengers.salaho.ui.friends;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.devengers.salaho.R;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;


public class FriendsFragment extends Fragment {



    public FriendsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_friends, container, false);
        TabLayout tabLayout=view.findViewById(R.id.tab_friends);
        TabItem friends_request=view.findViewById(R.id.friend_request);
        TabItem friends_search=view.findViewById(R.id.friends_search);
        TabItem friends_list=view.findViewById(R.id.friends_list);
        final ViewPager viewPager=view.findViewById(R.id.friends_viewPager);
        PagerAdapter pagerAdapter=new PageAdapter(getParentFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return view;
    }
}