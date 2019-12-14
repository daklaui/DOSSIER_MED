package com.example.dell;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.dell.Data.Chirugie;
import com.example.dell.DataBaseCode.DB_CODE;

import java.util.ArrayList;

public class ListeDesChirugies extends AppCompatActivity {
RecyclerView recyclerView;
FloatingActionButton floatingActionButton;
    ArrayList<Chirugie> listedesoperation;
    ChirugieAdapter chirugieAdapter;
    SharedPreferences sharedpreferences;
    private DB_CODE dbManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_des_chirugies);
        recyclerView=findViewById(R.id.listedesoperation);
        floatingActionButton=findViewById(R.id.Ajouter_operation);
        sharedpreferences= getSharedPreferences(MainActivity.MyPREFERENCES, Context.MODE_PRIVATE);
        //SharedPreferences.Editor editor = sharedpreferences.edit();
        int id= sharedpreferences.getInt("id",-1);
        dbManager= new DB_CODE(this);
        dbManager.open();

        RecyclerView.LayoutManager manager = new LinearLayoutManager(ListeDesChirugies.this);
        recyclerView.setLayoutManager(manager);
        listedesoperation=dbManager.getAllOp(id);
        chirugieAdapter= new ChirugieAdapter(ListeDesChirugies.this, listedesoperation);
        // new ItemTouchHelper(simpleCallback).attachToRecyclerView(listeDesNotes);
        recyclerView.setAdapter(chirugieAdapter);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Insert_Chirugie.class));
            }
        });

    }
}
