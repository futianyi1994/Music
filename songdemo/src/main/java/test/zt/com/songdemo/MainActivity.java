package test.zt.com.songdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, MediaPlayer.OnPreparedListener {

    private static final String UPDATESEEKBARPROGRESS = "updateSeekbarProgress";
    ImageView playerControl;
    ImageView previousControl;
    ImageView nextControl;
    MediaPlayer mediaPlayer;
    private String songUrl="http://yinyueshiting.baidu.com/data2/music/134368426/72801771476950461128.mp3?xcode=760fb85bd9cd6c8626bdb4a8ac0cec0f";
    Bitmap bitmapPause;
    Bitmap bitmapPlay;
    SeekBar seekBar;
    UpdateSeekbarProgressReceiver updateSeekbarProgressReceiver;
    TextView timeText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timeText = ((TextView) findViewById(R.id.activity_main_timeId));
        seekBar = ((SeekBar) findViewById(R.id.activity_main_seekBarId));
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
                if(fromUser)
                {
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
        registerReceiver(updateSeekbarProgressReceiver,new IntentFilter(UPDATESEEKBARPROGRESS));

        playerControl = ((ImageView) findViewById(R.id.activity_main_playerControlId));
        previousControl = ((ImageView) findViewById(R.id.activity_main_previousId));
        nextControl = ((ImageView) findViewById(R.id.activity_main_nextId));
        bitmapPause = BitmapFactory.decodeResource(getResources(),android.R.drawable.ic_media_pause);
        bitmapPlay = BitmapFactory.decodeResource(getResources(),android.R.drawable.ic_media_play);
        playerControl.setOnClickListener(this);
        previousControl.setOnClickListener(this);
        nextControl.setOnClickListener(this);
        //初始化MediaPlayer
        mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource(this, Uri.parse(songUrl));

            mediaPlayer.setOnPreparedListener(this);
            //异步准备数据
            mediaPlayer.prepareAsync();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.activity_main_previousId://上一曲

                break;
            case R.id.activity_main_nextId://下一曲

                break;
            case R.id.activity_main_playerControlId://播放控制
                if(mediaPlayer.isPlaying())
                {
                    playerControl.setImageBitmap(bitmapPlay);
                    mediaPlayer.pause();
                }
                else
                {
                    playerControl.setImageBitmap(bitmapPause);
                    mediaPlayer.start();
                }
                break;
        }
    }
    //释放资源
    @Override
    protected void onDestroy() {
        //停止掉当前更新seekbar的线程
        flag = false;
        unregisterReceiver(updateSeekbarProgressReceiver);
        if(mediaPlayer!=null)
        {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
            }
            mediaPlayer.release();
            mediaPlayer = null;
        }
        super.onDestroy();
    }

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

    /**
     * 定义更新seekbar进度的广播接收器
     *
     */
    class UpdateSeekbarProgressReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent.getAction().equals(UPDATESEEKBARPROGRESS))
            {
                //更新seekbar进度
                seekBar.setProgress(mediaPlayer.getCurrentPosition());
                //更新时间
                updateTime();
            }
        }

        private void updateTime() {
            timeText.setText(getNeedFormatTime(mediaPlayer.getCurrentPosition())+"/"+getNeedFormatTime(mediaPlayer.getDuration()));
        }

        private String getNeedFormatTime(int time) {
            //time是一个毫秒级的数据
            String timeFormat = "%02d:%02d";
            int totalSecond = time / 1000;
            int minute = totalSecond / 60;
            int second = totalSecond % 60;
            return String.format(timeFormat,minute,second);
        }
    }

    /**
     * 更新seekbar进度的线程
     *
     */
    private boolean flag;
    class UpdateSeekbarProgressThread extends Thread{
        @Override
        public void run() {
            while(flag)
            {
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
