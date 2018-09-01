package org.mobiletrain.music.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import org.mobiletrain.music.MyApp;
import org.mobiletrain.music.R;
import org.mobiletrain.music.bean.MusicEntity;

/**
 * Created by 天一 on 2016/10/19.
 */
public class MusicListAdapter extends MBaseAdapter <MusicEntity.ResultBean.SonglistBean>{
    public MusicListAdapter(Context context) {
        super(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = getInflater().inflate(R.layout.item_music_listview, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        if (getItem(position).getTitle()!=null){
            viewHolder.titleTextView.setText(getItem(position).getTitle());
            viewHolder.artistTextView.setText(getItem(position).getArtist());
            MyApp.getApp().getBitmapUtils().display(viewHolder.imageView,getItem(position).getThumb());
        }
        return convertView;
    }
    class ViewHolder{
        @ViewInject(R.id.item_music_listview_imageViewId)
        ImageView imageView;
        @ViewInject(R.id.item_music_listview_title_textViewId)
        TextView titleTextView;
        @ViewInject(R.id.item_music_listview__artist_textViewId)
        TextView artistTextView;
        public ViewHolder(View convertView){
            ViewUtils.inject(this,convertView);
        }
    }
}
