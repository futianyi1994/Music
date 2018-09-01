package com.fty.recycleviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 天一 on 2016/10/26.
 */
public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder> {
    private List<String> datas;
    private LayoutInflater inflater;
    private OnclickListener listener;
    private OnLongClickListener longClickListener;

    public void setLongClickListener(OnLongClickListener longClickListener) {
        this.longClickListener = longClickListener;
    }

    public void setListener(OnclickListener listener) {
        this.listener = listener;
    }

    public RecycleAdapter(Context context) {
        datas = new ArrayList<>();
        inflater = LayoutInflater.from(context);
    }

    public LayoutInflater getInflater() {
        return inflater;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(inflater.inflate(R.layout.item,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(datas.get(position));
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }




    class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.item_textViewId);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(v,getLayoutPosition());
                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    longClickListener.longOnClick(v,getLayoutPosition());
                    return false;
                }
            });
        }
    }

    public void addDatas(int position, String s) {
        datas.add(position,s);
        notifyItemInserted(position);
    }

    public void removeDatas(int position) {
        datas.remove(position);
        notifyItemRemoved(position);
    }

    interface OnclickListener{
        void onClick(View view,int position);
    }
    interface OnLongClickListener{
        void longOnClick(View view,int position);
    }

    public void addAll(List<String> dd){
        datas.addAll(dd);
        notifyDataSetChanged();
    }
}
