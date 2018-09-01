package org.mobiletrain.music.bean;

import java.util.List;

/**
 * Created by 天一 on 2016/10/19.
 */
public class MusicEntity {

    /**
     * error_code : 22000
     * result : {"channel":"漫步春天","channelid":null,"ch_name":"public_tuijian_spring","artistid":null,"avatar":null,"count":null,"songlist":[{"songid":"2497981","title":"早上好","artist":"牛奶咖啡","thumb":"http://qukufile2.qianqian.com/data2/pic/88768516/88768516.jpg","method":0,"flow":0,"artist_id":"981","all_artist_id":"981","resource_type":"0","havehigh":2,"charge":0,"all_rate":"24,64,128,192,256,320"},{"songid":"9680594","title":"Ice Age","artist":"Pete Yorn","thumb":"http://qukufile2.qianqian.com/data2/pic/117568094/117568094.jpg","method":0,"flow":0,"artist_id":"43452","all_artist_id":"43452","resource_type":"0","havehigh":2,"charge":0,"all_rate":"24,64,128,192,256,320"},{"songid":"8785643","title":"Sunny Came Home","artist":"Shawn Colvin","thumb":"http://qukufile2.qianqian.com/data2/pic/117833845/117833845.jpg","method":0,"flow":0,"artist_id":"45363","all_artist_id":"45363","resource_type":"0","havehigh":2,"charge":0,"all_rate":"24,64,128,192,256,320,flac"},{"songid":"1471944","title":"Love Story","artist":"Taylor Swift","thumb":"http://qukufile2.qianqian.com/data2/pic/115457976/115457976.jpg","method":0,"flow":0,"artist_id":"816","all_artist_id":"816","resource_type":"0","havehigh":2,"charge":0,"all_rate":"24,64,128,192,256,320,flac"},{"songid":"1174149","title":"Knock Knock","artist":"Lenka","thumb":"http://qukufile2.qianqian.com/data2/pic/2fda89276c1c3bf6d3b612068a24bc46/115457877/115457877.jpg","method":0,"flow":0,"artist_id":"1800","all_artist_id":"1800","resource_type":"0","havehigh":2,"charge":0,"all_rate":"24,64,128,192,256,320,flac"},{"songid":"5722450","title":"Everything","artist":"梁心颐","thumb":"http://qukufile2.qianqian.com/data2/pic/27ee7dc957c5491d03db8afea44c09d9/262015407/262015407.jpg","method":0,"flow":0,"artist_id":"4722","all_artist_id":"4722","resource_type":"0","havehigh":0,"charge":0,"all_rate":"128"},{"songid":"1282192","title":"Our Song","artist":"Taylor Swift","thumb":"http://qukufile2.qianqian.com/data2/pic/115363416/115363416.jpg","method":0,"flow":0,"artist_id":"816","all_artist_id":"816","resource_type":"0","havehigh":2,"charge":0,"all_rate":"24,64,128,192,256,320"},{"songid":"7184772","title":"I Do","artist":"Colbie Caillat","thumb":"http://qukufile2.qianqian.com/data2/pic/115993712/115993712.jpg","method":0,"flow":0,"artist_id":"749","all_artist_id":"749","resource_type":"0","havehigh":2,"charge":0,"all_rate":"31,32,64,128,192,256,320,flac"},{"songid":"7652439","title":"Stay Here Forever","artist":"Jewel","thumb":"http://qukufile2.qianqian.com/data2/pic/115427967/115427967.jpg","method":0,"flow":0,"artist_id":"697","all_artist_id":"697","resource_type":"0","havehigh":2,"charge":0,"all_rate":"24,64,128,192,256,320,flac"},{"songid":"7170129","title":"Everything At Once","artist":"Lenka","thumb":"http://qukufile2.qianqian.com/data2/pic/0d6b7b8e328115a74a31f1dc18832c6b/89824709/89824709.jpg","method":0,"flow":0,"artist_id":"1800","all_artist_id":"1800","resource_type":"0","havehigh":2,"charge":0,"all_rate":"24,64,128,192,256,320,flac"},{"songid":null,"title":null,"artist":null,"thumb":"","method":0,"flow":0,"artist_id":null,"all_artist_id":null,"resource_type":null,"havehigh":0,"charge":0,"all_rate":""}]}
     */

    private int error_code;
    /**
     * channel : 漫步春天
     * channelid : null
     * ch_name : public_tuijian_spring
     * artistid : null
     * avatar : null
     * count : null
     * songlist : [{"songid":"2497981","title":"早上好","artist":"牛奶咖啡","thumb":"http://qukufile2.qianqian.com/data2/pic/88768516/88768516.jpg","method":0,"flow":0,"artist_id":"981","all_artist_id":"981","resource_type":"0","havehigh":2,"charge":0,"all_rate":"24,64,128,192,256,320"},{"songid":"9680594","title":"Ice Age","artist":"Pete Yorn","thumb":"http://qukufile2.qianqian.com/data2/pic/117568094/117568094.jpg","method":0,"flow":0,"artist_id":"43452","all_artist_id":"43452","resource_type":"0","havehigh":2,"charge":0,"all_rate":"24,64,128,192,256,320"},{"songid":"8785643","title":"Sunny Came Home","artist":"Shawn Colvin","thumb":"http://qukufile2.qianqian.com/data2/pic/117833845/117833845.jpg","method":0,"flow":0,"artist_id":"45363","all_artist_id":"45363","resource_type":"0","havehigh":2,"charge":0,"all_rate":"24,64,128,192,256,320,flac"},{"songid":"1471944","title":"Love Story","artist":"Taylor Swift","thumb":"http://qukufile2.qianqian.com/data2/pic/115457976/115457976.jpg","method":0,"flow":0,"artist_id":"816","all_artist_id":"816","resource_type":"0","havehigh":2,"charge":0,"all_rate":"24,64,128,192,256,320,flac"},{"songid":"1174149","title":"Knock Knock","artist":"Lenka","thumb":"http://qukufile2.qianqian.com/data2/pic/2fda89276c1c3bf6d3b612068a24bc46/115457877/115457877.jpg","method":0,"flow":0,"artist_id":"1800","all_artist_id":"1800","resource_type":"0","havehigh":2,"charge":0,"all_rate":"24,64,128,192,256,320,flac"},{"songid":"5722450","title":"Everything","artist":"梁心颐","thumb":"http://qukufile2.qianqian.com/data2/pic/27ee7dc957c5491d03db8afea44c09d9/262015407/262015407.jpg","method":0,"flow":0,"artist_id":"4722","all_artist_id":"4722","resource_type":"0","havehigh":0,"charge":0,"all_rate":"128"},{"songid":"1282192","title":"Our Song","artist":"Taylor Swift","thumb":"http://qukufile2.qianqian.com/data2/pic/115363416/115363416.jpg","method":0,"flow":0,"artist_id":"816","all_artist_id":"816","resource_type":"0","havehigh":2,"charge":0,"all_rate":"24,64,128,192,256,320"},{"songid":"7184772","title":"I Do","artist":"Colbie Caillat","thumb":"http://qukufile2.qianqian.com/data2/pic/115993712/115993712.jpg","method":0,"flow":0,"artist_id":"749","all_artist_id":"749","resource_type":"0","havehigh":2,"charge":0,"all_rate":"31,32,64,128,192,256,320,flac"},{"songid":"7652439","title":"Stay Here Forever","artist":"Jewel","thumb":"http://qukufile2.qianqian.com/data2/pic/115427967/115427967.jpg","method":0,"flow":0,"artist_id":"697","all_artist_id":"697","resource_type":"0","havehigh":2,"charge":0,"all_rate":"24,64,128,192,256,320,flac"},{"songid":"7170129","title":"Everything At Once","artist":"Lenka","thumb":"http://qukufile2.qianqian.com/data2/pic/0d6b7b8e328115a74a31f1dc18832c6b/89824709/89824709.jpg","method":0,"flow":0,"artist_id":"1800","all_artist_id":"1800","resource_type":"0","havehigh":2,"charge":0,"all_rate":"24,64,128,192,256,320,flac"},{"songid":null,"title":null,"artist":null,"thumb":"","method":0,"flow":0,"artist_id":null,"all_artist_id":null,"resource_type":null,"havehigh":0,"charge":0,"all_rate":""}]
     */

    private ResultBean result;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        private String channel;
        private Object channelid;
        private String ch_name;
        private Object artistid;
        private Object avatar;
        private Object count;
        /**
         * songid : 2497981
         * title : 早上好
         * artist : 牛奶咖啡
         * thumb : http://qukufile2.qianqian.com/data2/pic/88768516/88768516.jpg
         * method : 0
         * flow : 0
         * artist_id : 981
         * all_artist_id : 981
         * resource_type : 0
         * havehigh : 2
         * charge : 0
         * all_rate : 24,64,128,192,256,320
         */

        private List<SonglistBean> songlist;

        public String getChannel() {
            return channel;
        }

        public void setChannel(String channel) {
            this.channel = channel;
        }

        public Object getChannelid() {
            return channelid;
        }

        public void setChannelid(Object channelid) {
            this.channelid = channelid;
        }

        public String getCh_name() {
            return ch_name;
        }

        public void setCh_name(String ch_name) {
            this.ch_name = ch_name;
        }

        public Object getArtistid() {
            return artistid;
        }

        public void setArtistid(Object artistid) {
            this.artistid = artistid;
        }

        public Object getAvatar() {
            return avatar;
        }

        public void setAvatar(Object avatar) {
            this.avatar = avatar;
        }

        public Object getCount() {
            return count;
        }

        public void setCount(Object count) {
            this.count = count;
        }

        public List<SonglistBean> getSonglist() {
            return songlist;
        }

        public void setSonglist(List<SonglistBean> songlist) {
            this.songlist = songlist;
        }

        public static class SonglistBean {
            private String songid;
            private String title;
            private String artist;
            private String thumb;
            private int method;
            private int flow;
            private String artist_id;
            private String all_artist_id;
            private String resource_type;
            private int havehigh;
            private int charge;
            private String all_rate;

            public String getSongid() {
                return songid;
            }

            public void setSongid(String songid) {
                this.songid = songid;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getArtist() {
                return artist;
            }

            public void setArtist(String artist) {
                this.artist = artist;
            }

            public String getThumb() {
                return thumb;
            }

            public void setThumb(String thumb) {
                this.thumb = thumb;
            }

            public int getMethod() {
                return method;
            }

            public void setMethod(int method) {
                this.method = method;
            }

            public int getFlow() {
                return flow;
            }

            public void setFlow(int flow) {
                this.flow = flow;
            }

            public String getArtist_id() {
                return artist_id;
            }

            public void setArtist_id(String artist_id) {
                this.artist_id = artist_id;
            }

            public String getAll_artist_id() {
                return all_artist_id;
            }

            public void setAll_artist_id(String all_artist_id) {
                this.all_artist_id = all_artist_id;
            }

            public String getResource_type() {
                return resource_type;
            }

            public void setResource_type(String resource_type) {
                this.resource_type = resource_type;
            }

            public int getHavehigh() {
                return havehigh;
            }

            public void setHavehigh(int havehigh) {
                this.havehigh = havehigh;
            }

            public int getCharge() {
                return charge;
            }

            public void setCharge(int charge) {
                this.charge = charge;
            }

            public String getAll_rate() {
                return all_rate;
            }

            public void setAll_rate(String all_rate) {
                this.all_rate = all_rate;
            }
        }
    }
}
