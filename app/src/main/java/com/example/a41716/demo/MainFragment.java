package com.example.a41716.demo;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 41716 on 2017/2/28.
 */

public class MainFragment extends Fragment {
    private List<String> stringList;
    private RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_layout,container,false);

        //获取recyclerview实例
        recyclerView = (RecyclerView)view.findViewById(R.id.main_recyclerview);
        initDatas();
        //为recyclerview设置适配器
        SimperAdater simperAdater = new SimperAdater(view.getContext(),stringList);
        simperAdater.setOnItemClickListener(new SimperAdater.OnItemClickListener() {
            //设置recyclerview选项的点击事件
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(view.getContext(),"这是新闻"+position,Toast.LENGTH_LONG).show();
            }
            //设置recyclerview选项的长按事件
            @Override
            public void onLongClick(View view, int position) {
                Toast.makeText(view.getContext(),"这是新闻"+position+"长按",Toast.LENGTH_LONG).show();
            }
        });
        recyclerView.setAdapter(simperAdater);
        LinearLayoutManager linearLayoutmanager = new LinearLayoutManager(view.getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutmanager);
        //设置分割线
        recyclerView.addItemDecoration(new DividerItemDecoration(view.getContext(), DividerItemDecoration.VERTICAL));


        return view;
    }
    private void initDatas() {
        stringList = new ArrayList<String>();
        for (int i = 0;i <= 20;i++){
            stringList.add("新闻"+i);
        }
    }
}
