package com.example.a41716.demo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by 41716 on 2017/2/28.
 */

public class SimperAdater extends RecyclerView.Adapter<MyViewHolder> {
    private Context mcontext;
    private List<String> mstringList;
    private LayoutInflater inflater;
    public SimperAdater(Context context,List<String> stringList) {
        this.mstringList = stringList;
        mcontext = context;
        inflater = LayoutInflater.from(context);
    }
    interface OnItemClickListener{
        void onClick(View view,int position);
        void onLongClick(View view,int position);
    }
    private OnItemClickListener monItemClickListener;
    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.monItemClickListener = onItemClickListener;
    }
    //创建ViewHolder
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.recycleview_item,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }
    //绑定ViewHolder
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.tv.setText(mstringList.get(position));
        if(monItemClickListener != null){
            holder.tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    monItemClickListener.onClick(holder.ItemView,position);
                }
            });
            holder.tv.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    monItemClickListener.onLongClick(holder.ItemView,position);
                    return false;
                }
            });
        }
    }
    //获取item数量
    @Override
    public int getItemCount() {
        return mstringList.size();
    }
}
class MyViewHolder extends RecyclerView.ViewHolder {
    TextView tv;
    View ItemView;
    public MyViewHolder(View view) {
        super(view);
        this.ItemView = view;
        tv = (TextView)view.findViewById(R.id.item_textview);
    }
}