package com.example.e_market;

import android.view.View;
import android.widget.AdapterView;

public class CustomOnItemClickListener implements View.OnClickListener {
    private int position;
    private OnItemClickCallBack onItemClickCallBack;

    CustomOnItemClickListener(int position, OnItemClickCallBack onItemClickCallBack){
        this.position = position;
        this.onItemClickCallBack = onItemClickCallBack;
    }

    public interface  OnItemClickCallBack{
        void onItemClicked(View view, int position);
    }

    @Override
    public void onClick(View v) {
        onItemClickCallBack.onItemClicked(v, position);
    }
}
