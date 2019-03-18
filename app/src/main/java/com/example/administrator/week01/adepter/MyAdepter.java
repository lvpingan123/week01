package com.example.administrator.week01.adepter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.week01.R;
import com.example.administrator.week01.clazz.Data;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.glide.transformations.CropCircleTransformation;

public class MyAdepter extends RecyclerView.Adapter<MyAdepter.MyHolder>{
    List<Data> list=new ArrayList<>();
    Context context;

    public MyAdepter(Context context) {
        this.context = context;
    }
    public void refresh(List<Data> list){
        this.list=list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater=LayoutInflater.from(viewGroup.getContext());
        return new MyHolder(inflater.inflate(R.layout.item_layout,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder, int i) {
        Glide.with(context).load(list.get(i).imgPath)
                .bitmapTransform(new CropCircleTransformation(context))
                .into(myHolder.imageView);
        myHolder.textView.setText(list.get(i).title);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{
   ImageView imageView;
   TextView textView;
    public MyHolder(@NonNull View itemView) {
        super(itemView);
        imageView=itemView.findViewById(R.id.item_img);
        textView=itemView.findViewById(R.id.item_title);
    }
}
}
