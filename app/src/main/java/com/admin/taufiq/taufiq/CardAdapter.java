package com.admin.taufiq.taufiq;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardViewHolder> {


    private ArrayList<presiden> listPresiden;
    private Context context;
    public CardAdapter(Context context) {
        this.context = context;
    }

    private ArrayList<presiden> getListPresiden(){
        return listPresiden;
    }

    void setListPresiden(ArrayList<presiden> listPresiden){
        this.listPresiden = listPresiden;
    }


    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item,parent,false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        presiden p = getListPresiden().get(position);

        Glide.with(context).load(p.getPhoto())
                .override(350,550)
                .into(holder.imgPhoto);

        holder.tvName.setText(p.getNama());
        holder.tvRemarks.setText(p.getRemarks());

        holder.btnFav.setOnClickListener(new CustomOnItemClickListener(position, new CustomOnItemClickListener.onItemCallBack() {
            @Override
            public void onItemCliked(View view, int position) {
                Toast .makeText(context, "Favorite "+ getListPresiden().get(position).getNama(),Toast.LENGTH_LONG).show();
            }
        }));

        holder.btnShare.setOnClickListener(new CustomOnItemClickListener(position, new CustomOnItemClickListener.onItemCallBack() {
            @Override
            public void onItemCliked(View view, int position) {
                Toast .makeText(context, "Share "+ getListPresiden().get(position).getNama(),Toast.LENGTH_LONG).show();
            }
        }));


    }

    @Override
    public int getItemCount() {
        return getListPresiden().size();
    }

    class CardViewHolder extends RecyclerView.ViewHolder{
        ImageView imgPhoto;
        TextView tvName, tvRemarks;
        Button btnFav,btnShare;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.imageCard);
            tvName = itemView.findViewById(R.id.nameCard);
            tvRemarks = itemView.findViewById(R.id.remarksCard);
            btnFav = itemView.findViewById(R.id.btn_fav);
            btnShare = itemView.findViewById(R.id.btn_share);
        }
    }
}
