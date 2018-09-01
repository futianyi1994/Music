package org.mobiletrain.music.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.alibaba.fastjson.JSON;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnItemClick;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.mobiletrain.music.R;
import org.mobiletrain.music.adapter.MusicListAdapter;
import org.mobiletrain.music.bean.MusicEntity;
import org.mobiletrain.music.uri.UriInterface;

import okhttp3.Call;

@ContentView(R.layout.activity_music_list)
public class MusicListActivity extends BaseActivity {


    @ViewInject(R.id.activity_music_list_listViewId)
    private ListView listView;

    private MusicListAdapter adapter;
    private String ch_name;
    private MusicEntity musicEntity;
    private String songid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewUtils.inject(this);
        Intent intent = getIntent();
        ch_name = intent.getStringExtra("ch_name");
        adapter = new MusicListAdapter(this);
        listView.setAdapter(adapter);
        loadData();

    }

    @OnItemClick(R.id.activity_music_list_listViewId)
    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
        songid = musicEntity.getResult().getSonglist().get(position).getSongid();
        Intent intent = new Intent(this,MusicActivity.class);
        intent.putExtra("songid",songid);
        startActivity(intent);
    }



    private void loadData() {
        OkHttpUtils
                .get()
                .url(UriInterface.getMusicUrl(ch_name))
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        musicEntity = JSON.parseObject(response,MusicEntity.class);
                        adapter.addAll(musicEntity.getResult().getSonglist());
                    }
                });
    }
}
