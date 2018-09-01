package org.mobiletrain.music.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.mobiletrain.music.MyApp;
import org.mobiletrain.music.R;
import org.mobiletrain.music.bean.DetailEntity;
import org.mobiletrain.music.uri.UriInterface;

import java.io.IOException;

import okhttp3.Call;

@ContentView(R.layout.activity_music)
public class MusicActivity extends BaseActivity implements View.OnClickListener {

    private String songid;

    @ViewInject(R.id.musicactivity_imageViewId)
    private ImageView imageView;

    @ViewInject(R.id.musicactivity_timeId)
    private TextView timeText;

    @ViewInject(R.id.musicactivity_seekBarId)
    private SeekBar seekBar;

    @ViewInject(R.id.musicactivity_playerControlId)
    private ImageView playerControl;

    @ViewInject(R.id.musicactivity_previousId)
    private ImageView previousControl;

    @ViewInject(R.id.musicactivity_nextId)
    private ImageView nextControl;

    private MediaPlayer mediaPlayer;
    private Bitmap bitmapPause;
    private Bitmap bitmapPlay;

    UpdateSeekbarProgressReceiver updateSeekbarProgressReceiver;

    private static final String UPDATESEEKBARPROGRESS = "updateSeekbarProgress";
    private DetailEntity detailEntity;
    private String songLink;
    private String songPicRadio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewUtils.inject(this);
        Intent intent = getIntent();
        songid = intent.getStringExtra("songid");
        loadData();

        //seekbar设置拖拽监听
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            /**
             * 进度发生变化
             * @param seekBar
             * @param progress
             * @param fromUser:是否是用户手指拖动改变的进度
             */
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    mediaPlayer.seekTo(progress);
                }
            }

            /**
             * 拖拽中：手指没有离开屏幕
             * @param seekBar
             */
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            /**
             * 拖拽结束：手指已经离开屏幕
             * @param seekBar
             */
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        updateSeekbarProgressReceiver = new UpdateSeekbarProgressReceiver();
        //注册更新seekbar进度的广播接收器
        registerReceiver(updateSeekbarProgressReceiver, new IntentFilter(UPDATESEEKBARPROGRESS));

        bitmapPause = BitmapFactory.decodeResource(getResources(), android.R.drawable.ic_media_pause);
        bitmapPlay = BitmapFactory.decodeResource(getResources(), android.R.drawable.ic_media_play);
        playerControl.setOnClickListener(this);
        previousControl.setOnClickListener(this);
        nextControl.setOnClickListener(this);

    }

    private void loadData() {
        OkHttpUtils
                .get()
                .url(UriInterface.getDetailUrl(songid))
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        detailEntity = JSON.parseObject(response, DetailEntity.class);
                        songLink = detailEntity.getData().getSongList().get(0).getSongLink();
                        songPicRadio = detailEntity.getData().getSongList().get(0).getSongPicRadio();
                        MyApp.getApp().getBitmapUtils().display(imageView, songPicRadio);

                        //初始化MediaPlayer
                        mediaPlayer = new MediaPlayer();
                        try {
                            mediaPlayer.setDataSource(MusicActivity.this, Uri.parse(songLink));
                            //异步准备数据
                            mediaPlayer.prepareAsync();
                            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                                @Override
                                public void onPrepared(MediaPlayer mp) {
                                    //初始化seekbar
                                    seekBar.setMax(mp.getDuration());
                                    //设置当前值
                                    seekBar.setProgress(0);
                                    mp.start();
                                    playerControl.setImageBitmap(bitmapPause);
                                    //开启更新seekbar进度
                                    flag = true;
                                    new UpdateSeekbarProgressThread().start();
                                }
                            });
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }


    //释放资源
    @Override
    protected void onDestroy() {
        //停止掉当前更新seekbar的线程
        flag = false;
        unregisterReceiver(updateSeekbarProgressReceiver);
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
            }
            mediaPlayer.release();
            mediaPlayer = null;
        }
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.musicactivity_previousId://上一曲

                break;
            case R.id.musicactivity_nextId://下一曲

                break;
            case R.id.musicactivity_playerControlId://播放控制
                if (mediaPlayer.isPlaying()) {
                    playerControl.setImageBitmap(bitmapPlay);
                    mediaPlayer.pause();
                } else {
                    playerControl.setImageBitmap(bitmapPause);
                    mediaPlayer.start();
                }
                break;
        }
    }

    /**
     * 定义更新seekbar进度的广播接收器
     */
    class UpdateSeekbarProgressReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(UPDATESEEKBARPROGRESS)) {
                //更新seekbar进度
                seekBar.setProgress(mediaPlayer.getCurrentPosition());
                //更新时间
                updateTime();
            }
        }

        private void updateTime() {
            timeText.setText(getNeedFormatTime(mediaPlayer.getCurrentPosition()) + "/" + getNeedFormatTime(mediaPlayer.getDuration()));
        }

        private String getNeedFormatTime(int time) {
            //time是一个毫秒级的数据
            String timeFormat = "%02d:%02d";
            int totalSecond = time / 1000;
            int minute = totalSecond / 60;
            int second = totalSecond % 60;
            return String.format(timeFormat, minute, second);
        }
    }

    /**
     * 更新seekbar进度的线程
     */
    private boolean flag;

    class UpdateSeekbarProgressThread extends Thread {
        @Override
        public void run() {
            while (flag) {
                try {
                    Thread.sleep(1000);
                    sendBroadcast(new Intent(UPDATESEEKBARPROGRESS));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
