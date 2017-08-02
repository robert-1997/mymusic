package com.example.huangdouya.mymusicapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by huangdouya on 2017/8/2.
 */

public abstract class MyBaseAdapter<T> extends BaseAdapter {
    protected Context context;
    protected List<T>data;
    protected LayoutInflater inflater;

    MyBaseAdapter(Context context,List<T>data){
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return initView(position,convertView,parent);
    }

    protected abstract View initView(int position, View convertView, ViewGroup parent);

    protected void setItems(List<T>data){
        this.data.clear();
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    protected void addItems(List<T> data){
        this.data.addAll(data);
        notifyDataSetChanged();
    }
}
