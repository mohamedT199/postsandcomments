package com.example.testapp.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testapp.R;
import com.example.testapp.models.PostModel;

import java.util.ArrayList;
import java.util.List;

public class PostsRecAdapter extends RecyclerView.Adapter<PostsRecAdapter.MyHolder> {


    public onClicks oncllickk ;
    public  interface onClicks
    {
         void ocCllick(int position);
    }
    public void setOnclickIteem(onClicks click)
    {
        oncllickk = click ;
    }

    List<PostModel> list = new ArrayList<>() ;

    public void setList(List<PostModel> list1) {
        this.list = list1;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rec_item , parent , false);
        return new MyHolder(v , oncllickk);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.mailNmae.setText("Title : " + list.get(position).getTitle());
        holder.body.setText("Body : " + list.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyHolder extends RecyclerView.ViewHolder
    {
        TextView mailNmae , body ;
        public MyHolder(@NonNull View itemView , onClicks cl) {
            super(itemView);
            mailNmae = itemView.findViewById(R.id.mail_name);
            body = itemView.findViewById(R.id.body);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    cl.ocCllick(getAdapterPosition());
                }
            });
        }
    }
}
