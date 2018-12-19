package com.conways.pagerrecycleview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {


    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_my, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder, int i) {
        myHolder.tvPositon.setText(i + " positon");
        myHolder.itemView.setBackgroundColor(currentColor);
    }

    @Override
    public int getItemCount() {
        return size;
    }

    public void refresh() {
        if (size == 2) {
            size = 3;
            currentColor = 0xff00ffaa;
        } else {
            size = 2;
            currentColor = 0xffffaa00;
        }
        this.notifyDataSetChanged();
    }

    private int size = 2;
    private int currentColor = 0xff00ffaa;

    class MyHolder extends RecyclerView.ViewHolder {
        TextView tvPositon;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            tvPositon = itemView.findViewById(R.id.text);
        }
    }
}
