package org.mobiletrain.music.ui;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;

import org.mobiletrain.music.R;
import org.mobiletrain.music.adapter.MusicFragmentPagerAdapter;
import org.mobiletrain.music.fragment.BaseFragment;
import org.mobiletrain.music.fragment.MusicFragment;
import org.mobiletrain.music.fragment.PublicFragment;

import java.util.ArrayList;
import java.util.List;

@ContentView(R.layout.activity_main)
public class MainActivity extends BaseActivity {

    private List<BaseFragment> fragments;

    @ViewInject(R.id.activity_main_viewPagerId)
    private ViewPager viewPager;

    @ViewInject(R.id.activity_main_tabLayoutId)
    private TabLayout tabLayout;

    private MusicFragmentPagerAdapter musicFragmentPagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewUtils.inject(this);

        fragments = new ArrayList<>();
        fragments.add(PublicFragment.newInstance());
        fragments.add(MusicFragment.newInstance());

        musicFragmentPagerAdapter = new MusicFragmentPagerAdapter(getSupportFragmentManager(),fragments);
        viewPager.setAdapter(musicFragmentPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
