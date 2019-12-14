package com.example.dell;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dell.Data.Analyse;

import java.util.ArrayList;

public class Analyse_Adapter extends RecyclerView.Adapter<Analyse_Adapter.ViewHolder> {
    Context context;
    private ArrayList<Analyse> mData;
    private LayoutInflater mInflater;

    public Analyse_Adapter(Context context, ArrayList<Analyse> Analyse) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = Analyse;
        this.context = context;
    }
    @NonNull
    @Override
    public Analyse_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.liste_des_analyse_template, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Analyse_Adapter.ViewHolder holder, int position) {
        final  Analyse analyse = mData.get(position);
        holder.Titre.setText(analyse.getLibelleAnalyse());
        holder.Date.setText(String.valueOf(analyse.getDate_analyse()));
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Toast.makeText(context, "click student " + analyse.getId(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();}

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
