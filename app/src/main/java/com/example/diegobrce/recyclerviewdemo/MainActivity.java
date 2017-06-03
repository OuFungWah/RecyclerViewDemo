package com.example.diegobrce.recyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;

public class MainActivity extends AppCompatActivity {

    /**复用视图*/
    private RecyclerView recyclerView;
    /**横向线性布局管理器*/
    private LinearLayoutManager horizontalManager;
    /**
     * 纵向线性布局管理器
     */
    private LinearLayoutManager verticalManager;
    /**
     * 横向网格网格布局管理器
     */
    private GridLayoutManager horizontalGridManager;
    /**
     * 纵向网格网格布局管理器
     */
    private GridLayoutManager vertivalGridManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler);

        //构造函数（资源，线性方向，是否颠倒顺序）
        horizontalManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        verticalManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        //构造函数（资源，一行多少列（vertical）/一列有多少行（Horizontal），布局的方向，是否颠倒顺序）
        horizontalGridManager = new GridLayoutManager(this,3,LinearLayoutManager.HORIZONTAL,false);
        vertivalGridManager = new GridLayoutManager(this,4,LinearLayoutManager.VERTICAL,false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }
}
