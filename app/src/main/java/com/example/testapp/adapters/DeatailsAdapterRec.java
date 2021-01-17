package com.example.testapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testapp.R;
import com.example.testapp.models.DetailsModel;

import java.util.ArrayList;
import java.util.List;

public class DeatailsAdapterRec extends RecyclerView.Adapter<DeatailsAdapterRec.HolerDetails> {
    List<DetailsModel> listDe = new ArrayList<>();

    public void setListDe(List<DetailsModel> listDe) {
        this.listDe = listDe;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public HolerDetails onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rec_item_details , parent , false);
        return new HolerDetails(v);
    }

    @Override
    public void onBindViewHolder(@NonNull HolerDetails holder, int position) {
        holder.name.setText(listDe.get(position).getName());
        holder.email.setText(listDe.get(position).getEmail());
        holder.body.setText(listDe.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return listDe.size();
    }

    public class HolerDetails extends RecyclerView.ViewHolder
    {
        TextView name , email , body ;
        public HolerDetails(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.text_name_details);
            email = itemView.findViewById(R.id.text_email_details);
            body = itemView.findViewById(R.id.text_body_details);
        }
    }
}
