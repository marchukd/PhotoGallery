package com.dmytromarchuk.photogallery;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import viewpager.ViewPagerActivity;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private Context mContext;

    public RecyclerViewAdapter(Context context) {
        mContext = context;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView url;
        ImageView image;
        CardView cardView;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.image = (ImageView) itemView.findViewById(R.id.image);
            this.name = (TextView) itemView.findViewById(R.id.name);
            this.url = (TextView) itemView.findViewById(R.id.url);
            this.cardView = (CardView) itemView.findViewById(R.id.card_view_item);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        PicturesData item = PicturesData.findById(PicturesData.class, listPosition + 1);

        Picasso.with(mContext).load(item.getUrl()).resize(320, 240).into(holder.image);
        holder.name.setText(item.getName());
        holder.url.setText(item.getUrl());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewPagerIntent = new Intent(mContext, ViewPagerActivity.class);
                viewPagerIntent.putExtra(Constants.POSITION, listPosition);
                mContext.startActivity(viewPagerIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return (int) PicturesData.count(PicturesData.class);
    }
}