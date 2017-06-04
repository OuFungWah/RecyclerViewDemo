package com.example.diegobrce.recyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.example.diegobrce.recyclerviewdemo.adapter.MyRecyclerAdapter;
import com.example.diegobrce.recyclerviewdemo.bean.ListItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    /**
     * 复用视图
     */
    private RecyclerView recyclerView;
    /**
     * 横向线性布局管理器
     */
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

    private List<ListItem> list = new ArrayList<>();

    private MyRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler);

        //构造函数（资源，线性方向，是否颠倒顺序）
        horizontalManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        verticalManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        //构造函数（资源，一行多少列（vertical）/一列有多少行（Horizontal），布局的方向，是否颠倒顺序）
        horizontalGridManager = new GridLayoutManager(this, 6, LinearLayoutManager.HORIZONTAL, false);
        vertivalGridManager = new GridLayoutManager(this, 2, LinearLayoutManager.VERTICAL, false);

        //插入数据到List中
        for (int i = 0; i < 20; i++) {
            list.add(new ListItem("我是第" + i + "条"));
        }

        //新建设配器
        adapter = new MyRecyclerAdapter(list);

        //设置数据和视图的适配器
        recyclerView.setAdapter(adapter);

        //默认为纵向布局
        recyclerView.setLayoutManager(verticalManager);


    }

    /**
     * 创建菜单
     *
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    /**
     * 监听菜单选项的选择
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.vertical_LinearManager_item:
                recyclerView.setLayoutManager(verticalManager);
                return true;
            case R.id.horizontal_LinearManager_item:
                recyclerView.setLayoutManager(horizontalManager);
                return true;
            case R.id.vertical_GridManager_item:
                recyclerView.setLayoutManager(vertivalGridManager);
                return true;
            case R.id.horizontal_GridManager_item:
                recyclerView.setLayoutManager(horizontalGridManager);
                return true;
            case R.id.add:
                adapter.addItem();
                recyclerView.scrollToPosition(list.size() - 1);
                return true;
            case R.id.remove:
                adapter.removeLastItem();
                recyclerView.scrollToPosition(list.size() - 1);
                return true;
            default:
                return false;
        }
    }
}
