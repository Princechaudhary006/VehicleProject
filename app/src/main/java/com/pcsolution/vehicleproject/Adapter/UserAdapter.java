package com.pcsolution.vehicleproject.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pcsolution.vehicleproject.ChatDetailActivity;
import com.pcsolution.vehicleproject.Models.Users;
import com.pcsolution.vehicleproject.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder>{

    ArrayList<Users> list;
    Context context;

    public UserAdapter(ArrayList<Users> list,Context context){
        this.list=list;
        this.context=context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.sample_show_user,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Users user=list.get(position);
        Picasso.get().load(user.getProfilepic()).placeholder(R.drawable.ic_baseline_account_circle_24).into(holder.image);
        holder.UserName.setText(user.getUserName());
        holder.lastMessage.setText(user.getLastmessage());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, ChatDetailActivity.class);
                intent.putExtra("userId",user.getUserId());
                intent.putExtra("profilepic",user.getProfilepic());
                intent.putExtra("userName",user.getUserName());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView UserName,lastMessage;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image=itemView.findViewById(R.id.profile_image);
            UserName=itemView.findViewById(R.id.UserName);
            lastMessage=itemView.findViewById(R.id.lastMessage);
        }
    }
}

