package com.admin.taufiq.taufiq;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.GridViewHolder> {
    private Context context;
    private ArrayList<presiden> gridList;

    private ArrayList<presiden> getGridList(){
        return gridList;
    }

    void setGridList(ArrayList<presiden> gridList) {
        this.gridList = gridList;
    }

    GridAdapter(Context context){
        this.context = context;
    }


    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item,parent,false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridAdapter.GridViewHolder holder, int position) {
        Glide.with(context).load(getGridList().get(position).getPhoto()).override(350,550)
                .into(holder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return getGridList().size();
    }

    class GridViewHolder extends RecyclerView.ViewHolder{
        ImageView imgPhoto;
        GridViewHolder(View itemView){
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.image_grid);
        }
    }
}
