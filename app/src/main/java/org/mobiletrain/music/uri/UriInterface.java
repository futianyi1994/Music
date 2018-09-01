package org.mobiletrain.music.uri;

/**
 * Created by 天一 on 2016/10/19.
 */
public class UriInterface {

    public static final String PUBLIC_URL = "http://tingapi.ting.baidu.com/v1/restserver/ting?from=qianqian&version=2.1.0&method=baidu.ting.radio.getCategoryList&format=json";

    public static final String MUSIC_URL = "http://tingapi.ting.baidu.com/v1/restserver/ting?from=qianqian&version=2.1.0&method=baidu.ting.radio.getChannelSong&format=json&pn=0&rn=10&channelname=%s";
    public static String getMusicUrl(String s){

        return String.format(MUSIC_URL,s);

    }

    public static final String DETAIL_URL = "http://music.baidu.com/data/music/links?songIds=%s";
    public static String getDetailUrl(String s){

        return String.format(DETAIL_URL,s);

    }
}
