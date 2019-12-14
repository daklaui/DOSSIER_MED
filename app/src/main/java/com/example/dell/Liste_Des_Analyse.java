package com.example.dell;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import com.example.dell.Data.Analyse;
import com.example.dell.DataBaseCode.DB_CODE;

import java.util.ArrayList;

public class Liste_Des_Analyse extends AppCompatActivity {
    RecyclerView listeDesAnalysee;
    private DB_CODE dbManager;
    ArrayList<Analyse>listedesanalyes;
    Analyse_Adapter analyse_adapter;
    FloatingActionButton floatingActionButton;
    SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste__des__analyse);
        listeDesAnalysee=(RecyclerView)findViewById(R.id.listeDesAnalyse);
        floatingActionButton=findViewById(R.id.Ajouter_Analyse);
        sharedpreferences= getSharedPreferences(MainActivity.MyPREFERENCES, Context.MODE_PRIVATE);
        //SharedPreferences.Editor editor = sharedpreferences.edit();
        int id= sharedpreferences.getInt("id",-1);
        dbManager= new DB_CODE(this);
        dbManager.open();

        RecyclerView.LayoutManager manager = new LinearLayoutManager(Liste_Des_Analyse.this);
        listeDesAnalysee.setLayoutManager(manager);
        listedesanalyes=dbManager.getAllAnalyses(id);
        analyse_adapter= new Analyse_Adapter(Liste_Des_Analyse.this, listedesanalyes);
       // new ItemTouchHelper(simpleCallback).attachToRecyclerView(listeDesNotes);
        listeDesAnalysee.setAdapter(analyse_adapter);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Insert_Analyse.class));
            }
        });

    }
}
