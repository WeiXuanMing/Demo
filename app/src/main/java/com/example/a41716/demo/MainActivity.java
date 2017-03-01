package com.example.a41716.demo;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements RadioGroup.OnCheckedChangeListener {
    private RadioGroup radioGroup;
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private Fragment mainFragment;
    private Fragment videoFragment;
    private RecyclerView recyclerView;
    private List<String> stringList;

    //修改注释
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        //获取radiogroup实例，并绑定监听器
        radioGroup = (RadioGroup) findViewById(R.id.radiogroup);
        radioGroup.setOnCheckedChangeListener(this);
        //获取碎片管理器，用于切换页卡
        fragmentManager = getFragmentManager();


    }



    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        transaction = fragmentManager.beginTransaction();
        //切换页面
        switch (checkedId){
            case R.id.radioButton:
                if(mainFragment == null) {
                    mainFragment = new MainFragment();
                }
                transaction.replace(R.id.main_frame_layout,mainFragment);
                transaction.commit();
                break;
            case R.id.radioButton2:
                if(videoFragment == null){
                    videoFragment = new VideoFragment();
                }
                transaction.replace(R.id.main_frame_layout,videoFragment);
                transaction.commit();
                break;
            case R.id.radioButton3:
                break;
            case R.id.radioButton4:
                break;
        }
    }
}
