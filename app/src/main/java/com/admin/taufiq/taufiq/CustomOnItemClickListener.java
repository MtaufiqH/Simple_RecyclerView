package com.admin.taufiq.taufiq;

import android.view.View;

public class CustomOnItemClickListener implements View.OnClickListener {

    private  int position;
    private onItemCallBack onItemClickCallback;

    public CustomOnItemClickListener(int position, onItemCallBack onItemClickCallback){
        this.position = position;
        this.onItemClickCallback = onItemClickCallback;
    }

    @Override
    public void onClick(View view) {
        onItemClickCallback.onItemCliked(view,position);
    }

    public interface onItemCallBack{
        void onItemCliked(View view, int position);
    }
}
