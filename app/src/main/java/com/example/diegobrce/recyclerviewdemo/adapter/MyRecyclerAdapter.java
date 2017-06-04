package com.example.diegobrce.recyclerviewdemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.diegobrce.recyclerviewdemo.R;
import com.example.diegobrce.recyclerviewdemo.bean.ListItem;

import java.util.List;

/**
 * 继承RecyclerView的Adapter，并重写其中的方法以适配到自己的itemView
 * <p>
 * Created by 区枫华 on 2017/6/4.
 */

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyViewHolder> {

    /**
     * 装有列表中，各条item的信息的List
     */
    private List<ListItem> list;

    /**
     * 构造函数
     *
     * @param list
     */
    public MyRecyclerAdapter(List<ListItem> list) {
        this.list = list;
    }

    /**
     * 创建一个新的ViewHolder并给它绑定资源
     * 相当于ListView的判断是否存在复用View，若不存在再去用LayoutInflater新建一个
     *
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //从父View那里获取到上下文对象，并以此上下文对象去实现一个item的View
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);

        //将实现好的View传入ViewHolder中，set好
        return new MyViewHolder(view);
    }

    /**
     * 给对应的ViewHolder设置当前位置相应的item信息
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        //获取当前位置的列表信息
        ListItem temp = list.get(position);
        //用对应的信息设置当前条项View的控件
        holder.tv.setText(list.get(position).getText());
    }

    /**
     * 获取列表中的
     * 返回list的大小
     *
     * @return
     */
    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addItem() {
        list.add(new ListItem("我是第"+getItemCount()+"条"));
        notifyDataSetChanged();
    }

    public void removeLastItem() {
        if (list.size() > 0) {
            list.remove(list.size() - 1);
            notifyDataSetChanged();
        } else
            return;
    }

}