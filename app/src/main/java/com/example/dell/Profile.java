package com.example.dell;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.dell.Data.Patient;
import com.example.dell.DataBaseCode.BD_Dossier_Medical;
import com.example.dell.DataBaseCode.DB_CODE;

public class Profile extends AppCompatActivity {
TextView nom_patient,sexe_patient,adresse_patient,Tele_patient,Date_naissence_patient,email_patient;
    SharedPreferences sharedpreferences;
    private DB_CODE dbManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        nom_patient=(TextView) findViewById(R.id.nomp);
        sexe_patient=(TextView) findViewById(R.id.Sexe);
        adresse_patient=(TextView) findViewById(R.id.Adresse_patient);
        Tele_patient=(TextView) findViewById(R.id.Tele);
        Date_naissence_patient=(TextView) findViewById(R.id.date_nais);
        email_patient=(TextView) findViewById(R.id.email);
        //nom_patient=(TextView) findViewById(R.id.nomp);
        dbManager = new DB_CODE(this);
        dbManager.open();

        sharedpreferences= getSharedPreferences(MainActivity.MyPREFERENCES, Context.MODE_PRIVATE);
        //SharedPreferences.Editor editor = sharedpreferences.edit();
       int id= sharedpreferences.getInt("id",-1);

        Patient p;
        try {p=dbManager.fetch_patient(id);}catch (Exception e){p=null;}

 if(p!=null)
 {
     nom_patient.setText(p.getNom()+" "+p.getPrenom());
     if(p.getSexe()=="H"){sexe_patient.setText("Homme");} else if(p.getSexe()=="F"){sexe_patient.setText("Femme");}
     adresse_patient.setText(p.getAdresse());
     Tele_patient.setText(String.valueOf(p.getNumero()));
     Date_naissence_patient.setText(p.getDate_naiss());
     email_patient.setText(p.getEmail());
 }
       // Cursor cursor = dbManager.fetch_patient();

    }
}
