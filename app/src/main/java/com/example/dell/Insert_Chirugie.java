package com.example.dell;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.dell.DataBaseCode.DB_CODE;

public class Insert_Chirugie extends AppCompatActivity {
EditText Lib,date;
FloatingActionButton floatingActionButton;
    SharedPreferences sharedpreferences;
    private DB_CODE dbManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert__chirugie);

        Lib=(EditText)findViewById(R.id.Lib_chirugie);
        date=(EditText)findViewById(R.id.date_chirugie);
        floatingActionButton=findViewById(R.id.Ajouter_chirugie);
        sharedpreferences= getSharedPreferences(MainActivity.MyPREFERENCES, Context.MODE_PRIVATE);
        //SharedPreferences.Editor editor = sharedpreferences.edit();
        final  int id= sharedpreferences.getInt("id",-1);
        dbManager= new DB_CODE(this);
        dbManager.open();

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String libelle=Lib.getText().toString();
                final String date_chirugie=date.getText().toString();

                long insertRow=  dbManager.insert_CHIRUGIE(libelle,date_chirugie,id);
                if(insertRow!=-1)
                {
                    startActivity(new Intent(getApplicationContext(),ListeDesChirugies.class));
                }
            }
        });

    }
}
