package com.example.administrator.week01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.administrator.week01.adepter.MyAdepter;
import com.example.administrator.week01.clazz.Data;
import com.example.administrator.week01.p.Present;
import com.example.administrator.week01.view.MyView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MyView {

    @BindView(R.id.main_Rv)
    RecyclerView mainRv;
    Present present;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        present=new Present(this);
        present.handData();
    }

    @Override
    public void getData(List<Data> data) {
        LinearLayoutManager manager=new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mainRv.setLayoutManager(manager);
        MyAdepter adepter=new MyAdepter(this);
        adepter.refresh(data);
        mainRv.setAdapter(adepter);
    }
}
