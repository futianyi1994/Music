package org.mobiletrain.music.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import org.mobiletrain.music.fragment.BaseFragment;

import java.util.List;

/**
 * Created by 天一 on 2016/10/19.
 */
public class MusicFragmentPagerAdapter extends FragmentPagerAdapter {
    private List<BaseFragment> fragments;
    private String[] TITLE = new String[]{"公共频道","音乐人"};

    public MusicFragmentPagerAdapter(FragmentManager fm,List<BaseFragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return TITLE[position];
    }
}
