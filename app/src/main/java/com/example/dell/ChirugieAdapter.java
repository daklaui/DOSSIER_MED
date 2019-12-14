package com.example.dell;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dell.Data.Analyse;
import com.example.dell.Data.Chirugie;

import java.util.ArrayList;

public class ChirugieAdapter extends RecyclerView.Adapter<ChirugieAdapter.ViewHolder> {
    Context context;
    private ArrayList<Chirugie> mData;
    private LayoutInflater mInflater;

    public ChirugieAdapter(Context context, ArrayList<Chirugie> Chirugie) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = Chirugie;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.liste_des_analyse_template, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final  Chirugie chirugie = mData.get(position);
        holder.Titre.setText(chirugie.getDiscriptionChirugie());
        holder.Date.setText(String.valueOf(chirugie.getDateChirugie()));
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "click student " + chirugie.getId(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView Titre;
        TextView Date;
        CardView cardView;

        ViewHolder(View itemView) {
            super(itemView);
            Titre = itemView.findViewById(R.id.titre);
            Date = itemView.findViewById(R.id.Date_an);
            cardView = itemView.findViewById(R.id.ll_container);

        }

    }
}
