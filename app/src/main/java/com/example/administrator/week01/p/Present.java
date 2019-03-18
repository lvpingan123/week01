package com.example.administrator.week01.p;

import com.example.administrator.week01.clazz.Data;
import com.example.administrator.week01.model.Model;
import com.example.administrator.week01.model.ModelGetInfo;
import com.example.administrator.week01.view.MyView;

import java.util.List;

public class Present implements ModelGetInfo {
    MyView myView;

    public Present(MyView myView) {
        this.myView = myView;
    }

    Model model=new Model(this);
    public  void handData(){
        model.getData();
    }
    @Override
    public void successInfo(List<Data> data) {
        myView.getData(data);
    }
}
