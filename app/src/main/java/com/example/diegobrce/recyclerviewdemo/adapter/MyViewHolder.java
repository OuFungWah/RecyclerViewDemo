package com.example.diegobrce.recyclerviewdemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.diegobrce.recyclerviewdemo.R;

/**
 * 复用View类
 * Created by 区枫华 on 2017/6/4.
 */

public class MyViewHolder extends RecyclerView.ViewHolder {

    public TextView tv;

    public MyViewHolder(View itemView) {
        super(itemView);
        tv = (TextView) itemView.findViewById(R.id.item_text);
    }

}
