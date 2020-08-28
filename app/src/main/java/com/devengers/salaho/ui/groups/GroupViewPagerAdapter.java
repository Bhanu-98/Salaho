package com.devengers.salaho.ui.groups;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

public class GroupViewPagerAdapter extends FragmentPagerAdapter {
    public GroupViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @Override
    public int getCount() {
        return 2;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment frag = null;
        switch (position) {
            case 0:
                frag = new CreateGroupFragment();
                break;
            case 1:
                frag = new JoinGroupFragment();
                break;
        }
        return frag;
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String viewPagerTitle = "";
        if (position == 0) {
            viewPagerTitle = "Create Group";
        } else {
            viewPagerTitle = "Join Group";
        }
        return viewPagerTitle;
    }
}
