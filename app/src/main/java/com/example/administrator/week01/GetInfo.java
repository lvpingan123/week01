package com.example.administrator.week01;

import com.example.administrator.week01.clazz.Bean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface GetInfo {
    @GET
    Observable<Bean> getData(@Url String path);
}
