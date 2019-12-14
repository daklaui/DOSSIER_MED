package com.example.dell;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dell.DataBaseCode.DB_CODE;

public class Insert_Analyse extends AppCompatActivity {
EditText Lib;
EditText Desc;
EditText Date;
    SharedPreferences sharedpreferences;
    private DB_CODE dbManager;
FloatingActionButton Ajouter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert__analyse);
        Lib=(EditText)findViewById(R.id.Lib);
        Desc=(EditText)findViewById(R.id.Desc);
        Date=(EditText)findViewById(R.id.date);
        Ajouter=findViewById(R.id.Ajouter_analyse);
        sharedpreferences= getSharedPreferences(MainActivity.MyPREFERENCES, Context.MODE_PRIVATE);
        //SharedPreferences.Editor editor = sharedpreferences.edit();
        final  int id= sharedpreferences.getInt("id",-1);
        dbManager= new DB_CODE(this);
        dbManager.open();
        Ajouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String libelle=Lib.getText().toString();
                final String description=Desc.getText().toString();
                final String date_analyse=Date.getText().toString();

                long insertRow=  dbManager.insert_analyse(libelle,date_analyse,description,id);
              if(insertRow!=-1)
              {
                  startActivity(new Intent(getApplicationContext(),Liste_Des_Analyse.class));
              }
            }
        });

    }
}
