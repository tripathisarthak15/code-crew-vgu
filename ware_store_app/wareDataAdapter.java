package com.amanpal.warestore;

import android.content.Context;
//import android.support.annotation.NonNull;
//import android.support.v7.widget.RecyclerView;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class wareDataAdapter extends RecyclerView.Adapter<wareDataAdapter.ViewHolder> {

    WareData[] myWareData;
    Context context;

    public wareDataAdapter(WareData[] myWareData,MainActivity activity){
        this.myWareData = myWareData;
        this.context = activity;
    }


    @androidx.annotation.NonNull
    @Override
    public wareDataAdapter.ViewHolder onCreateViewHolder(@androidx.annotation.NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.ware_list,viewGroup,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@androidx.annotation.NonNull wareDataAdapter.ViewHolder viewHolder, int i) {
        final WareData myWareDataList = myWareData[i];
        viewHolder.wareName.setText(myWareDataList.getWare_name());
        viewHolder.warePrice.setText(myWareDataList.getWare_Price());
        viewHolder.wareRating.setText(myWareDataList.getWare_rating());
        viewHolder.wareImage.setImageResource(myWareDataList.getWare_image());

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(this,chatActivity.class)
                Toast.makeText(context,myWareDataList.getWare_name(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return myWareData.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView wareImage;
        TextView wareName;
        TextView warePrice;
        TextView wareRating;

        public ViewHolder(View itemView){
            super(itemView);
            wareImage = itemView.findViewById(R.id.ivWareImage);
            wareName = itemView.findViewById(R.id.tvWareName);
            warePrice = itemView.findViewById(R.id.tvWarePrice);
            wareRating = itemView.findViewById(R.id.tvWareRating);
        }
    }
}
