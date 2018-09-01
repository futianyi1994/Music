package org.mobiletrain.music;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.lidroid.xutils.BitmapUtils;
import com.zhy.http.okhttp.OkHttpUtils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by 天一 on 2016/10/19.
 */
public class MyApp extends Application {
    private static MyApp app;
    private BitmapUtils bitmapUtils;
    private RequestQueue requestQueue;

    @Override
    public void onCreate() {
        super.onCreate();
        this.app = this;

        initXUtils();
        initVolley();
        initOkHttpUtils();
    }

    private void initOkHttpUtils() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .addInterceptor(new LoggerInterceptor("TAG"))
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                //其他配置
                .build();

        OkHttpUtils.initClient(okHttpClient);
    }

    private void initVolley() {
        requestQueue = Volley.newRequestQueue(this);
    }


    private void initXUtils() {
        bitmapUtils = new BitmapUtils(this);
    }

    public RequestQueue getRequestQueue() {
        return requestQueue;
    }

    public BitmapUtils getBitmapUtils() {
        return bitmapUtils;
    }

    public static MyApp getApp() {
        return app;
    }
}
