package com.jsstech.recyclerdemo;

import android.app.LauncherActivity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Response;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder>{

    private List<UserModel> listItems;
    private Context context;

    public UserAdapter(Context context,List<UserModel> listItems) {
        this.listItems = listItems;
        this.context = context;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent,int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false);
        return new MyViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder,int position) {

        Picasso.get().load(listItems.get(position).getUrl()).into(holder.imageView);

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,ShowImageData.class);
                intent.putExtra("image",listItems.get(position).getUrl());

                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
       ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.img);


        }
    }
}
