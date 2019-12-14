package com.example.dell;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dell.DataBaseCode.DB_CODE;

public class Dossier_Med extends AppCompatActivity {
    private DB_CODE dbManager;
EditText poids,hauteur,type_sang,allergie,maladie_chron,glyc,tension;
Button ajouter_dossiermed;
int id;
    SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dossier__med);
        poids=(EditText)findViewById(R.id.poids);
        hauteur=(EditText)findViewById(R.id.hauteur);
        type_sang=(EditText)findViewById(R.id.type_sang);
        allergie=(EditText)findViewById(R.id.allergie);
        maladie_chron=(EditText)findViewById(R.id.maladie_chron);
        glyc=(EditText)findViewById(R.id.glyc);
        tension=(EditText)findViewById(R.id.tension);
        ajouter_dossiermed=(Button)findViewById(R.id.ajouter_dossiermed);
        dbManager= new DB_CODE(this);
        dbManager.open();

        ajouter_dossiermed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String poids_patient=poids.getText().toString();
                final String hauteur_patient=hauteur.getText().toString();
                final String type_sang_patient=type_sang.getText().toString();
                final String allergie_patient=allergie.getText().toString();
                final String maladie_chron_patient=maladie_chron.getText().toString();
                final String glyc_patient=glyc.getText().toString();
                final String tension_patient=tension.getText().toString();
                sharedpreferences= getSharedPreferences(MainActivity.MyPREFERENCES, Context.MODE_PRIVATE);
                //SharedPreferences.Editor editor = sharedpreferences.edit();
                id= sharedpreferences.getInt("id",-1);
                long insertRow=  dbManager.insert_DOSSIER_MEDICAL(poids_patient,hauteur_patient,type_sang_patient,allergie_patient,maladie_chron_patient,glyc_patient,tension_patient,id);
                Toast.makeText(getApplicationContext(),"nb row= "+insertRow,Toast.LENGTH_LONG).show();

            }
        });
    }
}
