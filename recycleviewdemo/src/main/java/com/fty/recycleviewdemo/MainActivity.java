package com.fty.recycleviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

import static com.fty.recycleviewdemo.R.id.activity_mian_recycleviewId;

public class MainActivity extends AppCompatActivity implements RecycleAdapter.OnclickListener, RecycleAdapter.OnLongClickListener {
    private RecyclerView recyclerView;
    private RecycleAdapter recycleAdapter;
    private ArrayList<String> datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(activity_mian_recycleviewId);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,3);
        recycleAdapter = new RecycleAdapter(this);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(recycleAdapter);
        recycleAdapter.setListener(this);
        recycleAdapter.setLongClickListener(this);
        datas = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            datas.add("item"+i);
        }
        recycleAdapter.addAll(datas);
    }

    @Override
    public void onClick(View view, int position) {
        recycleAdapter.addDatas(position,"wzq");
    }

    @Override
    public void longOnClick(View view, int position) {
        recycleAdapter.removeDatas(position);
    }
}
