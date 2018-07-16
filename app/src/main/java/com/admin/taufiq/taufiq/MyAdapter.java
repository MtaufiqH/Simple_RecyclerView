package com.admin.taufiq.taufiq;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.CategoryViewHolder>{

    private Context context;

    ArrayList<presiden> getListPresiden(){
        return listPresiden;
    }

    void setListPresiden (ArrayList<presiden> listPresiden){
        this.listPresiden = listPresiden;
    }

    private ArrayList<presiden> listPresiden;

    MyAdapter (Context context){
        this.context = context;
    }

    @NonNull
    @Override
    public MyAdapter.CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        holder.tvName.setText(getListPresiden().get(position).getNama());
        holder.tvRemarks.setText(getListPresiden().get(position).getRemarks());

        Glide.with(context)
                .load(getListPresiden().get(position).getPhoto()).override(55,55).crossFade()
                .into(holder.imgFoto);
    }

    @Override
    public int getItemCount() {
        return getListPresiden().size();
    }


    class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView  tvName;
        TextView tvRemarks;
        ImageView imgFoto;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.preNames);
            tvRemarks = itemView.findViewById(R.id.preRemarks);
            imgFoto = itemView.findViewById(R.id.cImages);

        }
    }
}
