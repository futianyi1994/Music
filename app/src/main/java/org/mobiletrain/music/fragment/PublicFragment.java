package org.mobiletrain.music.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.alibaba.fastjson.JSON;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnItemClick;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.mobiletrain.music.R;
import org.mobiletrain.music.adapter.GridViewAdapter;
import org.mobiletrain.music.bean.PublicEntity;
import org.mobiletrain.music.ui.MusicListActivity;
import org.mobiletrain.music.uri.UriInterface;

import okhttp3.Call;

/**
 * Created by 天一 on 2016/10/19.
 */
public class PublicFragment extends BaseFragment {

    @ViewInject(R.id.publicfragment_layout_gridViewId)
    private GridView gridView;
    private GridViewAdapter adapter;
    private String ch_name;
    private PublicEntity publicEntity;

    public PublicFragment() {
    }

    public static PublicFragment newInstance() {

        Bundle args = new Bundle();

        PublicFragment fragment = new PublicFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.publicfragment_layout,container,false);
        //标注完注解一定要注入注解
        ViewUtils.inject(this,rootView);

        adapter = new GridViewAdapter(getContext());
        gridView.setAdapter(adapter);

        loadData();
        return rootView;
    }
    @OnItemClick(R.id.publicfragment_layout_gridViewId)
    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
        ch_name = publicEntity.getResult().get(0).getChannellist().get(position).getCh_name();
        Intent intent = new Intent(getActivity(), MusicListActivity.class);
        intent.putExtra("ch_name",ch_name);
        startActivity(intent);
    }

    private void loadData() {
        OkHttpUtils
                .get()
                .url(UriInterface.PUBLIC_URL)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        publicEntity = JSON.parseObject(response, PublicEntity.class);
                        adapter.addAll(publicEntity.getResult().get(0).getChannellist());
                    }
                });

    }
}
