package com.example.dell;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dell.Data.Dossier_Medical;
import com.example.dell.Data.Patient;
import com.example.dell.DataBaseCode.DB_CODE;

public class Detaille_Dossier_Med extends AppCompatActivity {
    private DB_CODE dbManager;
    EditText poids,hauteur,type_sang,allergie,maladie_chron,glyc,tension;
    Button ajouter_dossiermed,ajouterdossiermedp;
    SharedPreferences sharedpreferences;
    Dossier_Medical p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detaille__dossier__med);

        poids=(EditText)findViewById(R.id.poids_det);
        hauteur=(EditText)findViewById(R.id.hauteur_det);
        type_sang=(EditText)findViewById(R.id.type_sang_det);
        allergie=(EditText)findViewById(R.id.allergie_det);
        maladie_chron=(EditText)findViewById(R.id.maladie_chron_det);
        glyc=(EditText)findViewById(R.id.glyc_det);
        tension=(EditText)findViewById(R.id.tension_det);
        ajouter_dossiermed=(Button)findViewById(R.id.ajouter_dossiermed_det);
        ajouterdossiermedp=(Button)findViewById(R.id.ajouterdossiermed);

        dbManager= new DB_CODE(this);
        dbManager.open();

        sharedpreferences= getSharedPreferences(MainActivity.MyPREFERENCES, Context.MODE_PRIVATE);
        //SharedPreferences.Editor editor = sharedpreferences.edit();
        int id= sharedpreferences.getInt("id",-1);


        try {p=dbManager.GetDossier_Med(id);}catch (Exception e){p=null;}

        if(p!=null)
        {
            poids.setText(String.valueOf(p.getPoids()));
            hauteur.setText(String.valueOf(p.getHauteur()));
            type_sang.setText(p.getType_sanguin());
            allergie.setText(p.getAllergie());
            maladie_chron.setText(p.getMaladie_chronique());
            glyc.setText(String.valueOf(p.getGlycemie()));
            tension.setText(String.valueOf(p.getTensien()));
        }
        else
        {
            Toast.makeText(getApplicationContext(),"vous n avez pas un dossier medical",Toast.LENGTH_LONG).show();
        }

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

if(dbManager.updateDossierMedical(p.getId(),poids_patient,hauteur_patient,type_sang_patient,allergie_patient,maladie_chron_patient,glyc_patient,tension_patient)!=-1);
                {
                    Toast.makeText(getApplicationContext(),"modifier avec success",Toast.LENGTH_LONG).show();

                }
            }
        });

        ajouterdossiermedp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Dossier_Med.class));
            }
        });
    }
}
