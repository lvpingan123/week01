package com.example.administrator.week01.model;

import com.example.administrator.week01.GetInfo;
import com.example.administrator.week01.clazz.Bean;
import com.example.administrator.week01.clazz.Data;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Model {
    ModelGetInfo modelGetInfo;
    List<Data> list=new ArrayList<>();
    public Model(ModelGetInfo info) {
        this.modelGetInfo = info;
    }
    public void getData(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://www.qubaobei.com/ios/cf/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final GetInfo info=retrofit.create(GetInfo.class);
        Observable<Bean> observable=info.getData("http://www.qubaobei.com/ios/cf/dish_list.php?stage_id=1&limit=20&page=1");
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Bean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Bean bean) {
                        List<Bean.DataBean> beans=bean.getData();
                        for(int i=0;i<beans.size();i++){
                            Data data=new Data();
                            data.imgPath=beans.get(i).getPic();
                            data.title=beans.get(i).getTitle();
                            list.add(data);
                        }
                        modelGetInfo.successInfo(list);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
