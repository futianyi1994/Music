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
import org.mobiletrain.music.bean.PublicEntity;

/**
 * Created by 天一 on 2016/10/19.
 */
public class GridViewAdapter extends MBaseAdapter <PublicEntity.ResultBean.ChannellistBean>{

    public GridViewAdapter(Context context) {
        super(context);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = getInflater().inflate(R.layout.item_gridview, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        if (getItem(position).getAvatar()!=null){
            MyApp.getApp().getBitmapUtils().display(viewHolder.imageView,getItem(position).getAvatar());
        }else {
            MyApp.getApp().getBitmapUtils().display(viewHolder.imageView,getItem(position).getThumb());
        }
        viewHolder.textView.setText(getItem(position).getName());

        return convertView;
    }
    class ViewHolder{
        @ViewInject(R.id.item_gridview_imageViewId)
        ImageView imageView;
        @ViewInject(R.id.item_gridview_textViewId)
        TextView textView;
        public ViewHolder(View converView) {
            ViewUtils.inject(this,converView);
        }
    }
}
